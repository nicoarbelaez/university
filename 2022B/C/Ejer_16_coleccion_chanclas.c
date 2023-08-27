#include <stdio.h>
#include <stdlib.h>

#define VALOR_CHANCLA 19000
#define DESCUENTO_PAGO_TARGETA 0.90

int tallaZapato, metodoPago, totalCosto, totalPagar;
double incrementoCosto = 1;

int main () {

    do {
        system ("cls");
        printf(">>> Que talla de zapatos eres: ");
        scanf("%i", &tallaZapato);
    }while  (tallaZapato > 45 || tallaZapato < 20 );

    printf(">>> Como sera su metodo de pago \n 1. Efectivo \n 2. Targeta \nOpcion: ");
    scanf("%i", &metodoPago);

    if (tallaZapato >=20 && tallaZapato < 30) {
        incrementoCosto += 0.25;
    }
    else if (tallaZapato >=30 && tallaZapato < 40) {
        incrementoCosto += 0.35;
    }
    else if (tallaZapato >=40 && tallaZapato < 45) {
        incrementoCosto += 0.40;
    }

    totalCosto = VALOR_CHANCLA * incrementoCosto;

    if (metodoPago == 2) {
        totalPagar = totalCosto * DESCUENTO_PAGO_TARGETA;
    }
    else {
        totalPagar = totalCosto;
    }

    printf("\n\n\t FACTURA");
    printf("\n=============================\n");
    printf("El total a pagar es: $%i", totalPagar);
    return 0;
}