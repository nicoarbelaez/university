#include <stdbool.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>

#define COLS_SYSTEM 90
#define PLAYER1 'X'
#define PLAYER2 'O'
// =================== INICIO ===================
void StartGame();
// =================== UN JUGADOR (CPU) ===================
void StartGameMachine();
void MachineGame();
// =================== DOS JUGADORES ===================
void StartGame2vs2();
// =================== PROCESOS ===================
bool MakeMove(int, int);
void ProcessToken(int, int);
int CheckGame();
void PlayerTurn();
// =================== DECORACIONES ===================
int Title();
void createTableThreeRow();
void LocationSymbols(int, int);
void gotoxy(int, int);
void CenterText(char *, int);

int position[3][3], plays, gameMode;
bool tokenBusy[3][3], player1[3][3], player2[3][3];
char playerNow;

int main()
{
    system("mode con: cols=90 lines=30");
    position[0][0] = 1; //
    position[1][0] = 2;
    position[2][0] = 3;
    position[0][1] = 4; //
    position[1][1] = 5;
    position[2][1] = 6;
    position[0][2] = 7; //
    position[1][2] = 8;
    position[2][2] = 9;
    StartGame();
    return 0;
}
// =================== INICIO ===================
void StartGame()
{
    system("cls");
    plays = 0;
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
        {
            tokenBusy[i][j] = false;
            player1[i][j] = false;
            player2[i][j] = false;
        }
    int opcionPlayer, y;
    y = Title();
    CenterText(">>> Escoger el modo de juego <<<", y);
    CenterText("1. Un jugador(CPU)", y + 1);
    CenterText("2. Dos jugadores", y + 2);
    CenterText(" ===> ", y + 3);
    scanf("%i", &opcionPlayer);
    switch (opcionPlayer)
    {
    case 1:
        gameMode = 0;
        system("cls");
        playerNow = PLAYER1;
        StartGameMachine();
        break;
    case 2:
        gameMode = 1;
        system("cls");
        playerNow = PLAYER1;
        StartGame2vs2();
        break;
    }
}
// =================== UN JUGADOR (CPU) ===================
void StartGameMachine()
{
    int tokenPosition;
    if (playerNow == PLAYER1)
    {
        do
        {
            system("cls");
            CreateTableThreeRow();
            printf("Digite el numero donde quiere poner su ficha \n ===> ");
            scanf("%i", &tokenPosition);
        } while (tokenPosition < 1 || tokenPosition > 9 || MakeMove(tokenPosition, 1));
        playerNow = PLAYER1;
        MakeMove(tokenPosition, 0);
    }
    else
        MachineGame();
}
void MachineGame()
{
    int tokenPosition, win;
    if (!player1[1][1] && !player2[1][1])
        tokenPosition = 5;
    else
    {
        for (int i = 0; i < 3; i++)
        {
            win = player1[0][i] + player1[1][i] + player1[2][i];
            if (win == 2 && win)
            {
                printf("hola");
            }
        }
    }
    MakeMove(tokenPosition, 0);
}
// Ensayo de constitución (Proxima semana)
// Taller constitución (Viernes)
// =================== DOS JUGADORES ===================
void StartGame2vs2()
{
    int tokenPosition;
    do
    {
        system("cls");
        CreateTableThreeRow();
        printf("Jugador ( %c ) Digite el numero donde quiere poner su ficha \n ===> ", playerNow);
        scanf("%i", &tokenPosition);
    } while (tokenPosition < 1 || tokenPosition > 9 || MakeMove(tokenPosition, 1));
    MakeMove(tokenPosition, 0);
}
// =================== PROCESOS ===================
bool MakeMove(int numberToken, int query) // "numberToken" Para el valor de la casia. "query" Que consulta (0 = coords) (1 = existe)
{
    if (query == 0)
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                if (numberToken == position[i][j])
                    ProcessToken(i, j);
            }
    else
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                if (numberToken == position[i][j])
                    return tokenBusy[i][j];
            }
}
void ProcessToken(int tokenX, int tokenY)
{
    plays++;
    tokenBusy[tokenX][tokenY] = true;
    if (playerNow == PLAYER1)
        player1[tokenX][tokenY] = true;
    else if (playerNow == PLAYER2)
        player2[tokenX][tokenY] = true;
    system("cls");
    CreateTableThreeRow();
    if (plays > 4)
        if (CheckGame() == 1)
        {
            CenterText("A ganado el jugador ==> ( ", 12);
            printf("%c )", playerNow);
            getch();
            StartGame();
            abort();
        }
        else if (CheckGame() == 0)
        {
            CenterText("==> EMPATE <==", 12);
            getch();
            StartGame();
            abort();
        }
    PlayerTurn();
    if (gameMode == 0)
        StartGameMachine();
    else
        StartGame2vs2();
}
int CheckGame()
{
    bool players[3][3];
    for (int i = 0; i < 3; i++) // Hace una copia de las posiciones del jugador actual
        for (int j = 0; j < 3; j++)
            if (playerNow == PLAYER1)
                players[i][j] = player1[i][j];
            else
                players[i][j] = player2[i][j];
    for (int i = 0; i < 3; i++)
        if (players[0][i] + players[1][i] + players[2][i] == 3) // Horizontal
            return 1;
    for (int i = 0; i < 3; i++)
        if (players[i][0] + players[i][1] + players[i][2] == 3) // Vertical
            return 1;
    int j = 1;
    for (int i = 0; i < 2; i++)
    {
        if (players[0][i * 2] + players[1][1] + players[2][j * 2] == 3) // Diagonal
            return 1;
        j--;
    }
    if (plays >= 9)
        return 0;
    return -1;
}
void PlayerTurn()
{
    if (playerNow == PLAYER1)
        playerNow = PLAYER2;
    else
        playerNow = PLAYER1;
}
// =================== DECORACIONES ===================
// Crea el titulo
int Title()
{
    int x1 = (COLS_SYSTEM / 2) - (COLS_SYSTEM / 4), x2 = (COLS_SYSTEM / 2) + (COLS_SYSTEM / 4);
    int y1 = 0, y2 = 2;
    CenterText("===> Tres en raya <===", 1);
    for (int i = x1; i <= x2; i++)
    {
        gotoxy(i, y1);
        printf("%c", 196); // Simbolo ─
        gotoxy(i, y2);
        printf("%c", 196);
    }
    for (int i = y1; i <= y2; i++)
    {
        gotoxy(x1, i);
        printf("%c", 179); // Simbolo │
        gotoxy(x2, i);
        printf("%c", 179);
    }
    gotoxy(x1, y1);
    printf("%c", 218); // Simbolo ┌
    gotoxy(x2, y1);
    printf("%c", 191); // Simbolo ┐
    gotoxy(x1, y2);
    printf("%c", 192); // Simbolo └
    gotoxy(x2, y2);
    printf("%c", 217); // Simbolo ┘
    printf("\n");
    return y2 + 4;
}
// Crea el tres en raya lineas
void CreateTableThreeRow()
{
    int x = COLS_SYSTEM / 2 - 5, y = Title();
    for (int i = 0; i < 11; i++)
    {
        gotoxy(x + i, y + 1);
        printf("%c", 205);
        gotoxy(x + i, y + 3);
        printf("%c", 205);
    }
    for (int i = 0; i < 5; i++)
    {
        gotoxy(x + 3, y + i);
        printf("%c", 186);
        gotoxy(x + 7, y + i);
        printf("%c", 186);
    }
    gotoxy(x + 3, y + 1);
    printf("%c", 206);
    gotoxy(x + 7, y + 1);
    printf("%c", 206);
    gotoxy(x + 3, y + 3);
    printf("%c", 206);
    gotoxy(x + 7, y + 3);
    printf("%c", 206);
    //
    gotoxy(x - 2, y - 1);
    printf("%c", 201);
    gotoxy(x - 2, y + 5);
    printf("%c", 200);
    gotoxy(x + 12, y - 1);
    printf("%c", 187);
    gotoxy(x + 12, y + 5);
    printf("%c", 188);
    LocationSymbols(x, y);
}
// Crear tabla de juego
void LocationSymbols(int x, int y)
{
    int spaceX = 1, spaceY;
    for (int i = 0; i < 3; i++)
    {
        spaceY = 0;
        for (int j = 0; j < 3; j++)
        {
            if (!tokenBusy[i][j])
            {
                gotoxy(x + spaceX, y + spaceY);
                printf("%i", position[i][j]);
            }
            else
            {
                if (player1[i][j])
                {
                    gotoxy(x + spaceX, y + spaceY);
                    printf("%c", PLAYER1);
                }
                else if (player2[i][j])
                {
                    gotoxy(x + spaceX, y + spaceY);
                    printf("%c", PLAYER2);
                }
            }
            spaceY += 2;
        }
        spaceX += 4;
    }
    printf("\n\n");
}

void gotoxy(int x, int y)
{
    HANDLE manipulador;
    COORD cordCursor;
    manipulador = GetStdHandle(STD_OUTPUT_HANDLE);
    cordCursor.X = x;
    cordCursor.Y = y;
    SetConsoleCursorPosition(manipulador, cordCursor);
}

void CenterText(char *text, int y)
{
    int sizeText = strlen(text) / 2, centerSystem = COLS_SYSTEM / 2;
    gotoxy(centerSystem - sizeText, y);
    printf(text);
}