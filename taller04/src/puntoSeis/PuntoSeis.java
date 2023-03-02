package puntoSeis;

import java.util.Scanner;

public class PuntoSeis {
	
	public PuntoSeis(Scanner scanner) {
        double average;
        int daysAbsent;
        System.out.println("This program will determine if you can get out of the final exam.");
        System.out.println("Please answer the following questions.");

        System.out.print("What is your average in the class? \n>>");
        average = scanner.nextDouble();

        System.out.print("How many class lectures have you missed? \n>>");
        daysAbsent = scanner.nextInt();

        if ((average >= 90 && daysAbsent <= 3) || (average >= 80 && daysAbsent == 0)) {
        	System.out.println("Congratulations! You are exempt from the final exam.");
        } else {
            System.out.println("Sorry, you are not exempt from the final exam.");
        }
    }
}
