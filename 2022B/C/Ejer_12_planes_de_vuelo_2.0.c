#include <stdio.h>
#include <stdlib.h>

#define NEW_YORK_TIQUETE 1500
#define NEW_YORK_BASICO 200
#define NEW_YORK_PREMIUM 230
#define EUROPA_TIQUETE 1300
#define EUROPA_BASICO 150
#define EUROPA_PREMIUM 180
#define CANCUN_TIQUETE 800
#define CANCUN_BASICO 100
#define CANCUN_PREMIUM 130

int destino, dias, planes, personas, clienteFiel;
int total, totalDescuento, valorDias, valorTicket;
float descuentoMembresia = 0.90, descuentoPersonas = 0.95;

int main (){
	
	system ("mode con: cols=120 lines=25"); //Define un ancho y largo de la consolo, por columnas y filas.
	//Imprimi las tablas de texto.
	printf("\t\t\t\t\t\t *** T I M E ***\n\n");
	printf("\n\t //LOS PRECIOS ESTAN SUJETOS POR PERSONA//");
	printf("\n\t=========================================================================================================");
	printf("\n\t|\tDESTINO \t|\tTIQUETE IDA Y VUELTA \t|\tPLAN BASICO \t|\tPLAN PREMIUM \t|");
	printf("\n\t|_______________________________________________________________________________________________________|");
	printf("\n\t|\tNew York \t|\t$1500 USD \t\t|\t$200 USD \t|\t$230 USD \t|");
	printf("\n\t|\tEuropa \t\t|\t$1300 USD \t\t|\t$150 USD \t|\t$180 USD \t|");
	printf("\n\t|\tCancun \t\t|\t$800 USD \t\t|\t$100 USD \t|\t$130 USD \t|");
	printf("\n\t=========================================================================================================\n");
	
	//Hace preguntas y lee respuestas.
	printf("\n\n >>Que destino quiere viajar: \n 1. New York \n 2. Europa \n 3. Cancun \nOpcion: ");
	scanf("%i", &destino);
	printf("\n >>Cuantas personas viajan: ");
	scanf("%i", &personas);
	printf("\n>> Cuantos dias de viaje: ");
	scanf("%i", &dias);
	printf("\n >> Que tipo de plan desea: \n 1. Plan basico \n 2. Plan premium \nOpcion: ");
	scanf ("%i", &planes);  
	printf("\n\n__________________________________________________");
	printf("\n >> Tiene membresia de cliente fiel con la agencia: \n 1. Si \n 2. No \nOpcion: ");
	scanf ("%i", &clienteFiel);
	
	//Condicional multiple por destino.
	  switch (destino) {
	    case 1:
	
	      valorTicket = personas*NEW_YORK_TIQUETE;	//Calcula el valor del ticket par persona.
	      if (planes == 1) {	//Doble condicional para calcular el valor de dias por plan y peronas.
	        valorDias = dias*(personas*NEW_YORK_BASICO);
	      }
	      else {
	        valorDias = dias*(personas*NEW_YORK_PREMIUM);
	      }
	      total = valorTicket + valorDias;
	      
	      break;
	      
	    case 2:
	      valorTicket = personas*EUROPA_TIQUETE;
	      if (planes == 1) {
	        valorDias = dias*(personas*EUROPA_BASICO);
	      }
	      else {
	        valorDias = dias*(personas*EUROPA_PREMIUM);
	      }
	      total = valorTicket + valorDias;
	      break;
	      
	    case 3:
	      valorTicket = personas*CANCUN_TIQUETE;
	      if (planes == 1) {
	        valorDias = dias*(personas*CANCUN_BASICO);
	      }
	      else {
	        valorDias = dias*(personas*CANCUN_PREMIUM);
	      }
	      total = valorTicket + valorDias;
	      break;
		}
  
  	if (personas > 3) {	//Doble condicional para calcular descuento si es mas de 3 personas y si es miembro fiel.
      	totalDescuento = total * descuentoPersonas;
      	if (clienteFiel == 1) {
      		totalDescuento *= descuentoMembresia;	
		  }      		
	}
	else if (clienteFiel == 1) {	//Doble dicional para calcular si es cliente fiel, si el if no se cumple.
    	totalDescuento = total * descuentoMembresia;
	}
    
    system ("cls");
  	printf("\n\tFactura: \n\n");//Se imprime el resultado final mediante condiciones.
	printf("=================================\n");
	//Dobe condicional para imprimir el destino leido.
	if (destino == 1) {
		printf(">> Destino: \tNew York \n");	
	}
	else if (destino == 2) {
		printf(">> Destino: \tEuropa \n");	
	}
	else {
		printf(">> Destino: \tCancun \n");	
	}
			
	//Dobe condicional para imprimir el plan leido.
	if (planes == 1)
		printf(">> Plan: \tbasico \n");
	else
		printf(">> Plan: \tPremium \n");
	
	//Imprime las personas leidos.
	printf(">> Peronas: \t%i \n", personas);
	//Imprime los dias leidos.
	printf(">> Dias: \t%i \n", dias);
	
	//Doble condicional para imprimir si es miembro o no.
	if (clienteFiel == 1)
		printf(">> Membresia: \tSi \n");
	else
		printf(">> Membresia: \tNo \n");
	printf(">> Total: \t$%i USD\n", total);
	
	//Doble condicional que imprime si existe algun descuento.	
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
	
	//Condicional simple para imprimir el descuento y el total descuento.
	if (totalDescuento > 0) {
		printf("\n\n>> Descuento: \t\t$%i USD", total-totalDescuento);
		printf("\n>> Total descuento: \t$%i USD", totalDescuento);	
	}
	
	printf("\n=================================\n");
  
	return 0;
}
