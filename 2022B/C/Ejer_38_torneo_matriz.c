#include <stdio.h>
#include <stdlib.h>

#define FILAS 4
#define COLUMNAS 8

void imprimir_tablas();

char *estadisticas = "PJ PG PE PP GF GC Pts GD";
int tablaPosiciones[FILAS][COLUMNAS] = {
    {19, 8, 8, 3, 23, 15},
    {19, 9, 4, 6, 24, 23},
    {19, 9, 4, 6, 23, 25},
    {19, 7, 9, 3, 21, 11}};
char *equipos[FILAS] = {"Chelsea", "Arsenal", "Tottenham Hotspur", "West Ham United"};

int main()
{
    for(int i = 0; i < FILAS; i++)
    {
        // Puntos (Pts)
        tablaPosiciones[i][6] = tablaPosiciones[i][2] + (tablaPosiciones[i][1] * 3);
        // Goles diferencia (GD)
        tablaPosiciones[i][7] = tablaPosiciones[i][4] - tablaPosiciones[i][5];
    }
    int primero, ultimo, masGoles, posPrimero = 0, posUltimo = 0, posMasGoles = 0;
    primero = tablaPosiciones[0][6];
    ultimo = tablaPosiciones[0][6];
    masGoles = tablaPosiciones[0][4];

    for(int i = 0; i < FILAS; i++)
    {
        if(primero < tablaPosiciones[i][6])
            posPrimero = i;
        if(ultimo > tablaPosiciones[i][6])
            posUltimo = i;
        if(masGoles < tablaPosiciones[i][4])
            posMasGoles = i;
    }
    imprimir_tablas();
    printf("\n=> Primer equipo: %s", equipos[posPrimero]);
    printf("\n=> Ultimo equipo: %s", equipos[posUltimo]);
    printf("\n=> Equipo con mas goles (GF): %s", equipos[posMasGoles]);
    return 0;
}

void imprimir_tablas()
{
    char *auxNombre;
    printf("\t%s\n", estadisticas);

    for(int i = 0; i < FILAS; i++)
    {
        auxNombre = equipos[i];
        for(int j = 0; j < 7; j++)
            printf("%c", auxNombre[j]);
        printf(" ");

        for(int j = 0; j < COLUMNAS; j++)
        {
            if (j < COLUMNAS - 1)
            {
                if (tablaPosiciones[i][j] < 10 && tablaPosiciones[i][j] > 0)
                    printf(" %i ", tablaPosiciones[i][j]);
                else
                    printf("%i ", tablaPosiciones[i][j]);
                continue;
            }
            if (tablaPosiciones[i][j] < 10 && tablaPosiciones[i][j] > 0)
                printf("  %i ", tablaPosiciones[i][j]);
            else
                printf(" %i ", tablaPosiciones[i][j]);
        }
        printf("\n");
    }
    
}