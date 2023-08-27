#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>

void centerText(char *, int);
void createBoxe(int, int, int, int);
void gotoxy(int, int);
void createTabla(int, int, int, int, int, int);

char colsSystem[] = "151", linesSystem[] = "35", modeSystem[30];
int ancho, alto, n_columnas, n_filas;

int main()
{

    system("color 0f");

    // Agrupa en una cadena de caracteres, y sus numeros son variables
    strcat(modeSystem, "mode con: cols=");
    strcat(modeSystem, colsSystem);
    strcat(modeSystem, " lines=");
    strcat(modeSystem, linesSystem);
    system(modeSystem);

    // printf("Digite el ancho y largo de la celda: "); scanf("%i %i", &ancho, &alto);
    // printf("Digite la cantidad de columnas y filas: "); scanf("%i %i", &n_columnas, &n_filas);
    // createTabla (ancho, alto, n_columnas, n_filas);

    // Ancho de columna. Alto de columna. Número de columnas. Número de filas. Distancia X. Distancia Y
    createTabla(10, 2, 15, 15, 0, 0);

    return 0;
}

// ==============Funciones============
// Mueve cursor
void gotoxy(int x, int y)
{
    HANDLE manipulador;                            // Controlador de la ventana
    COORD coordsCursor;                            // Objeto dentro estructura
    manipulador = GetStdHandle(STD_OUTPUT_HANDLE); // Manipulación de la consola
    coordsCursor.X = x;
    coordsCursor.Y = y;
    SetConsoleCursorPosition(manipulador, coordsCursor); // Mueve el cursor
}
// Gnera una caja
void createBoxe(int x1, int y1, int x2, int y2)
{
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
}

// Ancho de columna. Alto de columna. Número de columnas. Número de filas
void createTabla(int colsSpace, int linesSpace, int colsNumber, int linesNumber, int distanX, int distanY)
{

    int i, j;
    const int linesConst = linesSpace;
    for (j = 1; j < linesNumber + 1; j++)
    {

        for (i = 1; i <= colsNumber; i++)
        {
            createBoxe(distanX + colsSpace * (i - 1), distanY, distanX + colsSpace * i, linesSpace + distanY);
        }
        for (i = 1; i <= colsNumber - 1; i++)
        {
            gotoxy(distanX + colsSpace * i, linesSpace - linesSpace + distanY);
            printf("%c", 194); // Simbolo ┬
            gotoxy(distanX + colsSpace * i, linesSpace + distanY);
            printf("%c", 193); // Simbolo ┴
        }
        linesSpace += linesConst;
    }
    linesSpace = linesConst;
    if (linesNumber > 1)
    {
        for (j = 1; j < linesNumber; j++)
        {
            for (i = 1; i <= colsNumber - 1; i++)
            {
                gotoxy(distanX + colsSpace * i, linesSpace + distanY);
                printf("%c", 197); // Simbolo ┼
            }
            gotoxy(distanX, linesSpace + distanY);
            printf("%c", 195); // Simbolo ├
            gotoxy(distanX + colsSpace * i, linesSpace + distanY);
            printf("%c", 180); // Simbolo ┤
            linesSpace += linesConst;
        }
        gotoxy(0, distanY + (linesConst * linesNumber) + 1);
    }
}

// Ingresa un texto, numero de linea
void centerText(char *text, int y)
{

    int numberCols = atoi(colsSystem) / 2, longitud = strlen(text);
    gotoxy(numberCols - (longitud / 2), y);
    printf(text);
}