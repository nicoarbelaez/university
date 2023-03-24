package points_one_to_four;

public class PointThree {
  /**
   * 3. Declare e inicialice un array de 2 dimensiones denominado arreglo de un
   * tipo largo que tenga 4 filas y 3 columnas para que todos los valores estén
   * configurados en 5.
   */
  public PointThree() {
    long[][] arreglo = new long[4][3];
    for (int i = 0; i < arreglo.length; i++) {
      for (int j = 0; j < arreglo[i].length; j++) {
        arreglo[i][j] = 5;
      }
    }
    // Lo siguiente no es necesario, pero lo pongo para que se vea en consola.
    System.out.println("// Punto 3");
    System.out.println("long[][] arreglo = new long[4][3];");
    System.out.println("for (int i = 0; i < arreglo.length; i++) {");
    System.out.println("  for (int j = 0; j < arreglo[i].length; j++) {");
    System.out.println("    arreglo[i][j] = 5;");
    System.out.println("  }");
    System.out.println("}");
  }
}
