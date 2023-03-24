package points_one_to_four;

public class PointTwo {

  /**
   * 2. Declare un precio con nombre de array de 2 dimensiones de tipo float que
   * tenga 10 filas y 3 columnas.
   */
  public PointTwo() {
    float[][] precio = new float[10][3];
    // Lo siguiente no es necesario, pero lo pongo para que se vea en consola.
    System.out.println("// Punto 2");
    System.out.println("float[][] precio = new float[10][3];");
    precio[0][0] = 1.0f;
  }
}
