package decision;

import utils.Color;

public class Sudoku {
    /**
     * The size of the region defines the range of numbers.
     * <p>
     * Example we define {@code 3} as the region size, we square the size and this
     * will give us the
     * range, in this case the range is {@code 1 - 9}.
     */
    private static final int DEFAULT_REGION_SIZE = 3;
    private int sizeOfRegion;
    private int numberOfRegions;
    private long nanoTime;
    private int leafNodes = 1;
    private int[][] board;
    private boolean[][] modifiableCells;
    private Difficulty difficulty;

    public Sudoku() {
        this(DEFAULT_REGION_SIZE, Difficulty.EASY);
    }

    public Sudoku(int[][] board) {
        this((int) Math.sqrt(board.length), board);
    }

    public Sudoku(int sizeOfRegion) {
        this(sizeOfRegion, Difficulty.EASY);
    }

    public Sudoku(int sizeOfRegion, Difficulty difficulty) {
        this.sizeOfRegion = sizeOfRegion;
        this.numberOfRegions = sizeOfRegion * sizeOfRegion;
        this.difficulty = difficulty;
        this.board = new int[numberOfRegions][numberOfRegions];
        this.modifiableCells = new boolean[numberOfRegions][numberOfRegions];
    }

    private Sudoku(int sizeOfRegion, int[][] board) {
        this.sizeOfRegion = sizeOfRegion;
        this.numberOfRegions = sizeOfRegion * sizeOfRegion;
        this.board = board;
        this.modifiableCells = new boolean[numberOfRegions][numberOfRegions];
    }

    public void newGame() {
        newGame(difficulty);
    }

    public void newGame(Difficulty difficulty) {
        this.difficulty = difficulty;
        emptyBoard();

        while (!generateBoard()) {
            emptyBoard();
        }

        removeNumbersForDifficulty();
    }

    public boolean play(int row, int col, int num) {
        if (num < 1 || num > numberOfRegions) {
            return false;
        }

        if (isSafe(row, col, num)) {
            board[row][col] = num;
            modifiableCells[row][col] = true;
            return true;
        }
        return false;
    }

    public boolean undo(int row, int col) {
        if (modifiableCells[row][col]) {
            board[row][col] = 0;
            modifiableCells[row][col] = false;
            return true;
        }
        return false;
    }

    public boolean isModifiable(int row, int col) {
        return modifiableCells[row][col];
    }

    public boolean isSafe(int row, int col, int num) {
        return (isRowSafe(row, num) && isColSafe(col, num) && isRegionSafe(row, col, num));
    }

    public int getBoardSize() {
        return board.length;
    }

    public boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    public boolean hasEmpty() {
        int emptyCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        return emptyCount == (board.length * board.length);
    }

    private void removeNumbersForDifficulty() {
        int hints = difficulty.getNumberOfHints(numberOfRegions);
        int cellsToRemove = (numberOfRegions * numberOfRegions) - hints;
        while (cellsToRemove > 0) {
            int row = (int) (Math.random() * numberOfRegions);
            int col = (int) (Math.random() * numberOfRegions);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    private void emptyBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
                modifiableCells[i][j] = false;
            }
        }
    }

    private boolean isRowSafe(int row, int num) {
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isColSafe(int col, int num) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isRegionSafe(int row, int col, int num) {
        int rowStart = row - row % sizeOfRegion;
        int colStart = col - col % sizeOfRegion;

        for (int i = 0; i < sizeOfRegion; i++) {
            for (int j = 0; j < sizeOfRegion; j++) {
                if (board[i + rowStart][j + colStart] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    sb.append(Color.RED);
                } else

                    sb.append(Color.BLUE);

                if (modifiableCells[i][j]) {
                    sb.append(Color.GREEN);
                }
                sb.append(board[i][j]);
                sb.append(Color.WHITE);
                sb.append(" ");

                if ((j + 1) % sizeOfRegion == 0 && (j + 1) != board.length) {
                    sb.append("| ");
                }
            }

            sb.append("\n");

            if ((i + 1) % sizeOfRegion == 0) {
                for (int j = 0; j < board.length; j++) {
                    if (j % sizeOfRegion == 0 && (j + 1) != board.length && j != 0) {
                        sb.append("+ ");
                    }
                    sb.append("- ");
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    // Backtracking algorithm get the board
    private boolean generateBoard() {
        if (hasEmpty()) {
            assignRandomHints(numberOfRegions * 2);
        }

        long timeStart = System.nanoTime();
        int[] locationEmpty = findEmptyLocation();

        if (locationEmpty == null) {
            nanoTime = System.nanoTime() - timeStart;
            return true;
        }

        int row = locationEmpty[0];
        int col = locationEmpty[1];

        for (int num = 1; num <= getBoardSize(); num++) {
            if (isSafe(row, col, num)) {
                board[row][col] = num;

                if (generateBoard()) {
                    return true;
                }

                undo(row, col);
            }
        }
        
        leafNodes++;
        nanoTime = System.nanoTime() - timeStart;
        return false;
    }

    private void assignRandomHints(int numberHints) {
        int length = board.length;
        while (numberHints > 0) {
            int row = (int) (Math.random() * length);
            int col = (int) (Math.random() * length);

            if (board[row][col] == 0) {
                int randomNumber = (int) (Math.random() * length + 1);

                if (isSafe(row, col, randomNumber)) {
                    board[row][col] = randomNumber;
                    numberHints--;
                }
            }
        }
    }

    private int[] findEmptyLocation() {
        for (int row = 0; row < getBoardSize(); row++) {
            for (int col = 0; col < getBoardSize(); col++) {
                if (isEmpty(row, col)) {
                    return new int[] { row, col };
                }
            }
        }
        return null;
    }
    // Backtracking algorithm get the board

    public static int getDefaultRegionSize() {
        return DEFAULT_REGION_SIZE;
    }

    public int getSizeOfRegion() {
        return sizeOfRegion;
    }

    public void setSizeOfRegion(int sizeOfRegion) {
        this.sizeOfRegion = sizeOfRegion;
    }

    public int getNumberOfRegions() {
        return numberOfRegions;
    }

    public void setNumberOfRegions(int numberOfRegions) {
        this.numberOfRegions = numberOfRegions;
    }

    public long getNanoTime() {
        return nanoTime;
    }

    public void setNanoTime(long nanoTime) {
        this.nanoTime = nanoTime;
    }

    public int getLeafNodes() {
        return leafNodes;
    }

    public void setLeafNodes(int leafNodes) {
        this.leafNodes = leafNodes;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean[][] getModifiableCells() {
        return modifiableCells;
    }

    public void setModifiableCells(boolean[][] modifiableCells) {
        this.modifiableCells = modifiableCells;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
