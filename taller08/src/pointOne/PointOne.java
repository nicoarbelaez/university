package pointOne;

import java.util.Scanner;

public class PointOne {
	Scanner sc = new Scanner(System.in);
	
    private int numSides;
    private boolean regular;

    public PointOne(int numSides, boolean regular) {
        this.numSides = numSides;
        this.regular = regular;
    }

    public PointOne(int numSides) {
        this.numSides = numSides;
        this.regular = false;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }
}

