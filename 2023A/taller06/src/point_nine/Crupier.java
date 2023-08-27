package point_nine;

import java.util.Random;

public class Crupier {
    private Hand hand = new Hand("Crupier (computer)");

    public boolean playHand() {
        Random r = new Random();
        boolean condition = r.nextInt(2) == 1 && hand.getScore() < 16;
        boolean response = condition ? true : false;
        System.out.println("Crupier is thinking...");
        // try-catch para poder manejar el delay.
        try {
            Thread.sleep(2000); // Agrega un delay de 2 segundos a la respuesta.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
