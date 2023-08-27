#include <stdio.h>
#define LOGITUD_CADENA 15

int main()
{
    char letras[LOGITUD_CADENA] = {'h','g','j','d','a','M','e','i','b','p','n','f','k','c','l'};
    char temporal;

    // ==================== NORMALIZAR PALABRA ====================
    for(int i = 0; i < LOGITUD_CADENA; i++)    
        if(letras[i] >= 'A' && letras[i] <= 'Z')
            letras[i] = letras[i] + 32;
    
    // ==================== ORGANIZAR PALABRAS ====================
    // Comprueba cada letra con todas
    for(int i = 0; i < LOGITUD_CADENA; i++)
    {
        for(int j = 0; j < LOGITUD_CADENA - 1; j++)
        {
            // La letra actual es menor a la siguiente.
            if(letras[j] < letras[j + 1])
            {
                // La letra actual se guarda en la variable "temporal".
                temporal = letras[j];
                // La letra siguiente se asigna a en la posición actual.
                letras[j] = letras[j + 1];
                // La letra temporal se asigna en la posición siguiente.
                letras[j + 1] = temporal;
            }
        }
    }

    // ==================== MOSTRAR CADENA ====================
    for(int i = 0; i < LOGITUD_CADENA; i++)
        printf("%c ", letras[i]);
    return 0;
}