package pointTwo.vehicles;

public class TestVehicle {
    public TestVehicle() {
        Vehicle vehicle1 = new Vehicle("Vision");
        Vehicle vehicle2 = new Vehicle("Edict");

        vehicle2.setMake("Seer");
        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println("Number of vehicles manufactured: " + Vehicle.numVehicles);
    }

    // public static void main(String[] args) {
    //     Vehicle vehicle1 = new Vehicle("Vision");
    //     Vehicle vehicle2 = new Vehicle("Edict");

    //     vehicle2.setMake("Seer");
    //     System.out.println(vehicle1);
    //     System.out.println(vehicle2);
    //     System.out.println("Number of vehicles manufactured: " + Vehicle.numVehicles);
    // }
}
