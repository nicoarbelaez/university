#include <stdio.h>
#include <stdlib.h>

#define ESTUDIANTES 5
#define CORTES 3
#define NOTAS 3
// Se suma 1 a NOTAS para incluir la nota final del curso.
float notasEstdiante[5][ESTUDIANTES];
float nota, totalNotas, notasCorteEstudiante, promedioCorte;

int main()
{
    for(int i = 0; i < ESTUDIANTES; i++)
    {
        // notasCorteEstudiante se reinicia a 0.
        notasCorteEstudiante = 0;

        for(int j = 0; j < CORTES; j++)
        {
            // totalNotas se reinicia a 0.
            totalNotas = 0;

            printf("\tEstudiante N.%i\n", i + 1);
            printf("=========> CORTE %i <=========\n\n", j + 1);

            // Hace la suma de las notas y las hubica en la posicion de la matriz.
            for(int k = 1; k <= NOTAS; k++)
            {
                printf("Digite la nota N.%i: ", k);
                scanf("%f", &nota);
                // totalNotas guarda la suma de las notas de un corte.
                totalNotas += nota;
            }

            promedioCorte = totalNotas / NOTAS;
            // Se guarda la nota del corte en la matriz.
            notasEstdiante[j][i] = promedioCorte;
            // notasCorteEstudiante guarda la suma de todos los cortes.
            notasCorteEstudiante += promedioCorte;

            // Limpia el contenido de a pantalla (CONSOLA).
            system("cls");
        }
        // Saca el promedio de los cortes y lo guarda en un espacio de a matriz.
        notasEstdiante[NOTAS][i] = notasCorteEstudiante / CORTES;
    }
    // Imprime las notas de todos los estudiantes.
    printf("========== SISTEMA DE NOTAS ==========\n");
    for(int i = 0; i < ESTUDIANTES; i++)
    {
        printf("\n---------------------");
        printf("\n>>> Estuiante N.%i\n", i + 1);
        for(int j = 0; j < NOTAS; j++)
        {
            printf("Corte (%i) %.2f \n", j, notasEstdiante[j][i]);
        }
        printf("=> Nota final: %.2f", notasEstdiante[NOTAS][i]);
        printf("\n---------------------");
    }

    return 0;    
}