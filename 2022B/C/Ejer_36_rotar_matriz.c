#include <stdio.h>
#include <stdlib.h>

void imprimir_matriz();
void rotar_matriz();
void rellenar_matriz();

#define FILA 5
#define COLUMNA 5

// int matriz[FILA][COLUMNA] = {
//     {'A', 'N', 'G', 'O', 'P'},
//     {'W', 'B', 'T', 'F', 'D'},
//     {'C', 'M', 'U', 'V', 'Q'},
//     {'K', 'X', 'H', 'E', 'Y'},
//     {'J', 'I', 'S', 'L', 'R'}};
int matriz[FILA][COLUMNA] = {
    {61, 61, 254, 61, 155},
    {61, 61, 61, 254, 61},
    {254, 254, 254, 254, 254},
    {61, 61, 61, 254, 61},
    {61, 61, 254, 61, 155}};

int main() {
    imprimir_matriz();
    rotar_matriz();
    imprimir_matriz();
}

void rellenar_matriz()
{
    int n = 1;
    int i, j;
    for(i = 0; i < FILA; i++)
    {
        for(j = 0; j < COLUMNA; j++)
        {
            matriz[i][j] = n;
            n++;
        }
    }
}

void rotar_matriz()
{
    int ultimo, primero, restar, aux;
    int i, j;
    for(i = 0; i < FILA; i++)
    {
        ultimo = FILA - 1 - i;
        for(j = 0; j < ultimo - 1; j++)
        {
            restar = j - i;
            aux = matriz[i][j];
            matriz[i][j] = matriz[ultimo - restar][i];
            matriz[ultimo - restar][i] = matriz[ultimo][ultimo - restar];
            matriz[ultimo][ultimo - restar] = matriz[j][ultimo];
            matriz[j][ultimo] = aux;
        }
    }
}
void rotar_matriz1()
{
    int ultimo, primero, restar, aux;
    int i, j;
    for(i = 0; i < FILA - 4; i++)
    {
        ultimo = FILA - 1 - i;
        for(j = 0; j < COLUMNA - 1; j++)
        {
            restar = j - i;
            aux = matriz[i][j];
            matriz[i][j] = matriz[ultimo - restar][i];
            matriz[ultimo - restar][i] = matriz[ultimo][ultimo - restar];
            matriz[ultimo][ultimo - restar] = matriz[j][ultimo];
            matriz[j][ultimo] = aux;
        }
    }
}

void imprimir_matriz()
{
    int i, j;
    printf("=============\n");
    for(i = 0; i < FILA; i++)
    {        
        for(j = 0; j < COLUMNA; j++)
            printf("%c ", matriz[i][j]);
        printf("\n");
    }
    printf("=============\n");
}