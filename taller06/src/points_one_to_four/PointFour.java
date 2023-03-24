package points_one_to_four;

public class PointFour {
    /**
     * 4. Declare e inicialice un array de bytes de una dimensión denominado valores
     * de tamaño 10 de manera que todas las entradas contengan 1.
     */
    public PointFour() {
        byte[] valores = new byte[10];
        for (int i = 0; i < valores.length; i++)
            valores[i] = 1;
        // Lo siguiente no es necesario, pero lo pongo para que se vea en consola.
        System.out.println("// Punto 4");
        System.out.println("byte[] valores = new byte[10];");
        System.out.println("for (int i = 0; i < valores.length; i++)");
        System.out.println("  valores[i] = 1;");
    }
}
