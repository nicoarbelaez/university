
/*
 * Esta es la clase principal del programa, en ella se encuentran los metodos para imprimir la nomina,
 * sumar la nomina y encontrar el empleado con mayor sueldo.
 * 
 * Al inicio se importan las librerias necesarias para el funcionamiento del programa.
 * (-) ArrayList: para poder crear un arreglo dinamico
 * (-) Scanner: para poder leer datos desde la consola
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	/*
	 * Se crea un arreglo dinamico de tipo Empleado, en el cual se guardaran todos
	 * los empleados que se creen.
	 * 
	 * Se hizo con un arreglo dinamico, porque el array normal tiene un tamaño fijo,
	 * y no se podria agregar mas empleados si supera ese tamaño. Supongamos que se
	 * hace de esa forma, la linea * de codigo seria:
	 * (-) Empleado[] empleados = new Empleado[n]; // n es el numero de empleados
	 * que
	 * se van a crear
	 * 
	 * Y para agregar un empleado se hace de la siguiente forma:
	 * (-) empleados[i] = new Empleado(id, nombre, sueldo, diasLaborados,
	 * auxilioTransporte); // i es el indice del empleado
	 */
	static ArrayList<Empleado> empleados = new ArrayList<Empleado>();

	public static void main(String[] args) {

		empleados.add(new Empleado(1107840352, "Juan", 800000, 27, 75000));
		empleados.add(new Empleado(1110234634, "Pedro", 700000, 23, 75000));
		empleados.add(new Empleado(1310223434, "Juan Diego", 650000, 28, 75000));
		empleados.add(new Empleado(1310223434, "Isabella", 1000000, 14, 75000));

		Scanner sc = new Scanner(System.in); // Se crea un objeto de tipo Scanner
		System.out.println("Bienvenido al programa de nomina");
		while (true) { // Se crea un ciclo infinito, true significa que se repite siempre, hasta que se rompa el ciclo.
			/*
			 * Se llama al metodo menu, el cual se encarga de imprimir el menu y leer la
			 * opcion que el usuario ingrese.
			 * Y se guarda en la variable opcion.
			 * 
			 * Se le manda el parametro sc, para que el metodo menu pueda leer datos desde
			 * la consola. Y no se tenga que crear un objeto de tipo Scanner en el metodo
			 * menu.
			 */
			int opcion = menu(sc);
			switch (opcion) {
				case 1:
					System.out.print("Ingrese el id del empleado >> ");
					int id = sc.nextInt(); // sc.nextInt() lee un numero entero desde la consola.
					/*
					 * sc.nextLine() lee una linea desde la consola.
					 * 
					 * Se pone antes de sc.nextInt(), porque si no se pone, el programa no lee la
					 * linea que se escribio.
					 */
					sc.nextLine();
					System.out.print("Ingrese el nombre del empleado >> ");
					String nombre = sc.nextLine();
					System.out.print("Ingrese el sueldo del empleado >> ");
					float sueldo = (float) sc.nextDouble(); // sc.nextDouble() lee un numero decimal desde la consola.
					System.out.print("Ingrese los dias laborados del empleado >> ");
					int diasLaborados = sc.nextInt();
					System.out.print("Ingrese el auxilio de transporte del empleado >> ");
					float auxilioTransporte = (float) sc.nextDouble();

					empleados.add(new Empleado(id, nombre, sueldo, diasLaborados, auxilioTransporte)); // Se crea un nuevo empleado y se agrega al arreglo.
					imprimirNomina(); // Se llama al metodo imprimirNomina, para que se imprima la nomina con el nuevo empleado.
					break;
				case 2:
					imprimirNomina();
					break;
				case 3:
					sumarNomina(); // Se llama al metodo sumarNomina, para que se sume la nomina.
					break;
				case 4:
					System.out.println("\n\n");
					System.out.println("El empleado con mayor sueldo es: " + sueldoMayor()); // Se llama al metodo sueldoMayor, para que se imprima el nombre del empleado con mayor sueldo.
					System.out.println("\n\n");
					break;
				default:
					System.out.println("Saliendo...");
					System.exit(0); // Se sale del programa. System.exit(0) significa que se sale sin errores.
			}
		}
	}

	public static int menu(Scanner sc) {
		System.out.println("================== MENU ==================");
		System.out.println("1. Agregar un empleado a la nomina");
		System.out.println("2. Imprimir la tabla de la nomina");
		System.out.println("3. Imprimir el total de la nomina");
		System.out.println("4. Imprimir el nombre del empleado con mayor sueldo");
		System.out.println("5. Salir");
		System.out.print("Ingrese una opcion >> ");

		int opcion = sc.nextInt();
		return opcion; // Se retorna la opcion que el usuario ingreso.
	}

	public static void sumarNomina() {
		float totalNomina = 0;
		float totalSueldo = 0;
		float totalSueldoDevengado = 0;
        /*
         * Se crea un ciclo foreach, para recorrer el arreglo de empleados.
         * 
         * "for (Empleado e : empleados)" significa que se recorre el arreglo empleados.
         * "Empleado e" significa que se crea una variable llamada e de tipo Empleado.
         * Y se le asigna el valor de cada elemento del arreglo.
         */
		for (Empleado e : empleados) {
            // Se accede a los atributos de cada empleado, desde la variable e y poniendo un punto puedo ver las variables que tiene el empleado.
			totalNomina += e.totalSueldo; // Se suma el total del sueldo, de cada empleado.
			totalSueldo += e.sueldo;
			totalSueldoDevengado += e.totalDevengado;
		}
		System.out.println("\n\n");
		System.out.println("El total de la nomina es: $" + totalNomina); // Se imprime el total de la nomina.
		System.out.println("El total de los sueldos es: $" + totalSueldo);
		System.out.println("El total de los sueldos devengados es: $" + totalSueldoDevengado);
		System.out.println("\n\n");
	}

	public static String sueldoMayor() {
		String nombre = ""; // Se crea una variable vacia de tipo String, para guardar el nombre del empleado con mayor sueldo.
		float sueldo = 0;
		for (Empleado e : empleados) { // Se recorre el arreglo de empleados. Con foreach, una variante del for.
			if (e.totalSueldo > sueldo) { // Si el sueldo del empleado es mayor al sueldo que se tiene guardado en la variable sueldo.
				sueldo = e.totalSueldo;
				nombre = e.nombre;
			}
		}
		return nombre;
	}

	public static void imprimirNomina() { // Se crea el metodo imprimirNomina.
        /*
         * El printf imprime en la consola, pero con un formato. %s significa que se va a imprimir un String.
         * Y el numero que va despues del %, significa que el String va a tener ese numero de caracteres.
         */
		System.out.printf("\n\n%10s| %10s| %10s| %14s| %16s| %21s| %15s| %10s| %12s| %13s|", "ID", "Nombre", "Sueldo",
				"Dias laborados", "Sueldo devengado", "Auxilio de transporte", "Total devengado", "Salud (4%)",
				"Pension (4%)", "Total a pagar");

		System.out.println("\n");

		for (Empleado e : empleados) { // Se recorre el arreglo de empleados. Con foreach, una variante del for.
            /*
             * El printf imprime en la consola, pero con un formato. %10d significa que se va a imprimir un numero entero.
             * Y el numero que va despues del %, significa que el numero va a tener ese numero de caracteres.
             * 
             * %10.2f significa que se va a imprimir un numero decimal, con 2 decimales.
             * Y el numero que va despues del %, significa que el numero va a tener ese numero de caracteres.
             */
			System.out.printf("%10d| %10s| %10.2f| %14d| %16.2f| %21.2f| %15.2f| %10.2f| %12.2f| %13.2f|", e.id,
					e.nombre, e.sueldo, e.diasLaborados, e.sueldoDevengado, e.auxilioTransporte, e.totalDevengado,
					e.saludDeduccion, e.pensionDeduccion, e.totalSueldo);
			System.out.println();
		}

		System.out.println("\n\n");
	}
}
