public class Game {

    private static int numberOfGames = 0; // Contador de partidas
    private static int gamesTied = 0; // Contador de empates

    // Constantes de movimiento
    public static final byte ROCK = 0;
    public static final byte PAPER = 1;
    public static final byte SCISSORS = 2;

    private int gameID;
    private Player winner;
    private String moves;
    private Player[] players;

    public Game(Player[] players) {
        gameID = Game.getNumberOfGames();
        Game.numberOfGames++;
        this.players = players;
    }

    /**
     * Método que inicia la partida
     * 
     * PIEDRA(0) / PAPEL(1) = PAPEL(1)
     * PIEDRA(0) / TIJERA(2) = PIEDRA(0)
     * PAPEL(1) / TIJERA(2) = TIJERA(2)
     * 
     * @return void
     */
    public void start() {
        byte movePlayer1 = players[0].play();
        byte movePlayer2 = players[1].play();

        setMoves(movePlayer1, movePlayer2);

        if (movePlayer1 == movePlayer2) {
            Game.gamesTied++;
            return;
        }

        determineWinner(movePlayer1, movePlayer2);
    }

    public String toString() {
        String winnerInfo = getWinner();
        String movesInfo = "[" + getMoves() + "]";
        String str = "+---Partida #" + gameID + "---------+\n"
                + "| Ganador: " + winnerInfo + "\n"
                + "| " + movesInfo + "\n"
                + "+-----------------------+";

        return str;
    }

    private void determineWinner(byte movePlayer1, byte movePlayer2) {
        winner = (movePlayer1 > movePlayer2) ? players[0] : players[1];
        winner.addWin();
    }

    // Getters y Setters
    public String getWinner() {
        String winner = "";
        if (this.winner == null) {
            winner = "Ninguno";
        } else {
            winner = this.winner.getName();
        }
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setMoves(byte movePlayer1, byte movePlayer2) {
        this.moves = Game.showPlay(movePlayer1) + " vs " + Game.showPlay(movePlayer2);
    }

    public String getMoves() {
        return moves;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public static String showPlay(byte move) {
        String str = "";
        switch (move) {
            case Game.ROCK:
                str = "Piedra";
                break;
            case Game.PAPER:
                str = "Papel";
                break;
            case Game.SCISSORS:
                str = "Tijera";
                break;
        }
        return str;
    }

    // Static Getters
    public static int getNumberOfGames() {
        return numberOfGames;
    }

    public static int getGamesTied() {
        return gamesTied;
    }
}
