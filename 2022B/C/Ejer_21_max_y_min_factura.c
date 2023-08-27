#include <stdio.h>


int main () {
    
    int numFactura, minFactura, maxFactura, i;
    float monto,  minMonto, maxMonto, totalMonto = 0, promedioVenta;
        
    printf("Ingrese el numero de factura: ");
    scanf("%i", &numFactura);
    while(numFactura != 0) {
        printf("Ingrese el monto de la facntura: ");
        scanf("%f", &monto);
        i++;
        totalMonto = totalMonto+monto;
        if (numFactura ==  1) {
            minFactura = numFactura;
            maxFactura = numFactura;
            minMonto = monto;
            maxMonto = monto;
        }
        else {
            if (monto>maxMonto){
                maxFactura = numFactura;
                maxMonto = monto;
            }
            else {
                minFactura = numFactura;
                minMonto = monto;
            }
        }
        printf("Ingrese el numero de factura: ");
        scanf("%i", &numFactura);
        
    }
    system("cls");
    printf("Mejor venta N.%i con un monto de: $%.1f\n", maxFactura, maxMonto);
    printf("Peor venta N.%i con un monto de: $%.1f", minFactura, minMonto);
    promedioVenta=totalMonto/i;
    printf("\n\nEl promedio de ventas es de: $%.1f", promedioVenta);

return 0;
}