#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>

void centerText (char *, int);
void generateBoxe (int, int, int, int);
void gotoxy (int, int);

char colsSystem[] = "110", linesSystem[] = "30", modeSystem[30];

int main (){

    system("color 0f");
    
    printf("Columnas: "); scanf("%s", &colsSystem);
    printf("Filas: "); scanf("%s", &linesSystem);

    //Agrupa en una cadena de caracteres, y sus numeros son variables
    strcat(modeSystem, "mode con: cols="); strcat(modeSystem, colsSystem);
    strcat(modeSystem, " lines="); strcat(modeSystem, linesSystem);    
    system(modeSystem);

    //gotoxy(10, 10); printf("Hola");
    generateBoxe(0,0 , 3,4);
    centerText("S I S T E M A", 2);

    
    return 0;
}


void gotoxy (int x, int y) {
    HANDLE manipulador; //Controlador de la ventana
    COORD coordsCursor; //Objeto dentro estructura
    manipulador = GetStdHandle(STD_OUTPUT_HANDLE); //Manipulación de la consola
    coordsCursor.X =x;
    coordsCursor.Y = y;
    SetConsoleCursorPosition(manipulador,coordsCursor); //Mueve el cursor
}

void generateBoxe (int x1, int y1,  int x2, int y2) {
    int i;
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

//Ingresa un texto, numero de linea
void centerText (char *text, int y){
    
    int numberCols = atoi(colsSystem)/2, longitud = strlen(text);
    gotoxy (numberCols-(longitud / 2), y);
    printf(text);
}