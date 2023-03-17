package puntoUnoAPuntoCuatro;

public class Punto14 {
	public Punto14() {
		// Punto 1
		int[] calificacion = new int[9];
		// Punto 2
		float[][] precio = new float[10][3];
		// Punto 3
		long[][] arreglo = new long[4][3];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				arreglo[i][j] = 5;
			}
		}
		// Punto 4
		byte[] valores = new byte[10];
		for (int i = 0; i < 10; i++) {
			valores[i] = (byte) 1;
		}
	}
}
