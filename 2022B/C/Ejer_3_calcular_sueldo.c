#include <stdio.h>
#include <stdlib.h>
#define admin 350
#define merca 400

#define lider 500
#define progra 400
#define analist 350

//Calcuar sueldo


int id, day, area, puesto, cash;
char newOperator;


int main () {

    
    system("color f0");
    do {
        system("cls");

        
        printf("ID del empleado: ");
        scanf("%i", &id);
        printf("Dias trabajados: ");
        scanf("%i", &day);
        printf("Area en que labora: \n");
        printf("  1. Sistemas \n");
        printf("  2. Administrativa \n");
        printf("  Opcion: ");
        scanf("%i", &area);

        switch (area) {
            
            case 1:
                printf(":\n Puesto que desempeña \n");
                printf("  1. Lider \n");
                printf("  2. Programador \n");
                printf("  3. Analista \n");
                printf("  Opcion: ");
                scanf("%i", &puesto);
                switch (puesto)
                {
                    case 1:
                            cash = day * lider;
                        break;

                    case 2:
                            cash = day * progra;
                        break;

                    case 3:
                            cash = day * analist;
                        break;
                }
            break;

            case 2:
                printf(":\n Puesto que desempeña \n");
                printf("  1. Administrador \n");
                printf("  2. Mercadologo \n");
                printf("  Opcion: ");
                scanf("%i", &puesto);
                switch (puesto) {
                    case 1:
                            cash = day * admin;
                        break;

                    case 2:
                            cash = day * merca;
                        break;
                }
            break;
        }
        


        system("cls");

        printf("\n   RESULTADOS \n");
        printf("ID Empleado: %i \n", id);
        printf("Dias que trabajo: %i \n", day);
        printf("Sueldo: %i \n", cash);

        printf ("Deseas realizar otra consulta [y/n]: ");
        scanf("%s", &newOperator);
    } while (newOperator != 'n');

    return 0;
}