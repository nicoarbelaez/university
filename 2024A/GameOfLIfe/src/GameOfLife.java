import java.util.Random;

public class GameOfLife {
    private boolean[][] board;
    private final long seed;
    private static final int NUM_GENERATIONS = 25;
    private static final boolean ALIVE = true;
    private static final boolean DEAD = false;

    public GameOfLife(int size, long seed) {
        this.seed = seed;
        this.board = new boolean[size][size];
        this.initBoard();
    }

    public GameOfLife(int size, int[][] cells) {
        this.seed = 0;
        this.board = new boolean[size][size];
        for (int[] cell : cells) {
            this.board[cell[0]][cell[1]] = ALIVE;
        }
    }

    public boolean updateCellState(int row, int col) {
        int livingNeighbors = getLivingNeighbors(row, col);

        // Nacimiento
        if (livingNeighbors == 3 && this.board[row][col] == DEAD) {
            return ALIVE;
        }

        // Muerte
        if (livingNeighbors > 3 || livingNeighbors < 2) {
            return DEAD;
        }

        // Supervivencia
        if (livingNeighbors == 2 || livingNeighbors == 3) {
            return ALIVE;
        }

        return DEAD;
    }

    public int getLivingNeighbors(int row, int col) {
        int livingCount = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (i >= 0 && j >= 0 && i < this.board.length && j < this.board[i].length && board[i][j]) {
                    livingCount++;
                }
            }
        }
        return livingCount;
    }

    public void simulate() {
        simulateGenerations(NUM_GENERATIONS);
    }

    public void simulateGenerations(int numGenerations) {
        boolean[][] copyBoard = new boolean[this.board.length][this.board[0].length];
        StringBuilder sb = new StringBuilder();

        for (int gen = 1; gen <= numGenerations; gen++) {
            sb.append("Generation ").append(gen).append(":\n").append(this).append("\n");
            System.out.println(sb.toString());
            try {
                for (int i = 0; i < this.board.length; i++) {
                    for (int j = 0; j < this.board[i].length; j++) {
                        copyBoard[i][j] = updateCellState(i, j);
                    }
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            for (int i = 0; i < this.board.length; i++) {
                this.board[i] = copyBoard[i].clone();
            }
        }
    }

    @Override
    public String toString() {
        return showBoard();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j] ? "■" : ".");
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void initBoard() {
        Random random = new Random(this.seed);
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = random.nextBoolean();
            }
        }
    }
}
