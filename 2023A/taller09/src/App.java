import taller09.Empleados;
import taller09.Uso_Empleado;

public class App {
	public static void main(String[] args) {
		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Ana");
		Empleados trabajador3 = new Empleados("Antonio");
		Empleados trabajador4 = new Empleados("Maria");
		
		trabajador1.cambiarSeccionn("RRHH");

		System.out.println(trabajador1.devuelveDatos());
		System.out.println(trabajador2.devuelveDatos());
		System.out.println(trabajador3.devuelveDatos());
		System.out.println(trabajador4.devuelveDatos());
		
		System.out.println(Empleados.dameIdSiguiente());
		
		
		Uso_Empleado usoEmpleados = new Uso_Empleado();
	}
}
