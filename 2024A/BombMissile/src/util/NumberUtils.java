package util;

public class NumberUtils {

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static String buildNumberFromArray(Integer[] number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            sb.append(number[i]);
        }
        return sb.toString();
    }

    public static Integer[] generateRandomNumber(int digitCount) {
        Integer[] randomNumber = new Integer[digitCount];
        for (int i = 0; i < digitCount; i++) {
            if (NumberUtils.isArrayFull(randomNumber)) {
                break;
            }
            int digit;
            do {
                digit = (int) (Math.random() * 10);
            } while (NumberUtils.containsDigit(randomNumber, digit));
            randomNumber[i] = digit;
        }
        return randomNumber;
    }

    public static boolean containsDigit(Integer[] number, int digit) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] != null && number[i] == digit) {
                return true;
            }
        }
        return false;
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    private static boolean isArrayFull(Integer[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == null) {
                return false;
            }
        }
        return true;
    }
}
