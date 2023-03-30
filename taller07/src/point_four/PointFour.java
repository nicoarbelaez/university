package point_four;

public class PointFour {
  public PointFour() {
    // Error de sintaxis
    // int num = 5
    // System.out.println("the value of num is: " + num);
    System.out.println("// Error de sintaxis");
    System.out.println("int num = 5");
    System.out.println("System.out.println(\"the value of num is: \" + num);");
    System.out.println("(El error ocurre porque en la línea 1 no se cierra la linea con un punto y coma.)\n\n");

    // Error lógico
    // int x = 5;
    // int y = 10;
    // if (x > y);
    // {
    //   System.out.println("x is greater than y");
    // }
    System.out.println("// Error lógico");
    System.out.println("int x = 5;");
    System.out.println("int y = 10;");
    System.out.println("if (x > y);");
    System.out.println("{");
    System.out.println("  System.out.println(\"x is greater than y\");");
    System.out.println("}");
    System.out.println("(El error ocurre porque en la línea 4 se cierra la declaración con un punto y coma,");
    System.out.println("lo que hace que la línea 5 se considere una declaración vacía.)\n\n");

    // Excepción
    // String s = null;
    // System.out.println(s.length());
    System.out.println("// Excepción");
    System.out.println("String s = null;");
    System.out.println("System.out.println(s.length());");
    System.out.println("(El error ocurre porque en la línea 1 se declara una variable de tipo String,");
    System.out.println("pero no se le asigna ningún valor.)\n\n");
  }
}
