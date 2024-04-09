import game.Game;
import reader.InputReader;

public class App {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int digitCount = 3;
        Integer[] imaginedNumber = new Integer[] { 3, 2, 4 };
        InputReader mockInputReader = new reader.MockInputReader(digitCount);
        InputReader consoleInputReader = new reader.ConsoleInputReader();

        start(mockInputReader, digitCount);
    }

    private static void start(InputReader inputReader, int digitCount) {
        Game gameMissileBomb = new Game(digitCount, inputReader);

        if (inputReader instanceof reader.MockInputReader) {
            int numberTest = 1;
            int[] averageAttempts = new int[numberTest];
            for (int i = 0; i < numberTest; i++) {
                System.out.println("===============[Test " + (i + 1) + "]===============");
                gameMissileBomb.startGame();
                averageAttempts[i] = gameMissileBomb.getAttempts();
                gameMissileBomb.resetGame();
                System.out.println("===============[Test " + (i + 1) + "]===============");
            }
            System.out.println("AVERAGE ATTEMPTS: " + getAverageAttempts(averageAttempts));
            System.out.println("MAX ATTEMPTS: " + getMaxAttempts(averageAttempts));
        } else {
            gameMissileBomb.startGame();
        }
    }

    private static int getAverageAttempts(int[] attempts) {
        int sum = 0;
        for (int attempt : attempts) {
            sum += attempt;
        }
        return sum / attempts.length;
    }

    private static int getMaxAttempts(int[] attempts) {
        int max = Integer.MIN_VALUE;
        for (int attempt : attempts) {
            if (attempt > max) {
                max = attempt;
            }
        }
        return max;
    }
}
