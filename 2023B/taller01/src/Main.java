public class Main {

    private static Player[] players = new Player[2];

    public static void main(String[] args) {

        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");

        // Solicitar el número de partidas a jugar
        System.out.print("¿Cuántas partidas quieres jugar?\n>> ");
        int gamesToPlay = test();

        Game[] games = new Game[gamesToPlay]; // Array de partidas

        // Crear e iniciar cada partida
        for (int i = 0; i < games.length; i++) {
            games[i] = new Game(players); // Instanciar cada elemento del array con 2 jugadores
            games[i].start(); // Iniciar partida actual del array
            System.out.println(games[i]);
        }
        System.out.println(printInfo());

        // Seleccionar una partida aleatoria para ver
        System.out.print("¿Qué partida quieres ver?\n>> ");
        int gameToSee = randomGame(games.length);
        System.out.println(games[gameToSee]);
    }

    // Generar un número aleatorio para las pruebas
    private static int test() {
        int random = (int) (Math.random() * 100) + 1;
        System.out.println(random);
        return random;
    }

    // Generar una partida aleatoria para ver
    private static int randomGame(int sizeGame) {
        int random = (int) (Math.random() * sizeGame);
        System.out.println(random);
        return random;
    }

    // Imprimir información general
    private static String printInfo() {
        String str = "\n\n+---------------------------------------+\n"
                + "| PIEDRA, PAPEL O TIJERA | ESTADÍSTICAS |\n"
                + "+---------------------------------------+\n"
                + players[0].toString() + "\n"
                + players[1].toString() + "\n"
                + "+---------------------+\n"
                + "| Partidas jugadas: " + Game.getNumberOfGames() + "\n"
                + "| Empates: " + Game.getGamesTied() + "\n"
                + "+---------------------+";
        return str;
    }
}
