#include <stdio.h>
#include <string.h>
// Rediseñamos nuestra sucursal Virtua Personal para mejorar tu experiencia - Bancolombia.
int main()
{
    printf("\t--------------------------------------\n");
    printf("\t| RE-ORGANIZAR (vocales-consonantes) |\n");
    printf("\t--------------------------------------\n\n");
    char texto[200] = "Rediseñamos nuestra sucursal Virtual Personas para mejorar tu experiencia - Bancolombia.";
    char nuevo[200], vocalesConsonantes[200], invertido[200];
    int longitud, posicion = 0;
    printf("\n[Origina]             ==> %s", texto);
    
    // Quitar caracteres
    longitud = strlen(texto);
    for(int i = 0; i < longitud; i++)
    {
        if(texto[i] > 0 && texto[i] != '.' && texto[i] != ',' && texto[i] != '?' && texto[i] != '-' && texto[i] != ' ')
        {            
            nuevo[posicion] = texto[i];
            posicion++;
            nuevo[posicion] = '\0';
        }
    }
    printf("\n[Organizado]          ==> %s", nuevo);

    // Organizar vocales y consonantes
    char vocales[200], consonantes[200];
    longitud = strlen(nuevo);
    int posicion2 = 0;
    posicion = 0;
    for(int i = 0; i < longitud; i++)
    {
        if(nuevo[i] == 'a' || nuevo[i] == 'e' || nuevo[i] == 'i' || nuevo[i] == 'o' || nuevo[i] == 'u')           
        {
            vocales[posicion] = nuevo[i];
            posicion++;
            vocales[posicion] = '\0';
        }
        else
        {            
            consonantes[posicion2] = nuevo[i];
            posicion2++;
            consonantes[posicion2] = '\0';
        }
    }
    strcpy(vocalesConsonantes, consonantes);
    strcat(vocalesConsonantes, vocales);
    printf("\n[Vocales-Consonantes] ==> %s", vocalesConsonantes);

    // Invertir cadena
    strcpy(invertido, vocales);
    strcat(invertido, consonantes);
    printf("\n[Invertido]           ==> %s", invertido);
}