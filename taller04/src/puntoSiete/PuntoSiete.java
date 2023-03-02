package puntoSiete;

import java.util.Scanner;

public class PuntoSiete {

    public PuntoSiete(Scanner input) {
        double height, length, width;
        double totalArea, priceOneLiter, priceFiveLiter;
        int quantityOfFiveLiter, quantityOfOneLiter, optimalOneLiter, optimalFiveLiter;
        double oneLiterPrice = 4.0, fiveLiterPrice = 15.0;
        double oneLiterArea = 300, fiveLiterArea = 1500;

        // Pedir las dimensiones de la habitación
        System.out.print("Por favor, introduzca la altura de la habitación en pies: \n>>");
        height = input.nextDouble();

        System.out.print("Por favor, introduzca la longitud de la habitación en pies: \n>>");
        length = input.nextDouble();

        System.out.print("Por favor, introduzca el ancho de la habitación en pies: \n>>");
        width = input.nextDouble();

        // Calcular el área total de la habitación
        totalArea = (2 * height * length) + (2 * height * width);

        quantityOfOneLiter = (int) Math.round(totalArea / oneLiterArea);
        quantityOfFiveLiter = (int) Math.round(totalArea / fiveLiterArea);

        optimalOneLiter = (int) Math.ceil((totalArea % fiveLiterArea) / oneLiterArea);
        optimalFiveLiter = (int) (Math.floor(totalArea / fiveLiterArea));

        priceOneLiter = optimalOneLiter * oneLiterPrice;
        priceFiveLiter = optimalFiveLiter * fiveLiterPrice;

        // Imprimir los resultados
        System.out.println("Para pintar una habitación de " + height + " pies de alto, " + length
                + " pies de largo y " + width + " pies de ancho:");
        System.out.println("(Area total: " + totalArea + " pies cuadrados)\n");
        
        System.out.print("Se necesitan " + quantityOfOneLiter + " botes de pintura de 1 litro, o ");
        System.out.println(quantityOfFiveLiter + " botes de 5 litros.");
        System.out.println(">> Para un resultado mas óptimo, se recomienda comprar " + optimalOneLiter + " botes de 1 litro y " + optimalFiveLiter + " botes de 5 litros.");
        System.out.println(">> El precio total de los botes de pintura es de $" + priceOneLiter + " por los botes de 1 litro y $" + priceFiveLiter + " por los botes de 5 litros. Total: $" + (priceOneLiter + priceFiveLiter));
    }
}
