package puntoUno;

public class PuntoUno {
	
	public PuntoUno() {
		int randomNum = (int) (Math.random() * 10 + 1);
		boolean lessThanOrEqual7 = randomNum <= 7;
		// esMenorIgualA7
		System.out.println("El número aleatorio generado es " + randomNum + ", entonces " + randomNum + " <= 7:");
		System.out.print(lessThanOrEqual7);
		System.out.println(" - Es " + (lessThanOrEqual7? "menor o igual a 7" : "mayor a 7"));
	}
}
