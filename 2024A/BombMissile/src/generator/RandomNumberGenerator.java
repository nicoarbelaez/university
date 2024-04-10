package generator;

import java.util.*;
import java.util.stream.Collectors;
import models.TrackNumber;
import util.NumberUtils;

public class RandomNumberGenerator implements NumberGenerator {
    private int digitCount;
    private List<Integer[]> possibleNumbers;
    private List<TrackNumber> triedNumbers;
    private Map<Integer, boolean[]> positionDigits;

    public RandomNumberGenerator() {
        this.positionDigits = new HashMap<>();
    }

    @Override
    public void initialize(int countDigit) {
        this.digitCount = countDigit;
    }

    @Override
    public Integer[] generate() {
        filterDigitPositionNotRepeat(); // TODO: Does not make sense to filter the numbers

        int randomIndex = NumberUtils.generateRandomNumber(0, possibleNumbers.size() - 1);
        Integer[] number = possibleNumbers.get(randomIndex);
        return number;
    }

    @Override
    public void updateInformation(List<Integer[]> possibleNumbers, List<TrackNumber> triedNumbers) {
        this.possibleNumbers = possibleNumbers;
        this.triedNumbers = triedNumbers;
        updatePositionDigits();
        // positionDigits.forEach((k, v) -> System.out.println("<P> " + k + " -> " +
        // Arrays.toString(v))); // TODO: Remove
    }

    private void updatePositionDigits() {
        for (Integer[] digits : triedNumbers.stream().map(e -> e.getDigits()).collect(Collectors.toList())) {
            for (int i = 0; i < digitCount; i++) {
                int digit = digits[i];
                if (!positionDigits.containsKey(digit)) {
                    positionDigits.put(digit, new boolean[digitCount]);
                }
                positionDigits.get(digit)[i] = true;
            }
        }
    }

    private void filterDigitPositionNotRepeat() {
        boolean isValid = false;
        int count = digitCount;
        List<Integer[]> validNumbers = null;

        while (!isValid && count > 0) {
            validNumbers = new ArrayList<>();
            for (Integer[] number : possibleNumbers) {
                if (isValidNumber(number, count)) {
                    validNumbers.add(number);
                }
            }
            if (!validNumbers.isEmpty()) {
                isValid = true;
            } else {
                count--;
            }
        }

        possibleNumbers = validNumbers;
    }

    private boolean isValidNumber(Integer[] digits, int count) {
        int countValid = 0;
        for (int i = 0; i < digitCount; i++) {
            if (positionDigits.containsKey(digits[i])) {
                boolean[] positions = positionDigits.get(digits[i]);
                if (!positions[i]) {
                    countValid++;
                }
                continue;
            }
            countValid++;
        }
        return countValid >= count;
    }
}
