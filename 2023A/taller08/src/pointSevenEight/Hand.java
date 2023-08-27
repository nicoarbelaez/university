package pointSevenEight;

public class Hand {
    private Card cardArray[] = new Card[5];
    private int cards = 0;
    private int score = 0;
    private String name = "Player default";
    private boolean isFullHand = false;
    private boolean isBusted = false;
  
    Hand(String name) {
      setName(name);
    }
  
    Hand() { // Sobre carga del constructor.
  
    }
  
    public String toString() {
      String tempString = "------------------------------------------------------------\n";
      tempString += ">>> Hand by " + getName() + " <<<\n[";
      for (int i = 0; i < getCards(); i++) {
        tempString += cardArray[i].toString() + " (" + cardArray[i].points + ")";
        if (i < getCards() - 1) {
          tempString += ", ";
        }
      }
      tempString += "]" + (getIsBusted() ? " (Busted)" : "") + "\nHand score: " + getScore();
      return tempString;
    }
  
    /**
     * Agrega una carta al arreglo de cartas de la mano.
     * 
     * @param card
     * @return true si se pudo agregar la carta.
     * @return false si no se pudo agregar la carta.
     */
    public boolean addCard(Card card) {
      boolean response = false;
  
      if (!getIsFullHand() || getScore() < 21) {
        cardArray[getCards()] = card;
        setCards(getCards() + 1);
        response = true;
  
        setIsBusted(); // Comprueba si el jugador se paso de 21.
        setIsFullHand(); // Comprueba si la mano esta llena.
      }
  
      return response;
    }
  
    public Card[] getCardArray() {
      return cardArray;
    }
  
    /**
     * Suma los puntos de las cartas de la mano.
     */
    public void sumScore() {
      setScore(0);
      for (int i = 0; i < getCards(); i++) {
        cardArray[i].points = cardArray[i].getPoints(cardArray[i].name);// Actualiza los puntos de la carta.
        setScore(getScore() + cardArray[i].points);
      }
    }
  
    public boolean getIsBusted() {
      return isBusted;
    }
  
    public boolean getIsFullHand() {
      return isFullHand;
    }
  
    /**
     * Verifica si la mano esta llena.
     */
    public void setIsFullHand() {
      if (getCards() >= 5) {
        this.isFullHand = true;
      } else {
        this.isFullHand = false;
      }
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public void setScore(int score) {
      this.score = score;
    }
  
    public void setCards(int cards) {
      this.cards = cards;
    }
  
    public String getName() {
      String s = this.name;
      String firstLetter = s.substring(0, 1);
      String restOfString = s.substring(1);
      String result = firstLetter.toUpperCase() + restOfString.toLowerCase();
      return result;
    }
  
    public int getScore() {
      return this.score;
    }
  
    public int getCards() {
      return this.cards;
    }
  
    /**
     * Verifica si el jugador se paso de 21.
     */
    private void setIsBusted() {
      sumScore();
  
      if (score > 21) {
        this.isBusted = true;
      } else
        this.isBusted = false;
    }
  }
  
