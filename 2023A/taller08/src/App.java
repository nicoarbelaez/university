import java.util.Scanner;

import pointFourFiveSix.PointFourFiveSix;
import pointOne.PointOne;
import pointSevenEight.PointSevenEight;
import pointTwoThree.PointTwoThree;

public class App {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.println(ColorConstant.RESET);
				System.out.println("+------------------+");
				System.out.println("|     Taller 8     |");
				System.out.println("+------------------+");

				System.out.println("Enter the number of the point you want to see:");
				System.out.println("[1] Point 1");
				System.out.println("[2] Point 2 - 3");
				System.out.println("[4] Point 4 - 6");
				System.out.println("[7] Point 7 - 8");
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
						PointOne pointOne = new PointOne(response);
						System.out.println("Alert: Enter the source code of point one to see the solution!");
						System.out.println(pointOne);
						break;
					case 2:
					case 3:
						System.out.println(ColorConstant.CYAN);
						System.out.println("+---------------------+");
						System.out.println("|     Point 2 - 3     |");
						System.out.println("+---------------------+");
						new PointTwoThree();
						break;
					case 4:
					case 5:
					case 6:
						System.out.println(ColorConstant.CYAN);
						System.out.println("+---------------------+");
						System.out.println("|     Point 4 - 6     |");
						System.out.println("+---------------------+");
						System.out.println(
								"Alert: Enter the source code of point four, five and six to see the complete solution!");
						new PointFourFiveSix();
						break;
					case 7:
					case 8:
						System.out.println(ColorConstant.YELLOW);
						System.out.println("+---------------------+");
						System.out.println("|     Point 7 - 8     |");
						System.out.println("+---------------------+");
						new PointSevenEight();
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