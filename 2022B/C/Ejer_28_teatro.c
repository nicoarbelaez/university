// Se puede hacer mejor con funciones, pero es lo que piden.
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int platea[200], palco1[100], palco2[100], paraiso[100];
    int opcion, numeroSilla;
    char nuevaRespuesta;
    // Todas las silas desocupadas.
    for(int i = 0; i < 200; i++)
    {        
        platea[i] = 0;
        palco1[i] = 0;
        palco2[i] = 0;
        paraiso[i] = 0;
    }
    do
    {
        printf("\t----------------------------\n");
        printf("\t| TEATRO - EL PEZ QUE FUMA |\n");
        printf("\t----------------------------\n\n");
        printf(">>> En que seccion sera la reserva: \n[1] Platea \n[2] Palco 1 \n[3] Palco 2 \n[4] Paraiso \n[0]Salir \n==> ");
        scanf("%i", &opcion);
        switch(opcion)
        {
            case 1:
                printf("\n>>> Seccion PLATEA <<<\n");
                printf("=> Numero de silla [1-200]: ");
                scanf("%i", &numeroSilla);
                while (platea[numeroSilla - 1] == 1 || numeroSilla <= 0 || numeroSilla > 200)
                {
                    printf("   Silla %i ocupada\n=> Numero de silla [1-200]: ", numeroSilla);
                    scanf("%i", &numeroSilla);
                }
                platea[numeroSilla - 1] = 1;
                break;
            case 2:
                printf("\n>>> Seccion PALCO 2 <<<\n");
                printf("=> Numero de silla [1-100]: ");
                scanf("%i", &numeroSilla);
                while (palco2[numeroSilla - 1] == 1 || numeroSilla <= 0 || numeroSilla > 100)
                {
                    printf("   Silla %i ocupada\n=> Numero de silla [1-100]: ", numeroSilla);
                    scanf("%i", &numeroSilla);
                }
                palco2[numeroSilla - 1] = 1;
                break;
            case 3:
                printf("\n>>> Seccion PALCO 1 <<<\n");
                printf("=> Numero de silla [1-100]: ");
                scanf("%i", &numeroSilla);
                while (palco1[numeroSilla - 1] == 1 || numeroSilla <= 0 || numeroSilla > 100)
                {
                    printf("   Silla %i ocupada\n=> Numero de silla [1-100]: ", numeroSilla);
                    scanf("%i", &numeroSilla);
                }
                palco1[numeroSilla - 1] = 1;
                break;
            case 4:
                printf("\n>>> Seccion PARAISO <<<\n");
                printf("=> Numero de silla [1-100]: ");
                scanf("%i", &numeroSilla);
                while (paraiso[numeroSilla - 1] == 1 || numeroSilla <= 0 || numeroSilla > 100)
                {
                    printf("   Silla %i ocupada\n=> Numero de silla [1-100]: ", numeroSilla);
                    scanf("%i", &numeroSilla);
                }
                paraiso[numeroSilla - 1] = 1;
                break;
            default:
                exit(1);
        }
        // Nueva reserva
        printf("\n Otra reserva? [S / N]: ");
        scanf("%s", &nuevaRespuesta);
        system("cls");
    }while (nuevaRespuesta != 'N' && nuevaRespuesta != 'n');

    // Sillas ocupadas y libres.
    int espacio = 0;
    int sillasLibresPlatea = 0, sillasLibresPalco1 = 0, sillasLibresPalco2 = 0, sillasLibresParaiso = 0;
    printf("\t----------------------------\n");
    printf("\t| TEATRO - EL PEZ QUE FUMA |\n");
    printf("\t----------------------------\n\n");
    // PLATEA.
    printf("Visualizacion PLATEA:\n");
    printf("_______________ESCENARIO_______________\n");
    for(int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if(platea[espacio+j] == 0)
            {                
                printf("%c ", 254);
                sillasLibresPlatea++;
            }
            else
                printf("- ");
        }
        printf("\n");
        espacio += 20;
    }
    printf(">> [PLATEA] Sillas libres: %i\n\n", sillasLibresPlatea);
    // PALCO 1.
    espacio = 0;
    printf("Visualizacion PALCO 1:\n");
    printf("_______________ESCENARIO_______________\n");
    for(int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if(palco1[espacio+j] == 0)
            {                
                printf("%c ", 254);
                sillasLibresPalco1++;
            }
            else
                printf("- ");
        }
        printf("\n");
        espacio += 20;
    }
    printf(">> [PALCO 1] Sillas libres: %i\n\n", sillasLibresPalco1);
    // PALCO 2.
    espacio = 0;
    printf("Visualizacion PALCO 2:\n");
    printf("_______________ESCENARIO_______________\n");
    for(int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if(palco2[espacio+j] == 0)
            {                
                printf("%c ", 254);
                sillasLibresPalco2++;
            }
            else
                printf("- ");
        }
        printf("\n");
        espacio += 20;
    }
    printf(">> [PALCO 2] Sillas libres: %i\n\n", sillasLibresPalco2);
    // PARAISO.
    espacio = 0;
    printf("Visualizacion PARAISO:\n");
    printf("_______________ESCENARIO_______________\n");
    for(int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 20; j++)
        {
            if(paraiso[espacio+j] == 0)
            {                
                printf("%c ", 254);
                sillasLibresParaiso++;
            }
            else
                printf("- ");
        }
        printf("\n");
        espacio += 20;
    }
    printf(">> [PARAISO] Sillas libres: %i\n\n", sillasLibresParaiso);
    return 0;    
}