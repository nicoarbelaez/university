package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import game.message.GameMessages;
import models.TrackNumber;
import reader.InputReader;

public class GameUtils {

    public static int promptForInteger(int min, int max, GameMessages message, InputReader inputReader) {
        System.out.print("- " + message.getMessage());
        while (true) {
            try {
                return inputReader.readUserInput(min, max, message);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void filterPossibleNumbers(List<Integer[]> possibleNumbers, TrackNumber trackNumberGuess) {
        List<Integer[]> filteredNumbers = new ArrayList<>();
        int missile = trackNumberGuess.getMissiles();
        int bomb = trackNumberGuess.getBombs();
        Integer[] guess = trackNumberGuess.getDigits();

        for (Integer[] digits : possibleNumbers) {
            if (getMissile(digits, guess) == missile && getBomb(digits, guess) == bomb) {
                filteredNumbers.add(digits);
            }
            // System.out.println(printDebug(digits, guess, missile, bomb)); // TODO:Remove
        }

        possibleNumbers.clear();
        possibleNumbers.addAll(filteredNumbers);
    }

    public static int getMissile(Integer[] secretNumber, Integer[] guess) {
        int bomb = 0;
        for (int i = 0; i < secretNumber.length; i++) {
            if (guess[i] != secretNumber[i] && NumberUtils.containsDigit(secretNumber, guess[i])) {
                bomb++;
            }
        }
        return bomb;
    }

    public static int getBomb(Integer[] secretNumber, Integer[] guess) {
        int bomb = 0;
        for (int i = 0; i < secretNumber.length; i++) {
            if (guess[i] == secretNumber[i]) {
                bomb++;
            }
        }
        return bomb;
    }

    @SuppressWarnings("unused")
    private static String printDebug(Integer[] digits, Integer[] guess, int missile, int bomb) {
        String str = "";
        str += Arrays.toString(guess) + " => " + Arrays.toString(digits);
        str += " M:" + getMissile(digits, guess) + " B:" + getBomb(digits, guess) + " | ";
        str += (getMissile(digits, guess) == missile && getBomb(digits, guess) == bomb) ? "[+]" : false;
        return str;
    }
}
