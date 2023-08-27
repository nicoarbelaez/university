#include <stdio.h>
#include <stdlib.h>

// Intervalo

int sum, mul, inicio, inter, num, op, i, resp;
 
int main () {

    do {

        system("cls");
        
        printf("Inicio: "); 
        scanf("%i", &inicio);
        printf("Intervalo: "); 
        scanf("%i", &inter);
        printf("Cantidad de valores: "); 
        scanf("%i", &num);

        printf("    1. Sumar \n");
        printf("    2. Multiplicar \n");
        printf("    Opcion: ");
        scanf("%i", &op);

        printf("\n Resultado: \n");
        switch (op) {

            case 1:
                for (i = 1; i<=num; ++i) {

                    printf("%i ", inicio);
                    inicio=inicio+inter;
                }
                break;

            case 2:
                for (i = 1; i<=num; ++i) {

                    printf("%i ", inicio);
                    inicio=inicio*inter;
                }
                break;
        }

        printf("\n\n Quiere volver a probar [y/n]: ");
        scanf("%i", &resp);




    } while (resp != 2);


    return 0;
}