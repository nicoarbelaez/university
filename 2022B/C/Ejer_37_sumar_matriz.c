#include <stdio.h>

#define FILAS 4
#define COLUMNAS 4

void imprimirMatriz(int *);

int main()
{
    int m1[FILAS][COLUMNAS] = {{2, 3, 5, 7}, {11, 13, 17, 19}, {23, 29, 31, 37}, {41, 43, 47, 53}};
    int m2[FILAS][COLUMNAS] = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
    int mSuma[COLUMNAS][COLUMNAS], mResta[FILAS][COLUMNAS];

    for(int i = 0; i < FILAS; i++)
    {
        for(int j = 0; j < COLUMNAS; j++)
        {
            mSuma[i][j] = m1[i][j] + m2[i][j];
            mResta[i][j] = m1[i][j] - m2[i][j];
        }
    }
    imprimirMatriz(m1);
    printf("\n====================\n");
    imprimirMatriz(m2);
    printf("\n====================\n");
    imprimirMatriz(mSuma);
    printf("\n====================\n");
    imprimirMatriz(mResta);
    return 0;
}

void imprimirMatriz(int *matriz)
{
    int v = 0;
    for(int i = 0; i < COLUMNAS; i++)
    {
        for(int j = 0; j < FILAS; j++)
            printf("%i ", matriz[j + v]);
        printf("\n");
        v += COLUMNAS;
    }
}