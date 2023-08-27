#include <stdio.h>
#include <stdlib.h>
//Factorial



int resp, num, i, fa;


int main () {

    do
    {
        system ("cls");

        do {
            
            printf("\n Digite un numero: ");
            scanf("%i", &num);

            system("cls");

            fa = 1;

            if (num < 0 || num > 10)
            {
                printf("Digita un numero de 0 al 10");
            
            }
            else {
                for (i = 1; i <= num; ++i)                 
                    fa=fa*i;
            }
        } while (num < 0 || num > 10);

        printf(" %i ", fa);
        

        printf("\n\n Otra vez [y/n]; ");
        scanf("%i", &resp);
    } while (resp != 2);
    


    return 0;
}