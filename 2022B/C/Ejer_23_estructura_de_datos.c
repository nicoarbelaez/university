#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char destino[20];
    float ticket;
    float planBasico;
    float planPremiun;

} VIAJES;

int main () {
    
    int i, j;
    VIAJES tour[9];

    for (i = 0; i<2; i++){

        printf("\nDestino: "); fgets(tour[i].destino, 30, stdin);
        printf("Ticket: "); scanf("%f", &tour[i].ticket);
        printf("Plan basico: "); scanf("%f", &tour[i].planBasico);
        printf("Plan premium: "); scanf("%f", &tour[i].planPremiun);
        fflush(stdin);

    }
    system("cls");
    for (j = 0; j < i; j++)
    {
        printf("%s $%.2f $%.2f $%.2f\n", tour[j].destino, tour[j].ticket, tour[j].planBasico, tour[j].planPremiun);
    }
    
    return 0;
}