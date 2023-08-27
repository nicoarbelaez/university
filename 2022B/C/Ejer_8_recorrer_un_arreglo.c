#include <stdio.h>

//Recorrer un arreglo

int main() {

    //int es de 4 bits
    double arreglo[] = {1, 2, 3, 4};

    int i = 0;

    //La función sizeof saca el tamaño del arreglo y lo multiplica por 4(bits)
    int tama = sizeof(arreglo) / sizeof(int);

    while ( i < tama) {

        printf("%f ", arreglo[i]);
        i++;
    }

    return 0;
}