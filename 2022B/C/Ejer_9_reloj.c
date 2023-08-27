#include <stdio.h>

int main () {
    //Hace un secuencia hasta el ultimo FOR hasta completar un ciclo, y cuelve a empezar
    int hora, minut, secon;
    for (hora = 0; hora < 24; hora++) {
        for (minut = 0; minut < 60; minut++) {
            for (secon = 0; secon < 60; secon++) {
                printf("%i:%i:%i\n", hora, minut, secon);
            }
        }
    }

    return 0;
}