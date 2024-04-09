package game;

import game.message.GameMessages;
import models.TrackNumber;
import reader.InputReader;
import util.GameUtils;
import util.NumberUtils;

/**
 * The `Game` class represents a game of Missile Bomb.
 * It manages the game logic, including starting the game, processing user guesses, and ending the game.
 * The game requires a digit count and an input reader to interact with the user.
 */
public class Game {
    private static final int MAX_DIGIT = 10;
    private static final int MIN_DIGIT = 2;
    private final int digitCount;
    private final InputReader inputReader;

    private BombaMisilGuesser bombaMisilGuesser;
    private boolean gameEnded;
    private int attempts;

    public Game(int digitCount, InputReader inputReader) {
        this.digitCount = NumberUtils.clamp(digitCount, MIN_DIGIT, MAX_DIGIT);
        this.inputReader = inputReader;
        this.attempts = 0;
        resetGame();
    }

    public void startGame() {
        if (gameEnded) {
            System.out.println(GameMessages.GAME_ALREADY_ENDED.getMessage());
            return;
        }
        System.out.println(String.format(GameMessages.START_GAME_MESSAGE.getMessage(), digitCount));

        while (!bombaMisilGuesser.isFound()) {
            processUserGuesses();
        }

        endGame();
    }

    public void endGame() {
        gameEnded = true;
        String number = NumberUtils.buildNumberFromArray(bombaMisilGuesser.getPlayerNumber());
        System.out.println(String.format(GameMessages.END_GAME_MESSAGE.getMessage(), number));
    }

    public void resetGame() {
        this.bombaMisilGuesser = new BombaMisilGuesser(this.digitCount);
        this.gameEnded = false;
        this.attempts = 0;
        inputReader.reset();
    }

    private void processUserGuesses() {
        attempts++;
        TrackNumber trackNumber = bombaMisilGuesser.generateTrackNumber();
        String guessedNumber = NumberUtils.buildNumberFromArray(trackNumber.getDigits());
        inputReader.setTrackNumber(trackNumber);

        System.out.println(String.format(GameMessages.GUESS_NUMBER_MESSAGE.getMessage(), attempts, guessedNumber));
        int missileCount;
        int bombCount;
        boolean isSumGreaterThanDigitCount;

        do {
            bombCount = GameUtils.promptForInteger(0, digitCount, GameMessages.BOMBS_PROMPT, inputReader);
            missileCount = 0;
            if(bombCount != digitCount) {
                missileCount = GameUtils.promptForInteger(0, digitCount, GameMessages.MISSILES_PROMPT, inputReader);
            }

            isSumGreaterThanDigitCount = missileCount + bombCount > digitCount;

            if (isSumGreaterThanDigitCount) {
                System.out.println(GameMessages.SUM_ERROR_MESSAGE.getMessage());
            }
        } while (isSumGreaterThanDigitCount);

        bombaMisilGuesser.updateTrackNumber(trackNumber, missileCount, bombCount);
        if (bombCount == digitCount || (bombCount == digitCount - 1 && missileCount == 1)) {
            bombaMisilGuesser.setPlayerNumber(trackNumber.getDigits());
        }
    }

    public static int getMaxDigit() {
        return MAX_DIGIT;
    }

    public static int getMinDigit() {
        return MIN_DIGIT;
    }

    public int getDigitCount() {
        return digitCount;
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public BombaMisilGuesser getBombMissile() {
        return bombaMisilGuesser;
    }

    public void setBombMissile(BombaMisilGuesser bombaMisilGuesser) {
        this.bombaMisilGuesser = bombaMisilGuesser;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

}
