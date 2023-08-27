#include <stdio.h>
#include <stdlib.h>

//Contar vocales

int suma, result, i;
char name[50], resp;

int main () {
           
    
    printf("Nombre: ");
    gets(name);

    for (i = 0; i<50; ++i) {
        if (name[i] == 'a' || name[i] == 'A')
            ++suma;
        else if (name[i] == 'e' || name[i] == 'E')
                ++suma;
            else if (name[i] == 'i' || name[i] == 'I')
                    ++suma;
                else if (name[i] == 'o' || name[i] == 'O')
                        ++suma;
                    else if (name[i] == 'u' || name[i] == 'U')
                            ++suma;
    }
    printf("El nombre -%s- tiene %i vocales", name, suma);


    return 0;
}