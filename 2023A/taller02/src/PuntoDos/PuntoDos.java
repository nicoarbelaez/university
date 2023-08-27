package PuntoDos;

public class PuntoDos {
	public PuntoDos() {
		int x = 2, y = 3, z = 6;

		System.out.println("Ecuación\t\t\t\tResultado");
		System.out.println("---------------------------------------");
		System.out.println("a. √(x^5 - 6) / 4\t\t\t= " + puntoUnoA(x));
		System.out.println("b. x^y - 6^x\t\t\t\t= " + puntoUnoB(x, y));
		System.out.println("c. 4cos(z/5) - sin(x^2)\t\t\t= " + puntoUnoC(x, z));
		System.out.println("d. x^4 - √(6x - y^3)\t\t\t= " + puntoUnoD(x, y));
		System.out.println("e. 1 / (y - (1 / (x - 2^y)))\t\t= " + puntoUnoE(x, y));
		System.out.println("f. 7cos(√(5 - sin(√(3x - 4))))\t\t= " + puntoUnoF(x));
	}
	
	private double esNaN(double valor) {
		if (Double.isNaN(valor))
		{
			valor = 0.0d;
		}
	    return valor;
	}

	public double puntoUnoA(int x) {
		double ecuacion = Math.sqrt(Math.pow(x, 5) - 6) / 4;
		return esNaN(ecuacion);
	}

	public double puntoUnoB(int x, int y) {
		double ecuacion = Math.pow(x, y) - Math.pow(6, x);
		return esNaN(ecuacion);
	}

	public double puntoUnoC(int x, int z) {
		double ecuacion = 4 * Math.cos(z / 5) - Math.sin(Math.pow(x, 2));
		return esNaN(ecuacion);
	}

	public double puntoUnoD(int x, int y) {
		double ecuacion = Math.pow(x, 4) - Math.sqrt(6 * x - Math.pow(y, 3));
		return esNaN(ecuacion);
	}

	public double puntoUnoE(int x, int y) {
		double ecuacion = 1 / (y - (1 / (x - Math.pow(2, y))));
		return esNaN(ecuacion);
	}

	public double puntoUnoF(int x) {
		double ecuacion = 7 * Math.cos(Math.sqrt(5 - Math.sin(Math.sqrt(3 * x - 4))));
		return esNaN(ecuacion);
	}
}
