#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

void createArchivo ();
void cargarArchivo ();
void ImprimirArchivo();
void ConsultaArchivo();
void modificacionArchivo();

typedef struct {
    int idViaje;
    char destino[20];
    float ticket;
    float planBasico;
    float planPremium;

} AGENCIA;


char fileName[20];

int main () {
    
    int num;
    
    printf("\nNombre del archivo: "); gets(fileName);
    do {
        system("cls");
        printf("\t ***%s***", fileName);
        printf("\n 1. Crear \n 2. Cargar \n 3. Listar \n 4. Consulta \n 5. Modificacion \nOpcion: ");
        scanf("%i", &num);
        switch (num) {
            case 1:
                createArchivo ();
                break;
            
            case 2:
                cargarArchivo ();
                break;
                
            case 3:
                ImprimirArchivo ();
                break;
                
            case 4:
                ConsultaArchivo();
                break;
                
            case 5:
                modificacionArchivo();
                break;

        }
    } while(num!=6);


    return 0;
}

void createArchivo () {
    FILE *archivo;
    archivo = fopen(fileName,"wb"); // "wb" Write binary (Crear archivo binario)
    if (archivo==NULL)
        exit(1);
    fclose(archivo);
    printf("\n***Archivo credado con exito***\n");
    getch();
}

void cargarArchivo () {
    FILE *archivo;
    archivo = fopen(fileName,"ab"); // "ab" Add binary (Agregar al archivo)
    if (archivo==NULL)
        exit(1);

    AGENCIA viaje;

    printf("ID: "); scanf("%i", &viaje.idViaje);
    fflush(stdin);
    printf("Destino: "); gets(viaje.destino);
    printf("Ticket: "); scanf("%f", &viaje.ticket);
    printf("Plan basico: "); scanf("%f", &viaje.planBasico);
    printf("Plan premium: "); scanf("%f", &viaje.planPremium);

    // Dirección variable (Struct). Tamaño en bites del struct. 1 bloque (sin vectores). Nombre logico del archivo
    fwrite(&viaje, sizeof(AGENCIA), 1, archivo);
    fclose(archivo);
}

void ImprimirArchivo() {
    FILE *archivo;
    archivo = fopen(fileName,"rb"); // "rb" Read binary (Leer el archivo)
    if (archivo==NULL)
        exit(1);
    
    AGENCIA viaje;
    fread(&viaje, sizeof(AGENCIA), 1, archivo);
    while  (!feof(archivo)) {

        printf("\n\n%i | %s | %.2f | %.2f | %.2f", viaje.idViaje, viaje.destino, viaje.ticket, viaje.planBasico, viaje.planPremium);
        fread(&viaje, sizeof(AGENCIA), 1, archivo);        
    }
    fclose(archivo);
    getch();
}

void ConsultaArchivo(){
    FILE *archivo;
    archivo = fopen(fileName,"rb"); // "rb" Read binary (Leer el archivo)
    if (archivo==NULL)
        exit(1);

    int id, existe = 0;
    printf("ID del viaje: "); scanf("%i", &id);
    AGENCIA viaje;
    fread(&viaje, sizeof(AGENCIA), 1, archivo);
    while (!feof(archivo)) {
        if (id==viaje.idViaje){
            printf("\n\n%i | %s | %.2f | %.2f | %.2f", viaje.idViaje, viaje.destino, viaje.ticket, viaje.planBasico, viaje.planPremium);
            existe=1;
            break;
        }
        fread(&viaje, sizeof(AGENCIA), 1, archivo);
    }
    if (existe==0)
        printf("No existe un viaje con el ID %i", id);
    fclose(archivo);
    getch();
}

void modificacionArchivo(){
    FILE *archivo;
    archivo = fopen(fileName,"r+b"); // "rb" Read binary (Leer el archivo)
    if (archivo==NULL)
        exit(1);

    int id, existe = 0;
    printf("ID de que modificara: "); scanf("%i", &id);
    AGENCIA viaje;
    fread(&viaje, sizeof(AGENCIA), 1, archivo);
    while (!feof(archivo)) {
        if (id==viaje.idViaje){
            printf("\n\n%i | %s | %.2f | %.2f | %.2f", viaje.idViaje, viaje.destino, viaje.ticket, viaje.planBasico, viaje.planPremium);
            printf("\n\nIngrese el nuevo precio del ticket: "); scanf("%f", &viaje.ticket);
            fflush(stdin);
            printf("Destino: "); gets(viaje.destino);
            int pos=ftell(archivo)-sizeof(AGENCIA);
            fseek(archivo,pos,SEEK_SET);
            fwrite(&viaje, sizeof(AGENCIA), 1, archivo);
            printf("\n\t***Se modifico con exito***");
            existe=1;
            break;
        }
        fread(&viaje, sizeof(AGENCIA), 1, archivo);
    }
    if (existe==0)
        printf("No existe un viaje con el ID %i", id);
    fclose(archivo);
    getch();
}
