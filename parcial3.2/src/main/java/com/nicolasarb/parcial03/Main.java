package main.java.com.nicolasarb.parcial03;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Spacecraft> spacecraftList = new ArrayList<>();

    public static void main(String[] args) {
        Spacecraft spacecraft = new Spacecraft();
        System.out.println(spacecraft.getId());

        Spacecraft spacecraft1 = new Spacecraft();
        System.out.println(spacecraft1.getId());

        spacecraftList.add(spacecraft);
        spacecraftList.add(spacecraft1);

        System.out.println(spacecraftList.get(0).getId());
    }

    public static void exampleTable(){
        // Imprimir el encabezado de la tabla
        System.out.println("-------------------------------------------------");
        System.out.printf("%10s %10s", "Número", "Cuadrado");
        System.out.println();
        System.out.println("-------------------------------------------------");
        // Imprimir los datos de la tabla usando un bucle for
        for (int i = 0; i < 100; i++) {
            int cuadrado = i * i; // Calcular el cuadrado del número
            System.out.printf("%10d %10d", i, cuadrado); // Imprimir el número y su cuadrado con formato
            System.out.println(); // Saltar de línea
        }
        // Imprimir el final de la tabla
        System.out.println("-------------------------------------------------");
    }
}
