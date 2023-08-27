#include <stdio.h>
#include <stdlib.h>

#define COSTO_INGENIERIA 5000000
#define COSTO_MEDICINA 10000000
#define COSTO_DERECHO 3000000

#define NOTA_PROMEDIO 4.0
#define NOTA_PROMEDIO_DESCUENTO 0.90


int carreraSelecionada, semestreEstudiante;
int totalCobro;
double notaPromedio, tieneDescuento;

int main () {
    
    printf(">>> Que carrera estudias \n 1. Ingenieria \n 2. Medicina \n 3. Derecho \nOpcion: ");
    scanf("%i", &carreraSelecionada);
    printf(">>> Cuanto es su nota promedio: ");
    scanf("%lf", &notaPromedio);
    printf(">>> En que semestre va (porfavor el numero del semestre): ");
    scanf("%i", &semestreEstudiante);

    tieneDescuento = 1;

    if (notaPromedio > NOTA_PROMEDIO && semestreEstudiante >= 2) {
        tieneDescuento = NOTA_PROMEDIO_DESCUENTO;
    }

    switch (carreraSelecionada) {


        case 1:
            totalCobro = COSTO_INGENIERIA*tieneDescuento;
            break;
        
        case 2:
            totalCobro = COSTO_MEDICINA*tieneDescuento;
            break;

        case 3:
            totalCobro = COSTO_DERECHO*tieneDescuento;
            break;
        
        default:
            system("cls");
            system("mode con: cols=50 lines= 20");
            system("COLOR 4F");
            printf("ERROR");
    }

    printf("\n\n\n====================\n");
    printf("El total de su carrera queda en: $%i", totalCobro);
    printf("\n\n\n\n");

    return 0;
}