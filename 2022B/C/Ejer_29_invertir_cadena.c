#include <stdio.h>

int main()
{
    printf("\t-------------------\n\n");
    printf("\t| INVERTIR CADENA |\n");
    printf("\t-------------------\n\n");
    char texto[] = "dabalearrozalazorraelabad", nuevoTexto[200];
    int largoTexto, igual = 1;
    
    largoTexto = sizeof(texto) - 1;
    for (int i = 0; i < largoTexto; i++)
    {        
        // Invierte la cadena
        nuevoTexto[i] = texto[largoTexto - i - 1];
        nuevoTexto[i + 1] = '\0';
    }

    for(int i = 0; i < largoTexto; i++)
    {
        if(texto[i] != nuevoTexto[i])
            igual = 0;
    }
    printf("String original: (%s)", texto);
    printf("\nString invertido: (%s)\n\n", nuevoTexto);

    // Compara las dos cadenas
    if(igual == 1)
        printf(">> Es palidromo");
    else
        printf(">> No es palidromo");
    return 0;
}