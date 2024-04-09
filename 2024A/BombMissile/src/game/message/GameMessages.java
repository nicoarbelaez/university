package game.message;

public enum GameMessages {
    START_GAME_MESSAGE("Piensa en un número de %d dígitos y yo intentaré adivinarlo.\nPor cada intento, por favor indica cuántos misiles y bombas hay."),
    END_GAME_MESSAGE("¡Lo adiviné! El número era %s."),
    GAME_ALREADY_ENDED("El juego ya ha terminado."),
    GUESS_NUMBER_MESSAGE("[%d] Número %s:"),
    MISSILES_PROMPT("¿Cuántos misiles? "),
    BOMBS_PROMPT("¿Cuántas bombas? "),
    SUM_ERROR_MESSAGE("La suma de misiles y bombas no puede superar la cantidad de dígitos. Inténtalo de nuevo.");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
