#include <stdio.h>
#include <stdlib.h>

#define CANT_ESTUDIANTES 2
#define NOTAS 3
#define CORTES 3

int main() {
    
    int columnas = CORTES + 2;
    float notas[CANT_ESTUDIANTES][columnas];
    float notaEstudiante, promedioNota, sumaNota;
    // Leer notas y sacar promedio corte.
    for(int i = 0; i < CANT_ESTUDIANTES; i++) {
        printf("=================================");
        printf("\n\tEstudiante #%i (%i) \n", i + 1, CANT_ESTUDIANTES);
        printf("=================================");

        for(int j = 0; j < CORTES; j++) {
            printf("\n\n==> Corte %i <== \n", j + 1);
            sumaNota = 0;

            for(int k = 0; k < NOTAS; k++) {
                printf(" Nota #%i %c ", k + 1, 175);
                scanf("%f", &notaEstudiante);
                sumaNota += notaEstudiante;
            }
            promedioNota = sumaNota / NOTAS;
            notas[i][j] = promedioNota;
            printf("=> Promedio %c %.2f", 175, promedioNota);
        }
        getch ();
        system("cls");
    }
    // Corte mayor.
    int posMayor, posCorteMayor = CORTES;
    float notaMayor;
    for(int i = 0; i < CANT_ESTUDIANTES; i++) {
        notaMayor = notas[i][0];
        posMayor = 1;
        
        for(int j = 0; j < CORTES; j++) {
            if(notas[i][j] > notaMayor) {
                notaMayor = notas[i][j];
                posMayor = j + 1;
            }
        }
        notas[i][posCorteMayor] = posMayor;
    }
    // Promedio del semestre
    int posPromedioSemestre = CORTES + 1;
    float sumaCortes, promedioCortes;
    for(int i = 0; i < CANT_ESTUDIANTES; i++) {
        sumaCortes = 0;
        
        for(int j = 0; j < CORTES; j++) {
            sumaCortes += notas[i][j];
        }
        promedioCortes = sumaCortes / CORTES;
        notas[i][posPromedioSemestre] = promedioCortes;
    }
    // Imprimir notas.
    int posNotaMayor;
    for(int i = 0; i < CANT_ESTUDIANTES; i++) {
        printf("=====[Estudiante #%i]===== \n", i + 1);
        posNotaMayor = notas[i][CORTES];

        for(int j = 0; j < CORTES; j++) {
            printf("=> Corte [%i] %c %.2f \n", j + 1, 175, notas[i][j]);
        }
        printf("\n=> Mejor corte [%i] %c %.2f \n", posNotaMayor, 175, notas[i][posNotaMayor - 1]);
        printf("=> Promedio cortes %c %.2f ", 175, notas[i][posPromedioSemestre]);
        printf("\n=========================\n\n");
    }

    return 0;
}