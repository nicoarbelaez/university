package pointOne.vehicles;

public class TestVehicle {
    public TestVehicle() {
        System.out.println("Manufacturer: " + Vehicle.MAKE);
        System.out.println("Number of vehicles manufactured: " + Vehicle.numVehicles);

        Vehicle vehicle1 = new Vehicle("Vision");
        System.out.println(vehicle1);

        Vehicle vehicle2 = new Vehicle("Edict");
        System.out.println(vehicle2);

        System.out.println("Number of vehicles manufactured: " + Vehicle.numVehicles);
    }

    /*
     * Se comentan las siguientes líneas para evitar errores y que el codigo se
     * pueda lanzar en bucle para el taller 10
     */
    // public static void main(String[] args) {
    //     System.out.println("Manufacturer: " + Vehicle.MAKE);
    //     System.out.println("Number of vehicles manufactured: " +
    //             Vehicle.numVehicles);

    //     Vehicle vehicle1 = new Vehicle("Vision");
    //     System.out.println(vehicle1);

    //     Vehicle vehicle2 = new Vehicle("Edict");
    //     System.out.println(vehicle2);

    //     System.out.println("Number of vehicles manufactured: " +
    //             Vehicle.numVehicles);
    // }
}
