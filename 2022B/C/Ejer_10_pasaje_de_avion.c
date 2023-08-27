#include <stdio.h>
#include <stdlib.h>

#define IMPUESTO_NACIONAL 0.3
#define IMPUESTO_INTERNACIONAL 0.8
#define VALOR_TICKET 600000

int vueloSeleccion, personasViaje, totalCosto, totalPagar;
double descuentoPersonas;

int main() {

    printf(">>> Su vuelo sera \n 1. Internacional \n 2. Nacional \nOpcion: ");
    scanf("%i", &vueloSeleccion);
    printf(">>> Cuantas personas viajaran: ");
    scanf("%i", &personasViaje);

    descuentoPersonas = 1;

    if (personasViaje == 2)
        descuentoPersonas = 0.80;
    else if (personasViaje == 4)
        descuentoPersonas = 0.70;
    else if (personasViaje == 6)
        descuentoPersonas = 0.60;

    switch (vueloSeleccion) {
        case 1:
            totalCosto = VALOR_TICKET+(VALOR_TICKET*IMPUESTO_INTERNACIONAL);
            break;
        case 2:
            totalCosto = VALOR_TICKET+(VALOR_TICKET*IMPUESTO_NACIONAL);
            break;
        default: 
            system("cls");
            printf("ERROR");
    }

    totalPagar = totalCosto * descuentoPersonas;

    printf("\n\n\n========================\n");
    printf("Costo total de los tickets es de: $%i\n", totalPagar);
    printf("Usted se ahorro: $%i\n", totalCosto-totalPagar);

    return 0;
}