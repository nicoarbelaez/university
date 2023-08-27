#include <stdio.h>
#define RANGO 1000

int main()
{
    // ==================== NUMEROS PRIMOS ====================
    int numeroPrimos[RANGO / 2];
    int esPrimo, cantidadNumerosPrimos = 0;
    for(int i = 2; i < RANGO; i++)
    {  
        esPrimo = 1;
        for(int j = 2; j < i; j++)
            if(i % j == 0)
                esPrimo = 0;

        if(esPrimo)
        {
            // printf("%i ", i);
            numeroPrimos[cantidadNumerosPrimos] = i;
            cantidadNumerosPrimos++;
        }
    }

    // ==================== INVERTIR NUMEROS PRIMOS Y REVISA PALIDROMOS ====================
    int numeroPrimosPalindromo[cantidadNumerosPrimos];
    int numeroOriginal, auxiliar;
    int cantidadNumerosPalidromos = 0;

    for(int i = 0; i < cantidadNumerosPrimos; i++)
    {
        auxiliar = 0;
        numeroOriginal = numeroPrimos[i];

        while(numeroPrimos[i] > 0)
        {            
            auxiliar += numeroPrimos[i] % 10;
            auxiliar *= 10;
            numeroPrimos[i] /= 10;
        }

        auxiliar /= 10;
        numeroPrimos[i] = numeroOriginal;;
        if(auxiliar == numeroPrimos[i])
        {
            numeroPrimosPalindromo[cantidadNumerosPalidromos] = auxiliar;;
            cantidadNumerosPalidromos++;
        }
    }

    // ==================== MOSTRAR PRIMO PALIDROMO ====================
    printf("\t-----------------------------\n");
    printf("\t| NUMEROS PRIMOS PALIDROMOS |\n");
    printf("\t-----------------------------\n\n");
    for(int i = 0; i < cantidadNumerosPalidromos; i++)
    {
        printf("%i, ", numeroPrimosPalindromo[i]);
    }
    return 0;
}