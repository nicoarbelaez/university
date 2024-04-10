import java.util.HashMap;
import java.util.Map;

import game.Game;
import reader.InputReader;

public class App {
    private static final int NUMBER_OF_TESTS = 500;
    private static final int DIGIT_COUNT = 3;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Integer[] imaginedNumber = new Integer[] { 3, 2, 4 };
        InputReader mockInputReader = new reader.MockInputReader(DIGIT_COUNT);
        InputReader consoleInputReader = new reader.ConsoleInputReader();

        start(mockInputReader);
    }

    public static void start(InputReader inputReader) {
        Game gameMissileBomb = new Game(DIGIT_COUNT, inputReader);
        if (!(inputReader instanceof reader.MockInputReader)) {
            gameMissileBomb.startGame();
            return;
        }

        Map<Integer, Integer> attemptsPerTest = new HashMap<>();
        String bannerTest = "===============[Test %d]===============";

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            System.out.println(String.format(bannerTest, (i + 1)));

            gameMissileBomb.startGame();
            if(attemptsPerTest.get(gameMissileBomb.getAttempts()) == null) {
                attemptsPerTest.put(gameMissileBomb.getAttempts(), 1);
            } else {
                attemptsPerTest.put(gameMissileBomb.getAttempts(), attemptsPerTest.get(gameMissileBomb.getAttempts()) + 1);
            }
            gameMissileBomb.resetGame();

            System.out.println(String.format(bannerTest, (i + 1)));
        }

        System.out.println("AVERAGE ATTEMPTS: " + calculateAverage(attemptsPerTest));
        System.out.println("MAX ATTEMPTS: " + calculateMax(attemptsPerTest));
        attemptsPerTest.forEach((k, v) -> System.out.println("Attempts: " + k + " - Count: " + v));
    }

    private static double calculateAverage(Map<Integer, Integer> attempts) {
        int totalAttempts = 0;
        int totalGames = 0;

        for (Map.Entry<Integer, Integer> entry : attempts.entrySet()) {
            totalAttempts += entry.getKey() * entry.getValue();
            totalGames += entry.getValue();
        }

        return (double) totalAttempts / totalGames;
    }

    private static int calculateMax(Map<Integer, Integer> attempts) {
        int maxAttempts = 0;

        for (Map.Entry<Integer, Integer> entry : attempts.entrySet()) {
            if (entry.getKey() > maxAttempts) {
                maxAttempts = entry.getKey();
            }
        }

        return maxAttempts;
    }
}
