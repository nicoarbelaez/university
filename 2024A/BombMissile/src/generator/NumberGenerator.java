package generator;

import java.util.ArrayList;
import java.util.List;
import models.TrackNumber;

public interface NumberGenerator {
    /**
     * Base the number system is in (decimal)
     */
    static final int BASE = 10;
    
    Integer[] generate();
    void updateInformation(List<Integer[]> possibleNumbers, List<TrackNumber> triedNumbers);
    void initialize(int countDigit); // Agrega este método

    public static List<Integer[]> generateAllPossibleNumbers(int digitCount) {
        List<Integer[]> possibleNumbers = new ArrayList<>();
        int LOWER_LIMIT = 0;
        int UPPER_LIMIT = (int) Math.pow(BASE, digitCount);

        for (int num = LOWER_LIMIT; num < UPPER_LIMIT; num++) {
            Integer[] digits = new Integer[digitCount];
            int currentDigit = num;
            for (int i = digitCount - 1; i >= 0; i--) {
                digits[i] = currentDigit % BASE;
                currentDigit /= BASE;
            }

            if (hasUniqueDigits(digits)) {
                possibleNumbers.add(digits);
            }
        }

        return possibleNumbers;
    }

    private static boolean hasUniqueDigits(Integer[] digits) {
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i].equals(digits[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
