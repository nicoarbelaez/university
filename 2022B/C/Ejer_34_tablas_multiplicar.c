#include <stdio.h>
#include <stdlib.h>

#define TABLAS 10
#define DIGITOS 10

int main() {

    int tablasMultiplicar[TABLAS][DIGITOS];

    for (int i = 0; i < TABLAS; i++) {
        
        for (int j = 0; j < DIGITOS; j++)
        {
            tablasMultiplicar[i][j] = (i + 1) * (j + 1);
        }
        
    }
    
    for (int i = 0; i < TABLAS; i++) {
        printf("====[Tabla de multiplicar %i]====\n", i + 1);
        
        for (int j = 0; j < DIGITOS; j++)
        {
        printf("\t%i * %i = %i \n", i + 1, j + 1, tablasMultiplicar[i][j]);
        }
        printf("================================\n\n");
        getch();
        
    }
    
    return 0;
}