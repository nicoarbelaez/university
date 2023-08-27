#include <stdio.h>
#include <stdlib.h>

int valorMoto, valorCarro, valorCamioneta, valorCamion, valorTotal;
int vehiculo, modelo, cantidad;

void error();

int main() {

  printf("");

  printf("Que tipo de vehiculo necesitas: ");
  scanf("%d", &vehiculo);
  if (vehiculo != 1 && vehiculo != 2 && vehiculo != 3 && vehiculo != 4) {
    error();
    abort();
  }

  printf("Cual es el modelo solicitado por su merse: ");
  scanf("%d", &modelo);

  switch (vehiculo) {
// Motocicleta
  case 1:

    do {
      printf("\rCual es la cantidad de pasajeros: ");
      scanf("%d", &cantidad);

    } while (cantidad > 2);

    if (modelo < 2000) {
      valorMoto = 400000;
    }
    else if (modelo >= 2000) {
      valorMoto = 300000;
    }
    valorTotal = valorMoto;

    break;

// Automovil
  case 2:
    do {
      printf("\rCual es la cantidad de pasajeros: ");
      scanf("%d", &cantidad);

    } while (cantidad > 4);

    if (modelo < 2000) {
      valorCarro = 550000;
    }
    else if (modelo >= 2000){
      if (cantidad>4){
        valorCarro = 600000;
      }
      else {
        valorCarro = 450000;
      }
    }

    valorTotal = valorCarro;
    break;

// Camioneta
  case 3:
    do {
      printf("\rCual es la cantidad de pasajeros: ");
      scanf("%d", &cantidad);

    } while (cantidad > 4);

    if (modelo < 2000) {
      valorCamioneta = 700000;
    }
    else if (modelo >= 2000){
      valorCamioneta = 650000;
    }
      valorTotal = valorCamioneta;
    break;

// Comion
  case 4:
    printf("\rCual es la cantidad de pasajeros: ");
    scanf("%d", &cantidad);
    valorCamion = 800000;
    valorTotal = valorCamion;
    break;

//ERROR
  default:
    error();
	}

  printf("El valor del seguro es de: %i", valorTotal);

  return 0;
}













//Error
void error () {
	system ("mode con: cols=35 lines=10");
	system("COLOR 4F");
	
	int respuestaError;
	
	printf("\n\t|| ERORR ||");
	printf("\n>>INGRESASTE UN VALOR ERRONEO<<");
	printf("\n\nVolver al menu \n 1.Si \n 2.No \nOpcion: ");
	scanf("%i", &respuestaError);
	
	if (respuestaError == 1) {
		main ();
	}
	else {
		exit(0);
	}
}
