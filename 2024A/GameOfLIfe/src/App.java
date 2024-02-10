import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Juego 1
        int[][] cells = new int[20][2];
        for (int i = 0; i < cells.length; i++) {
            int max = 39;
            cells[i][0] = randomInt(0, max);
            cells[i][1] = randomInt(0, max);
        }
        GameOfLife game = new GameOfLife(40, cells);
        game.simulateGenerations(50);
        
        // =========
        System.out.println("Pulsa una tecla para continuar...");
        try (Scanner sc = new Scanner(System.in)) {
            sc.nextLine();
        }
        // =========

        // Juego 2
        GameOfLife game1 = new GameOfLife(40, 10);
        game1.simulate();
    }

    private static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
