import java.util.Scanner;
import theater.Reserved;

public class App {
    public static void main(String[] args) throws Exception {
        Reserved reserved = new Reserved(20, 20);

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("""
                    Bienvenido al sistema de reservas del teatro.
                    Seleccione una opción:
                    a) Crear reserva
                    b) Mostrar estado de las reservas
                    c) Anular reserva
                    [Otra opción para salir]
                    >>\s""");

            while (true) {

                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("a")) {
                    System.out.print("Ingrese el número de asiento que desea reservar: ");
                    String seatNumber = scanner.nextLine();
                    reserved.reserveSeat(seatNumber);
                } else if (option.equalsIgnoreCase("b")) {
                    reserved.displaySeatMatrix();
                } else if (option.equalsIgnoreCase("c")) {
                    System.out.print("Ingrese el número de asiento que desea anular: ");
                    String seatNumber = scanner.nextLine();
                    reserved.unreserveSeat(seatNumber);
                } else {
                    System.out.println("Gracias por utilizar el sistema de reservas del teatro.");
                    break;
                }

                if (option.equalsIgnoreCase("a") || option.equalsIgnoreCase("c")) {
                    reserved.displaySeatMatrix();
                }

                System.out.print("""

                        Seleccione una opción:
                        a) Crear reserva
                        b) Mostrar estado de las reservas
                        c) Anular reserva
                        [Otra opción para salir]
                        >>\s""");
            }
        }
    }
}
