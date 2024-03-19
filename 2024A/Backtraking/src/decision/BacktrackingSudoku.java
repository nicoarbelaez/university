package decision;

public class BacktrackingSudoku {
    private Sudoku sudoku;
    private long nanoTime = 0;
    private int leafNodes = 1;

    public BacktrackingSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public boolean solve() {
        long timeStart = System.nanoTime();
        int[] locationEmpty = findEmptyLocation();

        if (locationEmpty == null) {
            nanoTime = System.nanoTime() - timeStart;
            return true;
        }

        int row = locationEmpty[0];
        int col = locationEmpty[1];

        for (int num = 1; num <= sudoku.getBoardSize(); num++) {
            if (sudoku.play(row, col, num)) {
                if (solve()) {
                    return true;
                }

                sudoku.undo(row, col);
            }
        }

        leafNodes++;
        nanoTime = System.nanoTime() - timeStart;
        return false;
    }

    private int[] findEmptyLocation() {
        for (int row = 0; row < sudoku.getBoardSize(); row++) {
            for (int col = 0; col < sudoku.getBoardSize(); col++) {
                if (sudoku.isEmpty(row, col)) {
                    return new int[] { row, col };
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return sudoku.toString();
    }

    public int getLeafNodes() {
        return leafNodes;
    }

    public void setLeafNodes(int leafNodes) {
        this.leafNodes = leafNodes;
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public void setSudoku(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public long getNanoTime() {
        return nanoTime;
    }

    public void setNanoTime(long nanoTime) {
        this.nanoTime = nanoTime;
    }
}
