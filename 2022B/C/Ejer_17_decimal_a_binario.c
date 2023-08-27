#include <stdio.h>

int main() {


    //areglo con un maximo de 100
    int num, i, j, a[100];
    printf("Digite un numero: ");
    scanf("%i", &num);
    i = 0;

    while (num > 0) 
    {
        a[i] = num % 2;
        num = num / 2;
        ++i;
    }
    
    for (j = i-1; j >= 0; --j) {
        printf("%i ", a[j]);
    }
    

    return 0;
}