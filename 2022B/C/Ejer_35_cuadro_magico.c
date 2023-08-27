#include <stdio.h>
#include <stdlib.h>

int cuadro[3][3] = {0};

void cuadrado_magico();

int main() {

    int numero;       
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            do{
                system("cls");
                cuadrado_magico();
                printf("\n=> Digite un numero (1-9) %c ", 175);
                scanf("%i", &numero);
            }while(numero < 1 || numero > 9);
            cuadro[i][j] = numero;
            system("cls");
            cuadrado_magico();
        }
    }
    // Suma todo
    int sumas[8];
    int longArray = sizeof(sumas) / sizeof(int);
    for(int i = 0; i < longArray; i++) {
        sumas[i] = 0;

        for(int j = 0; j < 3; j++) {
            if(i < 3)
                sumas[i] += cuadro[i][j];
            else if(i < 6)
                sumas[i] += cuadro[j][i - 3];
            else if(i == 6)
                sumas[i] += cuadro[j][j];
            else
                sumas[i] += cuadro[j][2 - j];
        }
    }
    // Pregunta la suma.
    int fila, columna, diagonal;
    printf("\n=> Digite la fila que sumara (1-3) %c ", 175);
    scanf("%i", &fila);
    fila --;
    printf("==> %i + %i + %i = %i\n", cuadro[fila][0], cuadro[fila][1], cuadro[fila][2], sumas[fila]);
    printf("\n=> Digite la columna que sumara (1-3) %c ", 175);
    scanf("%i", &columna);
    columna --;
    printf("==> %i + %i + %i = %i\n", cuadro[0][columna], cuadro[1][columna], cuadro[2][columna], sumas[columna + 3]);
    printf("\n=> Digite la diagonal que sumara (1-2) %c ", 175);
    scanf("%i", &diagonal);
    diagonal -= 1;
    printf("==> %i + %i + %i = %i\n", cuadro[0][diagonal * 2], cuadro[1][1], cuadro[2][2 - (diagonal * 2)], sumas[diagonal + 6]);
    // Comprueba si es magico.
    int esCuboMagico = 0;
    
    for(int i = 0; i < longArray; i++)
        esCuboMagico += sumas[i];
    printf("\n==============================\n\n");

    if(esCuboMagico == sumas[0] * longArray)
        printf("[[ SI es un cuadrado magico ]]", esCuboMagico, sumas[0], longArray);
    else
        printf("[[ NO es un cuadrado magico ]]", esCuboMagico, sumas[0], longArray);

    return 0;
}

void cuadrado_magico() {

    for(int i = 0; i < 3; i++) {
        printf("\t");

        for(int j = 0; j < 3; j++)
            printf("%i ", cuadro[i][j]);
        printf("\n");
    }
}