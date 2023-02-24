import PuntoDos.PuntoDos;
import PuntoTres.PuntoTres;
import PuntoUno.PuntoUno;

public class Main {

	public static void main(String[] args) {
		System.out.println("Taller 02");
		System.out.println("Punto 1");
		PuntoUno puntoUno = new PuntoUno();
		
		System.out.println("Punto 2");
		PuntoDos puntoDos = new PuntoDos();

		System.out.println("Punto 3");
		PuntoTres puntoTres = new PuntoTres();
		puntoTres.calcularValor();
	}
	
}
