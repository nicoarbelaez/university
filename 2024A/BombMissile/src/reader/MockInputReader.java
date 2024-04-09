package reader;

import java.util.Arrays;

import game.Game;
import game.message.GameMessages;

import models.TrackNumber;
import util.GameUtils;
import util.NumberUtils;

public class MockInputReader implements InputReader {
    private final int digitCount;
    private Integer[] imaginedNumber;
    private boolean isImaginedNumberSet;
    private TrackNumber trackNumber;

    public MockInputReader(int digitCount) {
        this.digitCount = NumberUtils.clamp(digitCount, Game.getMinDigit(), Game.getMaxDigit());
        this.imaginedNumber = NumberUtils.generateRandomNumber(digitCount);
        this.isImaginedNumberSet = false;
        this.trackNumber = null;
    }

    public MockInputReader(int digitCount, Integer[] imaginedNumber) {
        this.digitCount = digitCount;
        this.imaginedNumber = imaginedNumber;
        this.isImaginedNumberSet = true;
        this.trackNumber = null;
    }

    @Override
    public void setTrackNumber(TrackNumber trackNumber) {
        System.out.println("Imagined number: " + Arrays.toString(imaginedNumber)); // TODO: Remove
        this.trackNumber = trackNumber;
    }

    @Override
    public int readUserInput(int min, int max, GameMessages message) {
        int response;
        switch (message) {
            case MISSILES_PROMPT:
                response = GameUtils.getMissile(imaginedNumber, trackNumber.getDigits());
                break;
            case BOMBS_PROMPT:
                response = GameUtils.getBomb(imaginedNumber, trackNumber.getDigits());
                break;
            default:
                response = -1;
                break;
        }

        System.out.println(response);
        return response;
    }

    @Override
    public void reset() {
        this.trackNumber = null;
        if(!isImaginedNumberSet){
            this.imaginedNumber = NumberUtils.generateRandomNumber(digitCount);
        }
    }
}
