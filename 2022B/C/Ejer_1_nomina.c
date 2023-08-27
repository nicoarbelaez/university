#include <stdio.h>
#define PESOS 18
//Nómina

int main () {


    int entry, exit, total, importe, cash, cambio;
    int b1, b2, b3, b4, b5, b6, b7;
    printf(" Hora de entrada: ");
    scanf("%i", &entry);
    printf(" Hora de saida: "); 
    scanf("%i", &exit);

    total = exit - entry;
    printf(" Horas de servicio: %i", total);

    importe = total * PESOS;
    printf("\n\n Importe a pagar: %i \n Insertar dinero: ", importe);
    scanf("%i", &cash);
    cambio = cash - importe;
    printf("\n\n Cambio: %i", cambio);
    
    b1 = cambio / 100;
    cambio = cambio - (b1 * 100);
    b2 = cambio / 10;
    cambio = cambio - (b2 * 10);
    b3 = cambio / 1;
    cambio = cambio - (b3 * 11);

    printf("$\n 100 = %i", b1);
    printf("$\n 10 = %i", b2);
    printf("$\n 1 = %i", b3);
    
    
    return 0;
}