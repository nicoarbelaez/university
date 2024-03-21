import java.util.Scanner;

import decision.Decision;
import optimization.Optimization;
import utils.Color;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Color.GREEN);
        System.out.println("#=====================================#");
        System.out.println("#       BACKTRACKING DESICIONES       #");
        System.out.println("#=====================================#");
        System.out.println(Color.WHITE);
        Decision decision = new Decision();
        decision.run();
        System.out.println("Presiona una tecla para continuar...");
        scanner.nextLine();

        System.out.println(Color.YELLOW);
        System.out.println("#=======================================#");
        System.out.println("#       BACKTRACKING OPTIMIZACION       #");
        System.out.println("#=======================================#");
        System.out.println(Color.WHITE);
        Optimization optimization = new Optimization();
        optimization.run();
        System.out.println("Presiona una tecla para continuar...");
        scanner.nextLine();

        scanner.close();
    }
}
