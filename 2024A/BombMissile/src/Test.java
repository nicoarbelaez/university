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
                possibleNumbers = fileHandler.readFromFile(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            possibleNumbers = new ArrayList<>();
            possibleNumbers.add(new Integer[] { 1, 2, 3 });
            possibleNumbers.add(new Integer[] { 4, 5, 6 });
            possibleNumbers.add(new Integer[] { 7, 8, 9 });
            try {
                fileHandler.writeToFile(fileName, possibleNumbers);
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
        TrackNumber trackNumber = new TrackNumber(new Integer[] { 6, 5, 8 });
        List<TrackNumber> trackNumbers = new ArrayList<>();

        trackNumbers.add(new TrackNumber(new Integer[] { 4, 2, 1 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 9, 6, 7 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 7, 8, 5 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 0, 7, 8 }));
        trackNumbers.add(new TrackNumber(new Integer[] { 5, 9, 8 }));
        for (TrackNumber num : trackNumbers) {
            printPossibleNumbers(bombaMisilGuesser,
                    num,
                    GameUtils.getMissile(trackNumber.getDigits(), num.getDigits()),
                    GameUtils.getBomb(trackNumber.getDigits(), num.getDigits()));
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

    private static void printPossibleNumbers(BombaMisilGuesser bmg, TrackNumber trackNumber, int missile, int bomb) {
        bmg.updateTrackNumber(trackNumber, missile, bomb);
        System.out.println(trackNumber.toString());
        for (Integer[] num : bmg.getPossibleNumbers()) {
            System.out.println("(/\\) " + Arrays.toString(num));
        }

        Map<Integer, Integer> digitCounts = new HashMap<>();
        for (Integer[] num : bmg.getPossibleNumbers()) {
            for (Integer digits : num) {
                if (digitCounts.get(digits) == null) {
                    digitCounts.put(digits, 1);
                } else {
                    digitCounts.put(digits, digitCounts.get(digits) + 1);
                }
            }
        }

        digitCounts.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
