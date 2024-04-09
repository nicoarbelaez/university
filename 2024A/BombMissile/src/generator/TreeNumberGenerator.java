package generator;

import java.util.List;

import models.TrackNumber;

public class TreeNumberGenerator implements NumberGenerator {
    private int digitCount;
    private List<Integer[]> possibleNumbers;
    private List<TrackNumber> triedNumbers;
    // private Queue<TrackNumber> bombNumbers;

    @Override
    public void initialize(int countDigit) {
        this.digitCount = countDigit;
    }

    @Override
    public Integer[] generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        numberGenerator.updateInformation(possibleNumbers, triedNumbers);
        return numberGenerator.generate();
    }

    @Override
    public void updateInformation(List<Integer[]> possibleNumbers, List<TrackNumber> triedNumbers) {
        this.possibleNumbers = possibleNumbers;
        this.triedNumbers = triedNumbers;
    }

    public int getDigitCount() {
        return digitCount;
    }

    public void setDigitCount(int digitCount) {
        this.digitCount = digitCount;
    }

    public List<Integer[]> getPossibleNumbers() {
        return possibleNumbers;
    }

    public void setPossibleNumbers(List<Integer[]> possibleNumbers) {
        this.possibleNumbers = possibleNumbers;
    }

    public List<TrackNumber> getTriedNumbers() {
        return triedNumbers;
    }

    public void setTriedNumbers(List<TrackNumber> triedNumbers) {
        this.triedNumbers = triedNumbers;
    }
}
