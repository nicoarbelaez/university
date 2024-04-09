package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import generator.NumberGenerator;
import generator.RandomNumberGenerator;

import models.TrackNumber;
import util.FileHandler;
import util.GameUtils;

/**
 * The `BombaMisilGuesser` class represents a guesser for a missile bomb game.
 * It keeps track of the possible numbers, tried numbers, and bomb numbers.
 * It generates track numbers, updates the track number with missile and bomb
 * counts,
 * and determines if the player number has been found.
 */
public class BombaMisilGuesser {
    private final int digitCount;
    private final List<TrackNumber> triedNumbers;
    private final NumberGenerator numberGenerator;
    private final FileHandler fileHandler;
    
    private List<Integer[]> possibleNumbers;
    private Integer[] playerNumber;

    public BombaMisilGuesser(int digitCount) {
        this.digitCount = digitCount;
        this.triedNumbers = new ArrayList<>();
        this.numberGenerator = new RandomNumberGenerator();
        this.numberGenerator.initialize(digitCount);

        this.fileHandler = new FileHandler("resources/data/");
        this.playerNumber = null;

        String fileName = "possible_numbers" + digitCount + ".txt";
        if (!fileHandler.fileExists(fileName)) {
            this.possibleNumbers = NumberGenerator.generateAllPossibleNumbers(digitCount);
            try {
                fileHandler.writeToFile(fileName, this.possibleNumbers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            this.possibleNumbers = fileHandler.readFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TrackNumber generateTrackNumber() {
        if (possibleNumbers.isEmpty()) {
            throw new RuntimeException("No more possible combinations.");
        }

        numberGenerator.updateInformation(possibleNumbers, triedNumbers);
        TrackNumber trackNumber = new TrackNumber(numberGenerator.generate());
        triedNumbers.add(trackNumber);
        return trackNumber;
    }

    public void updateTrackNumber(TrackNumber trackNumber, int missileCount, int bombCount) {
        trackNumber.setMissiles(missileCount);
        trackNumber.setBombs(bombCount);
        GameUtils.filterPossibleNumbers(possibleNumbers, trackNumber);

        if (possibleNumbers.size() == 1) {
            playerNumber = possibleNumbers.get(0);
        }
    }

    public boolean isFound() {
        return playerNumber != null;
    }

    public int getDigitCount() {
        return digitCount;
    }

    public List<TrackNumber> getTriedNumbers() {
        return triedNumbers;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public List<Integer[]> getPossibleNumbers() {
        return possibleNumbers;
    }

    public void setPossibleNumbers(List<Integer[]> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    public Integer[] getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer[] playerNumber) {
        this.playerNumber = playerNumber;
    }
}
