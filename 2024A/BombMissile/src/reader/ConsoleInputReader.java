package reader;

import game.message.GameMessages;
import models.TrackNumber;

public class ConsoleInputReader implements InputReader {

    @Override
    public int readUserInput(int min, int max, GameMessages message) {
        int number = 0;
        String input = System.console().readLine();
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada inválida: " + input + " no es un número.");
        }

        if (number < min || number > max) {
            throw new IllegalArgumentException(
                    "Error de rango: " + number + " está fuera del rango [" + min + ", " + max + "].");
        }
        return number;
    }

    @Override
    public void reset() {
    }

    @Override
    public void setTrackNumber(TrackNumber trackNumber) {
    }
}
