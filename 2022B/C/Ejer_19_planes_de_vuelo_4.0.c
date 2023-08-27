#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>

#define DESCUENTO_MEMBRESIA 0.95
#define DESCUENTO_PERSONAS 0.90

void mostarMenu ();
void hacerPreguntas ();
void totalCosto (int, int);
void mostrarFactura ();
void nuevaOperacion();
void error ();

void centerText (char *, int);
void createBoxe (int, int, int, int);
void gotoxy (int, int);
void createTabla (int, int, int, int, int, int);
void sizeConsol (char *, char *);
// Arreglos:
// [0] = New York
// [1] = Europa
// [2] = Cancún
int valoresTickets[3] = {1500, 1300, 800}, valorPlanBasico[3] = {200, 150, 100}, valorPlanPremium[3] = {230, 180, 130};
// Información
int destino, personas, dias, planes, total, clienteFiel, destinoEscogido;
// Operaciones
int valorTicket, valorDias, totalDescuento;
// Propiedades de consola
int colsSystem, linesSystem;




int main () {
	
	sizeConsol ("152", "50");
	system ("COLOR 0F");//Define el color d ela consolo. 0 = Negro de fondo. F = Blanco de letra. Se puede ver por la funci�n: system(COLOR ZZ).
	
	hacerPreguntas ();
    mostrarFactura ();
    nuevaOperacion();
	
	return 0;
}

// Es la taba de datos que nos da el ejercio. Recreada
void mostarMenu () {
	
	int menuDistansY = 0, menuDistansX;
	const int colsCant = 4, linesCant = 3,linesLong = 2, colsLong = 21;
	menuDistansX = (colsSystem/2)-colsLong*2;

	createBoxe(menuDistansX+colsLong,menuDistansY , menuDistansX+((colsCant-1)*colsLong),menuDistansY+2);
	gotoxy((menuDistansX+colsLong)+15,menuDistansY+1); printf("*** T I M E ***");
	// centerText("*** T I M E ***", 2);
	gotoxy(menuDistansX+8, menuDistansY+5); printf("DESTINO       TIQUETE IDA Y VUELTA      PLAN BASICO         PLAN PREMIUM");
	gotoxy(menuDistansX+7, menuDistansY+8); printf("New York             $%i USD             $%i USD             $%i USD", valoresTickets[0], valorPlanBasico[0], valorPlanPremium[0]);
	gotoxy(menuDistansX+8, menuDistansY+10); printf("Europa              $%i USD             $%i USD             $%i USD", valoresTickets[1], valorPlanBasico[1], valorPlanPremium[1]);
	gotoxy(menuDistansX+8, menuDistansY+12); printf("Cancun               $%i USD             $%i USD             $%i USD", valoresTickets[2], valorPlanBasico[2], valorPlanPremium[2]);
	createTabla(colsLong,linesLong , colsCant,1 , menuDistansX,menuDistansY+4); // Encabezado
	createTabla(colsLong,2 , colsCant,linesCant , menuDistansX,menuDistansY+5+linesLong); // Cuerpo
}

// Hace las preguntas
void hacerPreguntas () {
	
	system ("cls");
	system ("COLOR 0F");
	mostarMenu ();
	printf("\n\n >> Que destino desea viajar: \n 1. New York \n 2. Europa \n 3. Cancun \nOpcion: ");
	scanf ("%i", &destino);
	destinoEscogido = destino-1;
    if (destino != 1 && destino != 2 && destino != 3) {
        error();
        abort();
    }
	printf("\n >> Cantidad de personas al viaje: ");
	scanf("%i", &personas);
	printf("\n >> Cantidad de dias de viaje: ");
	scanf("%i", &dias);
	printf("\n >> Que tipo de plan desea: \n 1. Plan basico \n 2. Plan premium \nOpcion: ");
	scanf ("%i", &planes);
    if (planes != 1 && planes != 2) {
        error();
        abort();
    }
	
	printf("\n\n__________________________________________________");
	printf("\n >> Tiene membresia de cliente fiel con la agencia: \n 1. Si \n 2. No \nOpcion: ");
	scanf ("%i", &clienteFiel);
    if (clienteFiel != 1 && clienteFiel != 2) {
        error();
        abort();
    }
	//Comprueba que plan escogio
	if (planes == 1)
		totalCosto(valoresTickets[destinoEscogido], valorPlanBasico[destinoEscogido]);
	else if (planes == 2)
		totalCosto(valoresTickets[destinoEscogido], valorPlanPremium[destinoEscogido]);
	else
		error();
}

// Hace las operaciones para la factura
void totalCosto (int ticket, int plan) {
	
		valorTicket = personas*ticket;//Mutiplica la cantidad de personas por el valor del tiquete del destino.
		valorDias = dias*(personas*plan);//Multiplica la cantidad de personas por el valor de un dia del plan. Todo eso multiplicado por la cantidad de dias.
		total = valorDias+valorTicket;
		totalDescuento = 0;
		if (personas > 3) { //Condicional doble para el descuento por mayor a 3 personas.
			totalDescuento = total*DESCUENTO_PERSONAS;
			if (clienteFiel == 1) { //Condicional para el descuento si es miembro fiel.
				totalDescuento *= DESCUENTO_MEMBRESIA;
			}
		}
		else if (clienteFiel == 1) {
			totalDescuento = total * DESCUENTO_MEMBRESIA;
		}
}

// Muestra la factura
void mostrarFactura (){
	sizeConsol ("90", "30");
	int mediumSystem = (colsSystem)/2;

	system ("COLOR 0F");
    system("cls");//Borra todo de la consola.
	
	centerText("Factura", 3);
	createBoxe(mediumSystem/2,2 , mediumSystem+mediumSystem/2,4);
	createBoxe(mediumSystem/2,5 , mediumSystem+mediumSystem/2,21);

	gotoxy(mediumSystem/2+1, 7);
	if (destino == 1) {
		printf(">> Destino:            New York");	
	}
	else if (destino == 2) {
		printf(">> Destino:            Europa");	
	}
	else {
		printf(">> Destino:            Cancun");	
	}		
	gotoxy(mediumSystem/2+1, 8);
	// PLAN
	if (planes == 1)
		printf(">> Plan:               Basico");
	else
		printf(">> Plan:               Premium");
	
	gotoxy(mediumSystem/2+1, 9); printf(">> Peronas:            %i", personas);
	gotoxy(mediumSystem/2+1, 10); printf(">> Dias:               %i", dias);
	// MEMBRESIA
	gotoxy(mediumSystem/2+1, 11);
	if (clienteFiel == 1)
		printf(">> Membresia:          Si");
	else
		printf(">> Membresia:          No");
	gotoxy(mediumSystem/2+1, 12);printf(">> Total:              $%i USD", total);
	// DESCUENTOS
	if (personas > 3) {
		gotoxy(mediumSystem/2+1, 14); printf(">> Descuentos:");
		gotoxy(mediumSystem/2+1, 15); printf(" -- Mas de 3 personas");
		if(clienteFiel == 1) {
			gotoxy(mediumSystem/2+1, 16);printf(" -- Cliente fiel");
		}
	}
	else if (clienteFiel == 1){
		gotoxy(mediumSystem/2+1, 14); printf(">> Descuentos:");
		gotoxy(mediumSystem/2+1, 15); printf(" -- Cliente fiel");	
	}
	
	if (totalDescuento > 0) {
		gotoxy(mediumSystem/2+1, 18); printf(">> Descuento:          $%i USD", total-totalDescuento);
		gotoxy(mediumSystem/2+1, 19); printf(">> Total descuento:    $%i USD", totalDescuento);	
	}
    gotoxy(mediumSystem/2+1, 22); system("pause");

}

// Empieza de nuevo
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

// Una funcion para arrojar error
void error () {
	
    int respuestaError;

	system ("cls");
	system ("COLOR 4F");
	
	centerText("**ERORR** |Ingresaste un dato mal| **ERORR**", 17);
	gotoxy((colsSystem)/2-11 , 18); printf(">>Desea volver al menu");
	gotoxy((colsSystem)/2-11 , 19); printf("1. Si | 2. No");
	gotoxy((colsSystem)/2-11 , 20); printf("Opcion: ");

	scanf("%i", &respuestaError);
	if (respuestaError == 1) {//Condional para volver al menu  despues del error o de otro caso, terminar el programa.
		main ();
	}
	else {
		exit(0);
	}
	
}

// ================FUNCIONES DE APARIENCIA================

void gotoxy (int x, int y){
	HANDLE ventanaSystema;
	COORD cordsCursor;
	ventanaSystema = GetStdHandle(STD_OUTPUT_HANDLE);
	cordsCursor.X = x;
	cordsCursor.Y = y;
	SetConsoleCursorPosition(ventanaSystema,cordsCursor);
}

// Crea una caja
void createBoxe (int x1, int y1,  int x2, int y2) {
	int i;
	for (i = x1; i <= x2; i++) {
		gotoxy (i, y1); printf("%c", 196);
		gotoxy (i, y2); printf("%c", 196);
	}
	for (i = y1; i <= y2; i++) {
		gotoxy (x1, i); printf("%c", 179);
		gotoxy (x2, i); printf("%c", 179);
	}
	gotoxy (x1, y1); printf("%c", 218);
    gotoxy (x2, y1); printf("%c", 191);
    gotoxy (x1, y2); printf("%c", 192);
    gotoxy (x2, y2); printf("%c", 217);
}

void centerText (char *text, int y) {
	int numberCols = colsSystem/2;
	gotoxy (numberCols-(strlen(text)/2), y); printf(text);
}

// Ancho de columna. Alto de columna. Número de columnas. Número de filas
void createTabla  (int colsSpace, int linesSpace, int colsNumber, int linesNumber, int distanX, int distanY) {
    
    int i, j;
    const int linesConst = linesSpace;
    for ( j = 1; j < linesNumber+1; j++){

        for (i = 1; i <= colsNumber; i++){
            createBoxe(distanX+colsSpace*(i-1),distanY, distanX+colsSpace*i,linesSpace+distanY);            
        }
        for (i = 1; i <= colsNumber-1; i++){
            gotoxy(distanX+colsSpace*i,linesSpace-linesSpace+distanY); printf("%c", 194);
            gotoxy(distanX+colsSpace*i,linesSpace+distanY); printf("%c", 193);
        }
        linesSpace += linesConst;
    }
    linesSpace = linesConst;
    if (linesNumber > 1 ){
        for ( j = 1; j < linesNumber; j++){
            for (i = 1; i <= colsNumber-1; i++){
                gotoxy(distanX+colsSpace*i,linesSpace+distanY); printf("%c", 197);
            }
                gotoxy(distanX,linesSpace+distanY); printf("%c", 195);
                gotoxy(distanX+colsSpace*i,linesSpace+distanY); printf("%c", 180);
            linesSpace += linesConst;         
        }
		gotoxy (0, distanY+(linesConst*linesNumber)+1);
    }
}

// Modifica el tamaño de la consola
void sizeConsol (char *anchoConsole, char *altoConsole) {
	
    char modeSystem[30] = "mode con: cols=";
    colsSystem = atoi(anchoConsole);
    linesSystem = atoi(altoConsole);

    strcat(modeSystem, anchoConsole);
    strcat(modeSystem, " lines="); strcat(modeSystem, altoConsole);    
    system(modeSystem);
}