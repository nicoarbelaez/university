import poo.Coche;

public class Main {
	public static void main(String[] args) {
		Coche myCar = new Coche();
		
		myCar.setColor("blue");

		System.out.println(myCar.getColor());
		System.out.println("This car has " + myCar.getNumWheels() + " wheels");
	}
}
