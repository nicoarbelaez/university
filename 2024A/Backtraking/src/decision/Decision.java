package decision;

public class Decision {

    public void run() {
        int i = 1;
        test(new Sudoku(new int[][] {
                { 0, 4, 3, 0 },
                { 0, 1, 2, 4 },
                { 4, 0, 0, 3 },
                { 0, 3, 0, 2 }
        }), i++);
        test(new Sudoku(new int[][] {
                { 0, 0, 3, 0 },
                { 0, 0, 4, 0 },
                { 1, 4, 0, 0 },
                { 0, 2, 0, 4 }
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
    }

    private void test(Sudoku sudoku, int numberTest) {
        System.out.println("=================================="); // TODO: Print
        System.out.println("Test " + numberTest + ":"); // TODO: Print

        generateBoard(sudoku);
        solveBoard(sudoku);

        System.out.println("=================================="); // TODO: Print
    }

    private void generateBoard(Sudoku sudoku) {
        if (sudoku.hasEmpty()) {
            sudoku.newGame(Difficulty.HARD);
        }

        System.out.println("Time: " + sudoku.getNanoTime() + "ns"); // TODO: Print
        System.out.println("Leaf nodes: " + sudoku.getLeafNodes()); // TODO: Print
        System.out.println(sudoku); // TODO: Print
    }

    private void solveBoard(Sudoku sudoku) {
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
