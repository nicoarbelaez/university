#include <stdio.h>
#include <stdlib.h>

//Fibonacci

int num, pre, ante, resp, suma, i;

int main () {

    do {

        system("cls");
        printf("Introduce un numero: ");
        scanf("%i", &num);
        ante=0;
        pre=1;
        for (i = 1; i <= num; ++i) {
            
            if (i==1) {
                printf("\n F%i -> 1", i);    
            }
            else {
                printf("\n F%i -> %i + %i = %i", i, pre, ante, suma=ante+pre);
                ante=pre;
                pre=suma;
                suma = ante + pre;
            }

        }
        suma=0;
        printf("\n Quiere probar de nuevo: [y/n]: ");
        scanf("%i", &resp);
    } while (resp != 2);
    



    return 0;
}