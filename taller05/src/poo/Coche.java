package poo;

public class Coche {
    private int numWheels;
    private int length;
    private int width;
    private int engine;
    private int weight;
    private String color;

    public Coche() {
        numWheels = 4;
        length = 2000;
        width = 300;
        engine = 1600;
        weight = 500;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public String getLenght(){
        return "The length of the car is " + length + " cm";
    }

    public void setColor(String colorCoche){
        color = colorCoche;
    }

    public String getColor(){
        return "The color of the car is " + color;
    }

}
