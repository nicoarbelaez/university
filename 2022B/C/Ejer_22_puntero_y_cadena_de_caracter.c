#include <stdio.h>
#include <stdlib.h>

// El puntero * permite almacenar una cantidad de caracteres y tomara como
// inicio el primer caracter y se recorrera hasta encontrar el \0 que determina
// el fin de la cadena.

void sizeConsol (char *, char *);

int colsSystem, linesSystem;

int main () {
	
    sizeConsol("80", "25");
    
}

// Modifica el tamaño de la consola
void sizeConsol (char *anchoConsole, char *altoConsole) {
	
    char modeSystem[30] = "mode con: cols=";
    colsSystem = atoi(anchoConsole);
    linesSystem = atoi(altoConsole);

    strcat(modeSystem, anchoConsole);
    strcat(modeSystem, " lines="); strcat(modeSystem, altoConsole);    
    system(modeSystem);
    printf("%s\n", modeSystem);
}