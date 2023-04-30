package pointTwo.vehicles;

public class Vehicle {
	public static String MAKE = "Augur";
	public static int numVehicles = 0;
	
	private String chassisNo;
	private String model;

    public Vehicle(String model) {
        numVehicles++;
        setChassisNo("ch" + numVehicles);
        setModel(model);
        System.out.println("Vehicle manufactured");
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString(){
    	return "The vehicle is manufactured by: " + MAKE + "\nThe model type is " + model + "\nThe chassis number is " + chassisNo;
    }

    public void setMake(String make) {
        MAKE = make;
    }
}
