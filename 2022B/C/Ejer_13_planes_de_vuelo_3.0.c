#include <stdio.h>
#include <stdlib.h>

#define DESCUENTO_MEMBRESIA 0.95
#define DESCUENTO_PERSONAS 0.90

int destino, personas, dias, planes, total, clienteFiel, destinoEscogido;
int valorTicket, valorDias, totalDescuento;

/*Arreglos:
[0] = New York
[1] = Europa
[2] = Cancún*/
int valoresTickets[3] = {1500, 1300, 800}, valorPlanBasico[3] = {200, 150, 100}, valorPlanPremium[3] = {230, 180, 130};

void mostarMenu ();
void hacerPreguntas ();
int totalCosto ();
void mostrarFactura ();
void nuevaOperacion();
void error ();


int main () {
	
	system ("mode con: cols=120 lines=35"); //Define un ancho y largo de la consolo, por columnas y filas.
	system ("COLOR 0F");//Define el color d ela consolo. 0 = Negro de fondo. F = Blanco de letra. Se puede ver por la funci�n: system(COLOR ZZ).
	hacerPreguntas ();
	
	switch (destino) {
		
		case 1:
            destinoEscogido = 0;
			if (planes == 1) {
				totalCosto(valoresTickets[destinoEscogido], valorPlanBasico[destinoEscogido]);
			}
			else {
				totalCosto(valoresTickets[destinoEscogido], valorPlanPremium[destinoEscogido]);
			}
			break;
			
		case 2:
            destinoEscogido = 1;
			if (planes == 1) {
				totalCosto(valoresTickets[destinoEscogido], valorPlanBasico[destinoEscogido]);
			}
			else {
				totalCosto(valoresTickets[destinoEscogido], valorPlanPremium[destinoEscogido]);
			}
			break;
			
		case 3:
            destinoEscogido = 2;
			if (planes == 1) {
				totalCosto(valoresTickets[destinoEscogido], valorPlanBasico[destinoEscogido]);
			}
			else {
				totalCosto(valoresTickets[destinoEscogido], valorPlanPremium[destinoEscogido]);
			}
			break;

		default:
			error();
			
	}
    mostrarFactura ();
    system("pause");
    nuevaOperacion();
	
	return 0;
}

/*Es la taba de datos que nos da el ejercio. Recreada*/
void mostarMenu () {
	
	printf("\t\t\t\t\t\t *** T I M E ***\n\n");
	printf("\n\t //LOS PRECIOS ESTAN SUJETOS POR PERSONA//");
	printf("\n\t=========================================================================================================");
	printf("\n\t|\tDESTINO \t|\tTIQUETE IDA Y VUELTA \t|\tPLAN BASICO \t|\tPLAN PREMIUM \t|");
	printf("\n\t|_______________________________________________________________________________________________________|");
	printf("\n\t|\tNew York \t|\t$%i USD \t\t|\t$%i USD \t|\t$%i USD \t|", valoresTickets[0], valorPlanBasico[0], valorPlanPremium[0]);
	printf("\n\t|\tEuropa \t\t|\t$%i USD \t\t|\t$%i USD \t|\t$%i USD \t|", valoresTickets[1], valorPlanBasico[1], valorPlanPremium[1]);
	printf("\n\t|\tCancun \t\t|\t$%i USD \t\t|\t$%i USD \t|\t$%i USD \t|", valoresTickets[2], valorPlanBasico[2], valorPlanPremium[2]);
	printf("\n\t=========================================================================================================\n");
	
}

/*Hace las preguntas*/
void hacerPreguntas () {
	
	system ("cls");
	system ("COLOR 0F");
	mostarMenu ();
	printf("\n\n >> Que destino desea viajar: \n 1. New York \n 2. Europa \n 3. Cancun \nOpcion: ");
	scanf ("%i", &destino);
    if (destino != 1 && destino != 2 && destino != 3) {
        error();
        return 0;
    }
	printf("\n >> Cantidad de personas al viaje: ");
	scanf("%i", &personas);
	printf("\n >> Cantidad de dias de viaje: ");
	scanf("%i", &dias);
	printf("\n >> Que tipo de plan desea: \n 1. Plan basico \n 2. Plan premium \nOpcion: ");
	scanf ("%i", &planes);
    if (planes != 1 && planes != 2) {
        error();
        return 0;
    }
	
	printf("\n\n__________________________________________________");
	printf("\n >> Tiene membresia de cliente fiel con la agencia: \n 1. Si \n 2. No \nOpcion: ");
	scanf ("%i", &clienteFiel);
    if (clienteFiel != 1 && clienteFiel != 2) {
        error();
        return 0;
    }
}

/*Hace las operaciones para la factura*/
int totalCosto (int ticket, int plan) {
	
		valorTicket = personas*ticket;//Mutiplica la cantidad de personas por el valor del tiquete del destino.
		valorDias = dias*(personas*plan);//Multiplica la cantidad de personas por el valor de un dia del plan. Todo eso multiplicado por la cantidad de dias.
		total = valorDias+valorTicket;
		if (personas > 3) { //Condicional doble para el descuento por mayor a 3 personas.
			totalDescuento = total*DESCUENTO_PERSONAS;
			if (clienteFiel == 1) { //Condicional para el descuento si es miembro fiel.
				totalDescuento *= DESCUENTO_MEMBRESIA;
			}
		}
		else if (clienteFiel == 1) {
			totalDescuento = total * DESCUENTO_MEMBRESIA;
		}
		
	return 0;
}

//Muestra la factura
void mostrarFactura (){
    
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

}

//Empieza de nuevo
void nuevaOperacion() {

    int respuestaNueva;
	printf("\n\n\t >>Desea hacer otro pago: \n\t 1. Si \n\t 2. No \n\t Opcion: ");
	scanf("%i", &respuestaNueva);
	if (respuestaNueva == 1) {
		main ();
	}
	else {
		exit(0);
	}
}

/*Una funcion para arrojar error*/
void error () {
	
    int respuestaError;

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
