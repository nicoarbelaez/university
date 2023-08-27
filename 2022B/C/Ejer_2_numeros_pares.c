#include <stdio.h>
//Numeros pares

int main () {

    int num, i = 0, suma = 0;
    printf("Numero limite: ");
    scanf("%i", &num);
    while (i <= num)
    {
        suma = suma + i;
        
        printf("%i ", i);
        i = i+2;
        
    }
    printf("\n La suma de los numeros es: %i", suma);

    return 0;
}