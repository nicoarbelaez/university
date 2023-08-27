public class Player {

    private int gamesWon = 0; // Partidas ganadas
    private int rockCount = 0;
    private int paperCount = 0;
    private int scissorsCount = 0;
    private byte lastMovement;
    private String name = "Player";

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public byte play() {
        byte random = (byte) (Math.random() * 3);
        updateCounts(random);
        return random;
    }

    public void addWin() {
        gamesWon++;
    }

    private void updateCounts(byte move) {
        switch (move) {
            case Game.ROCK:
                rockCount++;
                break;
            case Game.PAPER:
                paperCount++;
                break;
            case Game.SCISSORS:
                scissorsCount++;
                break;
        }
    }

    public String toString() {
        String str = "+-----------------------+\n"
                + "| " + name + "\n"
                + "| > Ganadas: " + gamesWon + "\n"
                + "| >> Piedra: " + rockCount + "\n"
                + "| >> Papel: " + paperCount + "\n"
                + "| >> Tijeras: " + scissorsCount + "\n"
                + "+-----------------------+";
        return str;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getRockCount() {
        return rockCount;
    }

    public void setRockCount(int rockCount) {
        this.rockCount = rockCount;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public int getScissorsCount() {
        return scissorsCount;
    }

    public void setScissorsCount(int scissorsCount) {
        this.scissorsCount = scissorsCount;
    }

    public byte getLastMovement() {
        return lastMovement;
    }

    public void setLastMovement(byte lastMovement) {
        this.lastMovement = lastMovement;
    }

}
