#include <stdio.h>
#include <stdlib.h>

int destino, personas, dias, planes, total, clienteFiel, respuestaError;
int valorTicket, valorDias, totalDescuento;
/*Arreglos:
[0] = Tiquetes
[1] = Plan basico
[2] = Plan premium*/
int destinoNewYork[3] = {1500, 200, 230}, destinoEuropa[3] = {1300, 150, 180}, destinoCancun[3] = {800, 100, 130};

void menu ();//Muestra la tabla de precios.
void opcion ();//Hace las preguntas y lee respuestas.
void error ();//Arroja un error por un dato invalido.
int totalCosto ();//Hace las operaciones.


/*Función principal se encarga de hacer el condicional multiple
que dependiendo del destino, mandanda a la función "totalCosto".

tambien hace imprimi a factura y todos los resultados finales.*/
int main () {
	
	system ("mode con: cols=120 lines=25"); //Define un ancho y largo de la consolo, por columnas y filas.
	system ("COLOR 0F");//Define el color d ela consolo. 0 = Negro de fondo. F = Blanco de letra. Se puede ver por la función: system(COLOR ZZ).
	opcion ();//Llama a la función "opcion"
	
	switch (destino) {
		
		case 1:
			if (planes == 1) {
				totalCosto(destinoNewYork[0], destinoNewYork[1]);//Envia a a función "totalCosto" los valores del arreglo.
			}
			else {
				totalCosto(destinoNewYork[0], destinoNewYork[2]);
			}
			break;
			
		case 2:
			if (planes == 1) {
				totalCosto(destinoEuropa[0], destinoEuropa[1]);
			}
			else {
				totalCosto(destinoEuropa[0], destinoEuropa[2]);
			}
			break;
			
		case 3:
			if (planes == 1) {
				totalCosto(destinoCancun[0], destinoCancun[1]);
			}
			else {
				totalCosto(destinoCancun[0], destinoCancun[2]);
			}
			break;
		default:
			error();
			
	}
	
	system("cls");//Borra todo de la consola.
	
	printf("\n\tFactura: \n\n");//Se imprime el resultado final mediante condiciones.
	printf("=================================\n");
	if (destino == 1) {
		printf(">> Destino: \tNew York \n");	
	}
	else if (destino == 2) {
		printf(">> Destino: \tEuropa \n");	
	}
	else {
		printf(">> Destino: \tCancun \n");	
	}		
	
	if (planes == 1)
		printf(">> Plan: \tbasico \n");
	else
		printf(">> Plan: \tPremium \n");
	
	printf(">> Peronas: \t%i \n", personas);
	printf(">> Dias: \t%i \n", dias);
	
	if (clienteFiel == 1)
		printf(">> Membresia: \tSi \n");
	else
		printf(">> Membresia: \tNo \n");
	printf(">> Total: \t$%i USD\n", total);
	
	if (totalDescuento > 0) {
		
	}
	if (personas > 3) {
		printf("\n>> Descuentos:");
		printf("\n -- Mas de 3 personas");
		if(clienteFiel == 1)
			printf("\n -- Cliente fiel");
	}
	else if (clienteFiel == 1){
		printf("\n>> Descuentos:");
		printf("\n -- Cliente fiel");	
	}
	
	if (totalDescuento > 0) {
		printf("\n\n>> Descuento: \t\t$%i USD", total-totalDescuento);
		printf("\n>> Total descuento: \t$%i USD", totalDescuento);	
	}
	
	printf("\n=================================\n");
	
	return 0;
}

/*Es la taba de datos que nos da e ejercio. Recreada*/
void menu () {
	
	printf("\t\t\t\t\t\t *** T I M E ***\n\n");
	printf("\n\t //LOS PRECIOS ESTAN SUJETOS POR PERSONA//");
	printf("\n\t=========================================================================================================");
	printf("\n\t|\tDESTINO \t|\tTIQUETE IDA Y VUELTA \t|\tPLAN BASICO \t|\tPLAN PREMIUM \t|");
	printf("\n\t|_______________________________________________________________________________________________________|");
	printf("\n\t|\tNew York \t|\t$1500 USD \t\t|\t$200 USD \t|\t$230 USD \t|");
	printf("\n\t|\tEuropa \t\t|\t$1300 USD \t\t|\t$150 USD \t|\t$180 USD \t|");
	printf("\n\t|\tCancun \t\t|\t$800 USD \t\t|\t$100 USD \t|\t$130 USD \t|");
	printf("\n\t=========================================================================================================\n");
	
}


/*Función "opcion" se encarga de preguntar al usuario y almacenar la respuesta*/
void opcion () {
	
	system ("cls");
	system ("COLOR 0F");
	menu ();
	printf("\n\n >> Que destino desea viajar: \n 1. New York \n 2. Europa \n 3. Cancun \nOpcion: ");
	scanf ("%i", &destino);
	printf("\n >> Cantidad de personas al viaje: ");
	scanf("%i", &personas);
	printf("\n >> Cantidad de dias de viaje: ");
	scanf("%i", &dias);
	printf("\n >> Que tipo de plan desea: \n 1. Plan basico \n 2. Plan premium \nOpcion: ");
	scanf ("%i", &planes);
	
	printf("\n\n__________________________________________________");
	printf("\n >> Tiene membresia de cliente fiel con la agencia: \n 1. Si \n 2. No \nOpcion: ");
	scanf ("%i", &clienteFiel);
	
	system ("cls");
	menu ();
}

/*Función "totalCosto" se encarga de hacer todas las operaciones,
dependiendo de los valores mandados por el condicional multiple*/
int totalCosto (int ticket, int plan) {
	
		valorTicket = personas*ticket;//Mutiplica la cantidad de personas por el valor del tiquete del destino.
		valorDias = dias*(personas*plan);//Multiplica la cantidad de personas por el valor de un dia del plan. Todo eso multiplicado por la cantidad de dias.
		total = valorDias+valorTicket;
		if (personas > 3) { //Condicional doble para el descuento por mayor a 3 personas.
			totalDescuento = total*0.9;
			if (clienteFiel == 1) { //Condicional para el descuento si es miembro fiel.
				totalDescuento *= 0.95;
			}
		}
		else if (clienteFiel == 1) {
			totalDescuento = total * 0.95;
		}
		
	return 0;
}

/*Una función que muestra un mensaje de error si el destino
no existe.*/
void error () {
	
	system ("cls");
	
	printf("\n\n\t**ERORR** |Ingresaste un dato mal| **ERORR**");
	system ("COLOR 4F");
	printf("\n\n\t >>Desea volver al menu: \n\t 1. Si \n\t 2. No \n\t Opcion: ");
	scanf("%i", &respuestaError);
	if (respuestaError == 1) {//Condional para volver al menu  despues del error o de otro caso, terminar el programa.
		main ();
	}
	else {
		exit(0);
	}
	
}
