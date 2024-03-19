import decisions.BacktrackingSudoku;
import decisions.Difficulty;
import decisions.Sudoku;

public class App {
    public static void main(String[] args) {
        int i = 1;
        test(new Sudoku(new int[][] {
                { 0, 2, 3, 4 },
                { 0, 0, 0, 2 },
                { 0, 1, 0, 3 },
                { 2, 0, 0, 1 }
        }), i++);
        test(new Sudoku(new int[][] {
                { 0, 8, 0, 0, 0, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 8, 4, 0, 9, 0 },
                { 0, 0, 6, 3, 2, 0, 0, 1, 0 },
                { 0, 9, 7, 0, 0, 0, 0, 8, 0 },
                { 8, 0, 0, 9, 0, 3, 0, 0, 2 },
                { 0, 1, 0, 0, 0, 0, 9, 5, 0 },
                { 0, 7, 0, 0, 4, 5, 8, 0, 0 },
                { 0, 3, 0, 7, 1, 0, 0, 0, 0 },
                { 0, 0, 8, 0, 0, 0, 0, 4, 0 }
        }), i++);
        test(new Sudoku(2), i++);
        test(new Sudoku(3), i++);

        test(new Sudoku(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 10, 0, 14 },
                { 0, 0, 0, 8, 1, 0, 0, 12, 3, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 10, 0, 0, 0, 0, 0, 8, 0, 0, 5, 0, 11, 0, 12, 4, 0 },
                { 0, 0, 0, 0, 5, 0, 0, 0, 0, 10, 0, 12, 0, 0, 0, 0 },
                { 5, 8, 0, 9, 0, 0, 4, 13, 0, 0, 0, 0, 12, 7, 0, 0 },
                { 0, 0, 14, 11, 0, 10, 0, 0, 1, 0, 0, 0, 0, 0, 2, 9 },
                { 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 6, 0 },
                { 3, 6, 0, 2, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 15 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 12 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 6, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0 },
                { 8, 0, 0, 0, 0, 15, 0, 3, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 4, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0 },
                { 0, 15, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0 }
        }), i++);
        test(new Sudoku(4), i++);
    }

    private static void test(Sudoku sudoku, int numberTest) {
        System.out.println("=================================="); // TODO: Print
        System.out.println("Test " + numberTest + ":"); // TODO: Print

        generateBoard(sudoku);
        solveBoard(sudoku);

        System.out.println("=================================="); // TODO: Print
    }

    private static void generateBoard(Sudoku sudoku) {
        if (sudoku.hasEmpty()) {
            sudoku.newGame(Difficulty.HARD);
        }

        System.out.println("Time: " + sudoku.getNanoTime() + "ns"); // TODO: Print
        System.out.println("Leaf nodes: " + sudoku.getLeafNodes()); // TODO: Print
        System.out.println(sudoku); // TODO: Print
    }

    private static void solveBoard(Sudoku sudoku) {
        BacktrackingSudoku backtrackingSudoku = new BacktrackingSudoku(sudoku);

        if (backtrackingSudoku.solve()) {
            System.out.println("Solved!!"); // TODO: Print
            System.out.println(sudoku); // TODO: Print
        } else {
            System.out.println("No solution!!"); // TODO: Print
        }
        System.out.println("Time: " + backtrackingSudoku.getNanoTime() + "ns"); // TODO: Print
        System.out.println("Leaf nodes: " + backtrackingSudoku.getLeafNodes()); // TODO: Print
    }
}
