import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.BombaMisilGuesser;
import models.TrackNumber;
import tree.Node;
import tree.Tree;
import util.FileHandler;
import util.GameUtils;

@SuppressWarnings("unused")
public class Test {
    private static int digitCount = 3;

    public static void main(String[] args) {
        // testFileHandler();
        testTrackNumber();
        // testTree();
    }

    private static void testFileHandler() {
        FileHandler fileHandler = new FileHandler("resources/data/");
        String fileName = "possiblenumbers" + digitCount + ".txt";
        List<Integer[]> possibleNumbers = null;

        if (fileHandler.fileExists(fileName)) {
            try {
                possibleNumbers = fileHandler.readFromFileIntegerList(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            possibleNumbers = new ArrayList<>();
            possibleNumbers.add(new Integer[] { 1, 2, 3 });
            possibleNumbers.add(new Integer[] { 4, 5, 6 });
            possibleNumbers.add(new Integer[] { 7, 8, 9 });
            try {
                fileHandler.writeToFileIntegerList(fileName, possibleNumbers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Integer[] num : possibleNumbers) {
            System.out.println(Arrays.toString(num));
        }
    }

    private static void testTrackNumber() {
        BombaMisilGuesser bombaMisilGuesser = new BombaMisilGuesser(digitCount);
        TrackNumber trackNumber = new TrackNumber(new Integer[] { 8, 7, 1 });
        List<TrackNumber> trackNumbers = new ArrayList<>();

        Map<Integer, Integer> numberOccurrenceInPossibles = new HashMap<>();
        Map<Integer, Integer[]> numberPositionOccurrenceInPossibles = new HashMap<>();
        Map<Integer, Integer> numberOccurrenceInAttempts = new HashMap<>();
        Map<Integer, Integer[]> numberPositionOccurrenceInAttempts = new HashMap<>();

        trackNumbers.add(new TrackNumber(new Integer[] { 0, 7, 1 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 0, 7, 9 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 0, 4, 1 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 2, 7, 1 }));
        // trackNumbers.add(new TrackNumber(new Integer[] { 4, 7, 1 }));
        // trackNumbers.add(new TrackNumber(new Integer[] { 3, 7, 1 }));
        // trackNumbers.add(new TrackNumber(new Integer[] { 5, 7, 1 }));
        for (TrackNumber num : trackNumbers) {
            printPossibleNumbers(
                    bombaMisilGuesser,
                    num,
                    GameUtils.getMissile(trackNumber.getDigits(), num.getDigits()),
                    GameUtils.getBomb(trackNumber.getDigits(), num.getDigits()),
                    numberOccurrenceInPossibles,
                    numberPositionOccurrenceInPossibles,
                    numberOccurrenceInAttempts,
                    numberPositionOccurrenceInAttempts);
        }
        System.out.println(Arrays.toString(trackNumber.getDigits()));
    }

    private static void testTree() {
        Node root = new Node(new TrackNumber(new Integer[] { 1, 2, 3 }));
        Tree tree = new Tree(root);

        Node n11 = new Node(new TrackNumber(new Integer[] { 1, 4, 5 }));
        Node n12 = new Node(new TrackNumber(new Integer[] { 6, 2, 7 }));
        Node n13 = new Node(new TrackNumber(new Integer[] { 8, 9, 3 }));
        tree.insert(root, n11);
        tree.insert(root, n12);
        tree.insert(root, n13);

        Node n131 = new Node(new TrackNumber(new Integer[] { 2, 3, 7 }));
        tree.insert(n13, n131);

        for (int i = 0; i < 1; i++) {
            tree.nextFocus();
        }

        System.out.println(tree);
        System.out.println("FOCUS\n" + tree.getFocusNode());
        System.out.println("LAST\n" + tree.getLastNode());
    }

    private static void printPossibleNumbers(
            BombaMisilGuesser bmg,
            TrackNumber trackNumber,
            int missile,
            int bomb,
            Map<Integer, Integer> numberOccurrenceInPossibles,
            Map<Integer, Integer[]> numberPositionOccurrenceInPossibles,
            Map<Integer, Integer> numberOccurrenceInAttempts,
            Map<Integer, Integer[]> numberPositionOccurrenceInAttempts) {
        bmg.updateTrackNumber(trackNumber, missile, bomb);
        System.out.println(trackNumber.toString());
        bmg.getPossibleNumbers().forEach(num -> System.out.println("(/\\) " + Arrays.toString(num)));

        for (Integer[] num : bmg.getPossibleNumbers()) {
            numberOccurrence(num, numberOccurrenceInPossibles);
        }
        System.out.println("=====[numberOccurrenceInPossibles]=====");
        numberOccurrenceInPossibles.forEach((k, v) -> System.out.println(k + " -> " + v));

        for (Integer[] num : bmg.getPossibleNumbers()) {
            numberPositionOccurrence(num, numberPositionOccurrenceInPossibles);
        }
        System.out.println("=====[numberPositionOccurrenceInPossibles]=====");
        numberPositionOccurrenceInPossibles
                .forEach((k, v) -> System.out.println(k + " -> " + Arrays.toString(v)));

        numberOccurrence(trackNumber.getDigits(), numberOccurrenceInAttempts);
        System.out.println("=====[numberOccurrenceInAttempts]=====");
        numberOccurrenceInAttempts.forEach((k, v) -> System.out.println(k + " -> " + v));

        numberPositionOccurrence(trackNumber.getDigits(), numberPositionOccurrenceInAttempts);
        System.out.println("=====[numberPositionOccurrenceInAttempts]=====");
        numberPositionOccurrenceInAttempts
                .forEach((k, v) -> System.out.println(k + " -> " + Arrays.toString(v)));
        System.out.println("--------------------");
    }

    private static void numberOccurrence(Integer[] num, Map<Integer, Integer> numberOccurrence) {
        for (Integer digits : num) {
            if (numberOccurrence.get(digits) == null) {
                numberOccurrence.put(digits, 1);
            } else {
                numberOccurrence.put(digits, numberOccurrence.get(digits) + 1);
            }
        }
    }

    private static void numberPositionOccurrence(Integer[] num, Map<Integer, Integer[]> numberPositionOccurrence) {
        for (int i = 0; i < num.length; i++) {
            if (numberPositionOccurrence.get(num[i]) == null) {
                Integer[] value = new Integer[] { 0, 0, 0 };
                value[i] = 1;
                numberPositionOccurrence.put(num[i], value);
            } else {
                Integer[] value = numberPositionOccurrence.get(num[i]);
                value[i] = value[i] + 1;
                numberPositionOccurrence.put(num[i], value);
            }
        }
    }
}
