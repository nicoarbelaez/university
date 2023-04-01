package pointOne;

public class PointOne {
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

    public String toString() {
        String response = "";
        response += "public class PointOne {\n";
        response += "    private int numSides;\n";
        response += "    private boolean regular;\n";
        response += "\n";
        response += "    public PointOne(int numSides, boolean regular) {\n";
        response += "        this.numSides = numSides;\n";
        response += "        this.regular = regular;\n";
        response += "    }\n";
        response += "\n";
        response += "    public PointOne(int numSides) {\n";
        response += "        this.numSides = numSides;\n";
        response += "        this.regular = false;\n";
        response += "    }\n";
        response += "\n";
        response += "    public int getNumSides() {\n";
        response += "        return numSides;\n";
        response += "    }\n";
        response += "\n";
        response += "    public void setNumSides(int numSides) {\n";
        response += "        this.numSides = numSides;\n";
        response += "    }\n";
        response += "\n";
        response += "    public boolean isRegular() {\n";
        response += "        return regular;\n";
        response += "    }\n";
        response += "\n";
        response += "    public void setRegular(boolean regular) {\n";
        response += "        this.regular = regular;\n";
        response += "    }\n";
        response += "}\n";
        return response;
    }
}

