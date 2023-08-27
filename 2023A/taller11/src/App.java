import java.util.Scanner;

import pointFour.PointFour;
import pointOne.PointOne;
import pointThree.PointThree;
import pointTwo.PointTwo;

public class App {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println(ColorConstant.RESET);
                System.out.println("+------------------+");
                System.out.println("|     Taller 11     |");
                System.out.println("+------------------+");

                System.out.println("Enter the number of the point you want to see:");
                System.out.println("[1] Point 1");
                System.out.println("[2] Point 2");
                System.out.println("[3] Point 3");
                System.out.println("[4] Point 4");
                System.out.println("[0] Exit");
                System.out.print(">> ");
                int response = sc.nextInt();

                consoleClear();
                switch (response) {
                    case 1:
                        System.out.println(ColorConstant.GREEN);
                        System.out.println("+------------------+");
                        System.out.println("|     Point 1      |");
                        System.out.println("+------------------+");
                        new PointOne();
                        break;
                    case 2:
                        System.out.println(ColorConstant.BLUE);
                        System.out.println("+------------------+");
                        System.out.println("|     Point 2      |");
                        System.out.println("+------------------+");
                        new PointTwo();
                        break;
                    case 3:
                        System.out.println(ColorConstant.PURPLE);
                        System.out.println("+------------------+");
                        System.out.println("|     Point 3      |");
                        System.out.println("+------------------+");
                        new PointThree();
                        break;
                    case 4:
                        System.out.println(ColorConstant.YELLOW);
                        System.out.println("+------------------+");
                        System.out.println("|     Point 4      |");
                        System.out.println("+------------------+");
                        new PointFour();
                        break;
                    case 0:
                        System.out.println(ColorConstant.RESET);
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println(ColorConstant.RESET);
        }
    }

    private static void consoleClear() {
        System.out.println(ColorConstant.RESET);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}