#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

#define DESCUENTO_MEMBRESIA 0.95
#define DESCUENTO_PERSONAS 0.90
#define NAME_ARCHIVO "planes.dat"

void inicioSystem();
void opcionConfing();
void seeMenu();
void hacerPreguntas();
void totalCosto(float, float);
void mostrarFactura();
void saveFactura();
void nuevaOperacion();
void error();
//  Apariencia
void centerText(char *, int);
void createBoxe(int, int, int, int);
void gotoxy(int, int);
void createTabla(int, int, int, int, int, int);
void sizeConsol(char *, char *);
// Manipulación de archivos
void createArchivo();
void cargarArchivo();
void imprimirArchivo();
void consultaArchivo();
void modificacionArchivo();
void deleteArchivo();
// Una estructura que almacena información de los precios de plan de vaijes
typedef struct
{
	int idViaje;
	char destino[20];
	float ticket;
	float planBasico;
	float planPremium;

} AGENCIA;
// Información
int personas, dias, planes, clienteFiel, destinoEscogido, numberDatos = 0;
// Operaciones
float valorTicket, valorDias, totalDescuento, total;
// Propiedades de consola
int colsSystem, linesSystem;
int medioIzquierda, medioDerecha, alineado;

int main()
{
	sizeConsol("142", "50");
	system("COLOR 0F"); // Define el color d ela consolo. 0 = Negro de fondo. F = Blanco de letra. Se puede ver por la funci�n: system(COLOR ZZ).
	medioIzquierda = colsSystem / 4;
	medioDerecha = (colsSystem / 2) + medioIzquierda;
	alineado = medioIzquierda - colsSystem / 6;
	inicioSystem();

	return 0;
}
// Inicio del programa
void inicioSystem()
{
	int responseStart;
	system("cls");
	// Titulo
	centerText("*** T I M E ***", 2);
	createBoxe(medioIzquierda, 1, medioDerecha, 3);
	centerText("Bienvenido al sistema de TIME | Agencia de viajes internacional", 4);
	centerText("Que vas a hacer hoy", 6);
	gotoxy(medioIzquierda, 7);
	printf("[1] Comfiguracion de datos");
	FILE *archivo;
	AGENCIA viaje;
	archivo = fopen(NAME_ARCHIVO, "rb");
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	if (archivo == NULL || feof(archivo))
	{
		gotoxy(medioIzquierda, 8);
		printf("[2] Hacer coticacion (el archivo no tiene datos)");
	}
	else
	{
		gotoxy(medioIzquierda, 8);
		printf("[2] Hacer coticacion");
	}
	gotoxy(medioIzquierda, 9);
	printf("[0] Salir");
	gotoxy(medioIzquierda, 10);
	printf("--->");
	gotoxy(medioIzquierda + 5, 10);
	scanf("%i", &responseStart);
	switch (responseStart)
	{
	case 1:
		fclose(archivo);
		opcionConfing();
		system("cls");
		break;
	case 2:
		if (feof(archivo))
		{
			gotoxy(medioIzquierda + 5, 10);
			printf("El archivo no tiene información ");
			fclose(archivo);
			getch();
			inicioSystem();
		}
		else
		{
			fclose(archivo);
			hacerPreguntas();
		}
		system("cls");
		break;
	default:
		fclose(archivo);
		exit(1);
	}
}
// Es la taba de datos
void seeMenu()
{
	int menuDistansX, linesCant, celdaY, celdaX, textCeldaY, textCeldaX;
	const int menuDistansY = 0, colsCant = 4, linesLong = 2, colsLong = 21;
	FILE *archivo;
	AGENCIA viaje;

	celdaY = linesLong / 2;
	celdaX = colsLong / 2;
	linesCant = 0;
	menuDistansX = (colsSystem / 2) - colsLong * 2;

	createBoxe(menuDistansX + colsLong, menuDistansY, menuDistansX + ((colsCant - 1) * colsLong), menuDistansY + 2);
	gotoxy((menuDistansX + colsLong) + 15, menuDistansY + 1);
	printf("*** T I M E ***");
	// Encabezado
	textCeldaX = menuDistansX + celdaX - (strlen("destino") / 2);
	gotoxy(textCeldaX, menuDistansY + 5);
	printf("DESTINO        TIQUETE IDA Y VUELTA      PLAN BASICO         PLAN PREMIUM");
	createTabla(colsLong, 2, colsCant, 1, menuDistansX, menuDistansY + 4);
	// Abre y lee el archivo
	archivo = fopen(NAME_ARCHIVO, "rb"); // "rb" Read binary (Leer el archivo)
	if (archivo == NULL)
		exit(1);
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		textCeldaY = 2 * menuDistansY + 7 + celdaY;
		textCeldaX = menuDistansX + celdaX;
		gotoxy(menuDistansX + celdaX - (strlen(viaje.destino) / 2), textCeldaY);
		printf("%s", viaje.destino);
		gotoxy(colsLong + textCeldaX - (11 / 2), textCeldaY);
		printf("%.2f USD", viaje.ticket);
		gotoxy(2 * colsLong + textCeldaX - (11 / 2), textCeldaY);
		printf("%.2f USD", viaje.planBasico);
		gotoxy(3 * colsLong + textCeldaX - (11 / 2), textCeldaY);
		printf("%.2f USD", viaje.planPremium);
		celdaY += linesLong;
		linesCant++;
		numberDatos++;
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	fclose(archivo);
	// Cuerpo
	createTabla(colsLong, linesLong, colsCant, linesCant, menuDistansX, menuDistansY + 7);
}
// Hace las preguntas
void hacerPreguntas()
{
	system("cls");
	system("COLOR 0F");
	sizeConsol("142", "50");
	seeMenu();
	FILE *archivo;
	AGENCIA viaje;
	int destinosComprobar[20], i = 0;
	// Abre el archivo e imprime toodos los destinos
	archivo = fopen(NAME_ARCHIVO, "rb");
	if (archivo == NULL)
		exit(1);
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	printf("\n\n >> Que destino desea viajar");
	while (!feof(archivo))
	{
		printf("\n [%i] %s", viaje.idViaje, viaje.destino);
		destinosComprobar[i] = viaje.idViaje;
		i++;
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	fclose(archivo);
	printf("\n [0] Atras");
	printf("\nOpcion: ");
	scanf("%i", &destinoEscogido);
	if (destinoEscogido == 0)
	{
		inicioSystem();
		abort();
	}
	int existe = 0;
	for (int j = 0; j < i; j++)
	{
		if (destinoEscogido == destinosComprobar[j])
			existe += 1;
	}
	if (existe == 0)
	{
		error();
		abort();
	}
	printf("\n >> Cantidad de personas al viaje: ");
	scanf("%i", &personas);
	printf("\n >> Cantidad de dias de viaje: ");
	scanf("%i", &dias);
	printf("\n >> Que tipo de plan desea: \n [1] Plan basico \n [2] Plan premium \nOpcion: ");
	scanf("%i", &planes);
	if (planes < 1 || planes > 2)
	{
		error();
		abort();
	}
	printf("\n >> Tiene membresia de cliente fiel con la agencia: \n [1] Si \n [2] No \nOpcion: ");
	scanf("%i", &clienteFiel);
	if (clienteFiel < 1 || clienteFiel > 2)
	{
		error();
		abort();
	}
	// Abre el archivo y comprueba que plan escogio
	archivo = fopen(NAME_ARCHIVO, "rb");
	if (archivo == NULL)
		exit(1);
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		if (destinoEscogido == viaje.idViaje)
		{
			if (planes == 1)
				totalCosto(viaje.ticket, viaje.planBasico);
			else if (planes == 2)
				totalCosto(viaje.ticket, viaje.planPremium);
			break;
		}
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	fclose(archivo);
}
// Hace las operaciones para la factura
void totalCosto(float ticket, float plan)
{

	valorTicket = personas * ticket;	  // Mutiplica la cantidad de personas por el valor del tiquete del destino.
	valorDias = dias * (personas * plan); // Multiplica la cantidad de personas por el valor de un dia del plan. Todo eso multiplicado por la cantidad de dias.
	total = valorDias + valorTicket;
	totalDescuento = 0;
	if (personas > 3)
	{ // Condicional doble para el descuento por mayor a 3 personas.
		totalDescuento = total * DESCUENTO_PERSONAS;
		if (clienteFiel == 1)
		{ // Condicional para el descuento si es miembro fiel.
			totalDescuento *= DESCUENTO_MEMBRESIA;
		}
	}
	else if (clienteFiel == 1)
	{
		totalDescuento = total * DESCUENTO_MEMBRESIA;
	}
	mostrarFactura();
}
// Muestra la factura
void mostrarFactura()
{
	sizeConsol("90", "30");
	int mediumSystem = (colsSystem) / 2;
	FILE *archivo;
	AGENCIA viaje;

	system("COLOR 0F");
	system("cls"); // Borra todo de la consola.

	centerText("Factura", 3);
	createBoxe(mediumSystem / 2, 2, mediumSystem + mediumSystem / 2, 4);
	createBoxe(mediumSystem / 2, 5, mediumSystem + mediumSystem / 2, 21);
	// Abre el archivo e imprimo el destino
	archivo = fopen(NAME_ARCHIVO, "rb");
	if (archivo == NULL)
		exit(1);
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	gotoxy(mediumSystem / 2 + 1, 7);
	while (!feof(archivo))
	{
		if (destinoEscogido == viaje.idViaje)
		{
			printf(">> Destino:            %s", viaje.destino);
			break;
		}
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	fclose(archivo);
	gotoxy(mediumSystem / 2 + 1, 8);
	// PLAN
	if (planes == 1)
		printf(">> Plan:               Basico");
	else
		printf(">> Plan:               Premium");
	gotoxy(mediumSystem / 2 + 1, 9);
	printf(">> Personas:           %i", personas);
	gotoxy(mediumSystem / 2 + 1, 10);
	printf(">> Dias:               %i", dias);
	// MEMBRESIA
	gotoxy(mediumSystem / 2 + 1, 11);
	if (clienteFiel == 1)
		printf(">> Membresia:          Si");
	else
		printf(">> Membresia:          No");
	gotoxy(mediumSystem / 2 + 1, 12);
	printf(">> Total:              $%.2f USD", total);
	// DESCUENTOS
	if (personas > 3)
	{
		gotoxy(mediumSystem / 2 + 1, 14);
		printf(">> Descuentos:");
		gotoxy(mediumSystem / 2 + 1, 15);
		printf(" -- Mas de 3 personas");
		if (clienteFiel == 1)
		{
			gotoxy(mediumSystem / 2 + 1, 16);
			printf(" -- Cliente fiel");
		}
	}
	else if (clienteFiel == 1)
	{
		gotoxy(mediumSystem / 2 + 1, 14);
		printf(">> Descuentos:");
		gotoxy(mediumSystem / 2 + 1, 15);
		printf(" -- Cliente fiel");
	}

	if (totalDescuento > 0)
	{
		gotoxy(mediumSystem / 2 + 1, 18);
		printf(">> Descuento:          $%.2f USD", total - totalDescuento);
		gotoxy(mediumSystem / 2 + 1, 19);
		printf(">> Total descuento:    $%.2f USD", totalDescuento);
	}
	char responseSaveFactura;
	centerText("Quieres guardar la factura [S/N] ====> ", 22);
	scanf("%s", &responseSaveFactura);
	if (responseSaveFactura == 'S' || responseSaveFactura == 's')
	{
		saveFactura();
		abort();
	}
	else
	{
		nuevaOperacion();
		abort();
	}
}
void saveFactura()
{
	FILE *archivo, *factura;
	AGENCIA viaje;
	archivo = fopen(NAME_ARCHIVO, "rb");
	factura = fopen("TIME-factura.txt", "w");
	if (archivo == NULL || factura == NULL)
		exit(1);
	for (int i = 0; i < 39; i++)
		fprintf(factura, "-");
	fprintf(factura, "\n|               Factura               |\n");
	for (int i = 0; i < 39; i++)
		fprintf(factura, "-");
	fprintf(factura, "\n");
	for (int i = 0; i < 39; i++)
		fprintf(factura, "-");
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		if (destinoEscogido == viaje.idViaje)
		{
			fprintf(factura, "\n >>  Destino:            %s", viaje.destino);
			break;
		}
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	// PLAN
	if (planes == 1)
		fprintf(factura, "\n >>  Plan:               Basico");
	else
		fprintf(factura, "\n >>  Plan:               Premium");
	fprintf(factura, "\n >>  Personas:           %i", personas);
	fprintf(factura, "\n >>  Dias:               %i", dias);
	// MEMBRESIA
	if (clienteFiel == 1)
		fprintf(factura, "\n >>  Membresia:          Si");
	else
		fprintf(factura, "\n >>  Membresia:          No");
	fprintf(factura, "\n >>  Total:              $%.2f USD", total);
	// DESCUENTOS
	if (personas > 3)
	{
		fprintf(factura, "\n\n >>  Descuentos:");
		fprintf(factura, "\n -- Mas de 3 personas");
		if (clienteFiel == 1)
		{
			fprintf(factura, "\n -- Cliente fiel");
		}
	}
	else if (clienteFiel == 1)
	{
		fprintf(factura, "\n\n >>  Descuentos:");
		fprintf(factura, "\n -- Cliente fiel");
	}
	if (totalDescuento > 0)
	{
		fprintf(factura, "\n\n >>  Descuento:          $%.2f USD", total - totalDescuento);
		fprintf(factura, "\n >>  Total descuento:    $%.2f USD", totalDescuento);
	}
	fprintf(factura, "\n");
	for (int i = 0; i < 39; i++)
		fprintf(factura, "-");
	fclose(archivo);
	fclose(factura);
	centerText("*** Se guardo correctamente ***", 24);
	nuevaOperacion();
}
// Empieza de nuevo
void nuevaOperacion()
{

	int respuestaNueva;
	printf("\n\n\t >>Desea hacer otro pago: \n\t 1. Si \n\t 2. No \n\t Opcion: ");
	scanf("%i", &respuestaNueva);
	if (respuestaNueva == 1)
	{
		hacerPreguntas();
	}
	else
	{
		exit(0);
	}
}
// Una funcion para arrojar error
void error()
{

	int respuestaError;

	system("cls");
	system("COLOR 4F");

	centerText("**ERORR** |Ingresaste un dato mal| **ERORR**", 17);
	gotoxy((colsSystem) / 2 - 11, 18);
	printf(">>Desea volver al menu");
	gotoxy((colsSystem) / 2 - 11, 19);
	printf("1. Si | 2. No");
	gotoxy((colsSystem) / 2 - 11, 20);
	printf("Opcion: ");

	scanf("%i", &respuestaError);
	if (respuestaError == 1)
	{ // Condional para volver al menu  despues del error o de otro caso, terminar el programa.
		hacerPreguntas();
	}
	else
	{
		exit(0);
	}
}
// ================FUNCIONES DE APARIENCIA================

void gotoxy(int x, int y)
{
	HANDLE ventanaSystema;
	COORD cordsCursor;
	ventanaSystema = GetStdHandle(STD_OUTPUT_HANDLE);
	cordsCursor.X = x;
	cordsCursor.Y = y;
	SetConsoleCursorPosition(ventanaSystema, cordsCursor);
}
// Crea una caja
void createBoxe(int x1, int y1, int x2, int y2)
{
	for (int i = x1; i <= x2; i++)
	{
		gotoxy(i, y1);
		printf("%c", 196);
		gotoxy(i, y2);
		printf("%c", 196);
	}
	for (int i = y1; i <= y2; i++)
	{
		gotoxy(x1, i);
		printf("%c", 179);
		gotoxy(x2, i);
		printf("%c", 179);
	}
	gotoxy(x1, y1);
	printf("%c", 218);
	gotoxy(x2, y1);
	printf("%c", 191);
	gotoxy(x1, y2);
	printf("%c", 192);
	gotoxy(x2, y2);
	printf("%c", 217);
	gotoxy(0, y2 + 1);
}
// Centrar texto
void centerText(char *text, int y)
{
	int numberCols = colsSystem / 2;
	gotoxy(numberCols - (strlen(text) / 2), y);
	printf(text);
}
// Ancho de columna. Alto de columna. Número de columnas. Número de filas
void createTabla(int colsSpace, int linesSpace, int colsNumber, int linesNumber, int distanX, int distanY)
{
	const int linesConst = linesSpace;
	for (int j = 1; j < linesNumber + 1; j++)
	{

		for (int i = 1; i <= colsNumber; i++)
		{
			createBoxe(distanX + colsSpace * (i - 1), distanY, distanX + colsSpace * i, linesSpace + distanY);
		}
		for (int i = 1; i <= colsNumber - 1; i++)
		{
			gotoxy(distanX + colsSpace * i, linesSpace - linesSpace + distanY);
			printf("%c", 194);
			gotoxy(distanX + colsSpace * i, linesSpace + distanY);
			printf("%c", 193);
		}
		linesSpace += linesConst;
	}
	linesSpace = linesConst;
	if (linesNumber > 1)
	{
		int i;
		for (int j = 1; j < linesNumber; j++)
		{
			for (i = 1; i <= colsNumber - 1; i++)
			{
				gotoxy(distanX + colsSpace * i, linesSpace + distanY);
				printf("%c", 197);
			}
			gotoxy(distanX, linesSpace + distanY);
			printf("%c", 195);
			gotoxy(distanX + colsSpace * i, linesSpace + distanY);
			printf("%c", 180);
			linesSpace += linesConst;
		}
		gotoxy(0, distanY + (linesConst * linesNumber) + 1);
	}
}
// Modifica el tamaño de la consola
void sizeConsol(char *anchoConsole, char *altoConsole)
{

	char modeSystem[30] = "mode con: cols=";
	colsSystem = atoi(anchoConsole);
	linesSystem = atoi(altoConsole);

	strcat(modeSystem, anchoConsole);
	strcat(modeSystem, " lines=");
	strcat(modeSystem, altoConsole);
	system(modeSystem);
}
// ================FUNCIONES DE ARCHIVO================
// Muentra las opciones de configuracion de datos
void opcionConfing()
{

	int selectSetting;
	do
	{
		system("cls");
		centerText("*** T I M E ***", 2);
		createBoxe(medioIzquierda, 1, medioDerecha, 3);
		printf("\n===> Archivo modificando: %s", NAME_ARCHIVO);
		printf("\n [1] Generar archivo nuevo \n [2] Agregar datos \n [3] Lista de datos \n [4] Buscar dato \n [5] Modificación de datos \n [6] Eliminar dato \n [0] Atras \n---> ");
		scanf("%i", &selectSetting);
		switch (selectSetting)
		{
		case 1:
			createArchivo();
			break;
		case 2:
			cargarArchivo();
			break;
		case 3:
			imprimirArchivo();
			getch();
			break;
		case 4:
			consultaArchivo();
			getch();
			break;
		case 5:
			modificacionArchivo();
			getch();
			break;
		case 6:
			deleteArchivo();
			getch();
			break;
		default:
			inicioSystem();
		}
	} while (selectSetting >= 0 || selectSetting <= 6);
}
// Crea un archivo binario ".dat"
void createArchivo()
{
	FILE *archivo;
	char response;
	int alineado = medioIzquierda - colsSystem / 6;
	printf("\n\n\tSeguro que deseas crear el archivo (si existe el archivo, sera remplazado) [S/N]: ");
	scanf("%s", &response);
	if (response == 'S' || response == 's')
	{
		archivo = fopen(NAME_ARCHIVO, "wb"); // "wb" Write binary (Crear archivo binario)
		if (archivo == NULL)
			exit(1);
		fclose(archivo);
		printf("\t *** Archivo credado con exito ***\n");
	}
}

void cargarArchivo()
{
	int space;
	FILE *archivo;
	AGENCIA viaje;
	archivo = fopen(NAME_ARCHIVO, "ab"); // "ab" Add binary (Agregar al archivo)
	if (archivo == NULL)
		exit(1);
	gotoxy(alineado, 15);
	printf(" ID  Destino       Ticket         Plan Basico    Plan Premium");
	createBoxe(alineado, 16, 70, 18);
	space = 1;
	gotoxy(alineado + space, 17);
	scanf("%i", &viaje.idViaje);
	fflush(stdin);
	space = 5;
	gotoxy(alineado + space, 17);
	gets(viaje.destino);
	space = 19;
	gotoxy(alineado + space, 17);
	scanf("%f", &viaje.ticket);
	space = 34;
	gotoxy(alineado + space, 17);
	scanf("%f", &viaje.planBasico);
	space = 49;
	gotoxy(alineado + space, 17);
	scanf("%f", &viaje.planPremium);

	// Dirección variable (Struct). Tamaño en bites del struct. 1 bloque (sin vectores). Nombre logico del archivo
	fwrite(&viaje, sizeof(AGENCIA), 1, archivo);
	fclose(archivo);
}

void imprimirArchivo()
{
	int count = 0, space;
	FILE *archivo;
	AGENCIA viaje;
	archivo = fopen(NAME_ARCHIVO, "rb"); // "rb" Read binary (Leer el archivo)
	if (archivo == NULL)
		exit(1);
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		space = 1;
		gotoxy(alineado + space, 17 + count);
		printf("%i", viaje.idViaje);
		space = 5;
		gotoxy(alineado + space, 17 + count);
		printf("%s", viaje.destino);
		space = 19;
		gotoxy(alineado + space, 17 + count);
		printf("%.2f USD", viaje.ticket);
		space = 34;
		gotoxy(alineado + space, 17 + count);
		printf("%.2f USD", viaje.planBasico);
		space = 49;
		gotoxy(alineado + space, 17 + count);
		printf("%.2f USD", viaje.planPremium);
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
		count++;
	}
	gotoxy(alineado, 15);
	printf(" ID  Destino       Ticket         Plan Basico    Plan Premium");
	createBoxe(alineado, 16, 72, count + 17);
	fclose(archivo);
	gotoxy(0, count + 18);
}

void consultaArchivo()
{
	FILE *archivo;
	AGENCIA viaje;
	archivo = fopen(NAME_ARCHIVO, "rb"); // "rb" Read binary (Leer el archivo)
	if (archivo == NULL)
		exit(1);
	int id, space, existe = 0;
	gotoxy(0, 15);
	printf("ID del dato: --> ");
	scanf("%i", &id);
	gotoxy(0, 15);
	printf("                  ");
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		if (id == viaje.idViaje)
		{
			space = 1;
			gotoxy(alineado + space, 17);
			printf("%i", viaje.idViaje);
			space = 5;
			gotoxy(alineado + space, 17);
			printf("%s", viaje.destino);
			space = 19;
			gotoxy(alineado + space, 17);
			printf("%.2f USD", viaje.ticket);
			space = 34;
			gotoxy(alineado + space, 17);
			printf("%.2f USD", viaje.planBasico);
			space = 49;
			gotoxy(alineado + space, 17);
			printf("%.2f USD", viaje.planPremium);
			existe = 1;
			break;
		}
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	gotoxy(alineado, 15);
	printf(" ID  Destino       Ticket         Plan Basico    Plan Premium");
	createBoxe(alineado, 16, 72, 18);
	if (existe == 0)
		printf("No existe un dato con el ID [%i]", id);
	fclose(archivo);
}

void modificacionArchivo()
{
	FILE *archivo;
	archivo = fopen(NAME_ARCHIVO, "r+b"); // "rb" Read binary (Leer el archivo)
	if (archivo == NULL)
		exit(1);
	int id, space, existe = 0;
	printf("ID del dato que modificara: --> ");
	scanf("%i", &id);
	AGENCIA viaje;
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		if (id == viaje.idViaje)
		{
			// Imprime el dato a modificar
			gotoxy(alineado, 16);
			printf(" ===> Dato anterior <===");
			space = 1;
			gotoxy(alineado + space, 19);
			printf("%i", viaje.idViaje);
			space = 5;
			gotoxy(alineado + space, 19);
			printf("%s", viaje.destino);
			space = 19;
			gotoxy(alineado + space, 19);
			printf("%.2f USD", viaje.ticket);
			space = 34;
			gotoxy(alineado + space, 19);
			printf("%.2f USD", viaje.planBasico);
			space = 49;
			gotoxy(alineado + space, 19);
			printf("%.2f USD", viaje.planPremium);
			createBoxe(alineado, 18, 70, 20);
			gotoxy(alineado, 17);
			printf(" ID  Destino       Ticket         Plan Basico    Plan Premium");
			// Imprime el nuevo dato modificado
			gotoxy(alineado, 21);
			printf(" ===> Dato nuevo <===");
			createBoxe(alineado, 23, 70, 25);
			gotoxy(alineado, 22);
			printf(" ID  Destino       Ticket         Plan Basico    Plan Premium");
			space = 1;
			gotoxy(alineado + space, 24);
			scanf("%i", &viaje.idViaje);
			fflush(stdin);
			space = 5;
			gotoxy(alineado + space, 24);
			gets(viaje.destino);
			space = 19;
			gotoxy(alineado + space, 24);
			scanf("%f", &viaje.ticket);
			space = 34;
			gotoxy(alineado + space, 24);
			scanf("%f", &viaje.planBasico);
			space = 49;
			gotoxy(alineado + space, 24);
			scanf("%f", &viaje.planPremium);

			int pos = ftell(archivo) - sizeof(AGENCIA);
			fseek(archivo, pos, SEEK_SET);
			fwrite(&viaje, sizeof(AGENCIA), 1, archivo);
			printf("\n\t*** Se modifico con exito ***");
			existe = 1;
			break;
		}
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	if (existe == 0)
		printf("\n\tNo existe un viaje con el ID %i", id);
	fclose(archivo);
}
// Elinación de dato por medio de una copia de un archivo
void deleteArchivo()
{
	FILE *archivo, *temporal;
	AGENCIA viaje;
	imprimirArchivo();
	archivo = fopen(NAME_ARCHIVO, "rb");	// Abre y lee el archivo orginal
	temporal = fopen("temporal.dat", "wb"); // Crea un nuevo archivo
	if (archivo == NULL || temporal == NULL)
		exit(1);
	int deleteDato, existe = 0;
	printf("ID del dato que eliminara  --> ");
	scanf("%i", &deleteDato);
	fread(&viaje, sizeof(AGENCIA), 1, archivo);
	while (!feof(archivo))
	{
		if (deleteDato != viaje.idViaje)
		{ // Copia los datos que no se quiren eliminar a archivo temporal
			fwrite(&viaje, sizeof(AGENCIA), 1, temporal);
			existe = 1;
		}
		fread(&viaje, sizeof(AGENCIA), 1, archivo);
	}
	fclose(archivo);
	fclose(temporal);
	remove(NAME_ARCHIVO);
	rename("temporal.dat", NAME_ARCHIVO);
	if (existe == 1)
		printf("\n\t*** Se elimino con exito ***");
	else
		printf("\n\t*** El archivo no existe ***");
}