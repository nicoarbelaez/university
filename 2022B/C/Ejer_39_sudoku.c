#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

#define DIMENSION 9

void imprimir();
int validar(int, int, int);

int sudoku[DIMENSION][DIMENSION] = {
    {4, 8, 5, 9, 7, 3, 2, 6, 0},
    {3, 1, 9, 0, 2, 6, 8, 7, 4},
    {7, 2, 0, 8, 1, 4, 9, 5, 3},
    {2, 4, 3, 1, 6, 0, 5, 9, 7},
    {9, 5, 1, 2, 3, 7, 6, 0, 8},
    {8, 0, 7, 4, 9, 5, 1, 3, 2},
    {0, 9, 8, 3, 4, 2, 7, 1, 6},
    {6, 3, 2, 0, 5, 1, 4, 8, 9},
    {1, 7, 4, 6, 8, 9, 0, 2, 5},
};

int main()
{
    int numero;
    int i, j;
    // for(i = 0; i < DIMENSION; i++)
    //     for(j = 0; j < DIMENSION; j++)
    //         sudoku[i][j] = 0;
    // Pregunta el numero
    for(i = 0; i < DIMENSION; i++)
    {
        for(j = 0; j < DIMENSION; j++)
        {
            if(sudoku[i][j] == 0)
            {
                imprimir();
                printf("Digite el numero que pondra >> ");
                scanf("%i", &numero);
                while(numero < 1 || numero > 9 || validar(numero, i, j) == 1)
                {
                    printf("(El numero no es valido) Digite el numero que pondra >> ");
                    scanf("%i", &numero);
                }
                sudoku[i][j] = numero;
                system("cls");
            }
        }
    }
    imprimir();
    printf("<=> COMPLETADO <=>");

    return 0;
}
// Valida el numero
int validar(int numero, int fila, int columna)
{
    int i, j, k, l;
    for(i = 0; i < DIMENSION; i++)
    {
        if(sudoku[i][columna] == numero)
            return 1;
        if(sudoku[fila][i] == numero)
            return 1;
    }

    int md;
    for(i = 1; i < DIMENSION; i++)
    {
        if(DIMENSION % i == 0)
            md = i;
    }

    int cuadro_fila = 0, cuadro_columna = 0;
    for(i = 0; i < md; i++)
    {
        cuadro_columna = 0;
        for(j = 0; j < md; j++)
        {
            for(k = 0; k < md; k++)
            {
                for(l = 0; l < md; l++)
                {
                    printf(" %i", sudoku[k + cuadro_fila][l + cuadro_columna]);
                    Sleep(125);
                }
                printf("\n");
            }
            printf("=======\n");
            cuadro_columna += md;
        }
        cuadro_fila += md;
    }
    system("pause");
    // 1 5 6 8 4 6 5 7 3
    return 0;
}

void imprimir()
{
    int i, j;
    for(i = 0; i < DIMENSION; i++)
    {
        for(j = 0; j < DIMENSION; j++)
            printf(" %i", sudoku[i][j]);
        printf("\n");
    }
}