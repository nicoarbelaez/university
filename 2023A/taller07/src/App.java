import point_five.PointFive;
import point_four.PointFour;

class App {
    public static void main(String[] args) {
        try {
            resetColorConsole();
            System.out.println("*******************");
            System.out.println("*     Punto 4     *");
            System.out.println("*******************");

            System.out.println(ColorConstant.GREEN);
            new PointFour();

            resetColorConsole();
            System.out.println("*******************");
            System.out.println("*     Punto 5     *");
            System.out.println("*******************");
            System.out.println(ColorConstant.YELLOW);
            new PointFive();
            resetColorConsole();

        } catch (Exception e) {
            System.out.println("Error: " + e);
            resetColorConsole();
        }
    }

    private static void resetColorConsole() {
        System.out.println(ColorConstant.RESET);
    }
}
