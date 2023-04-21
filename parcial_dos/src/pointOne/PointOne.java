package pointOne;

import java.util.Scanner;

public class PointOne {
	Scanner sc = new Scanner(System.in);

	public PointOne() {
		System.out.println("Digite una cadena de caracteres:");
		System.out.print(">> ");

		String str = sc.nextLine();
		int strLength = str.length();
		char[] strChar = new char[strLength];

		for (int i = 0; i < strLength; i++) {
			strChar[i] = str.charAt(i);
		}

		for (int i = 0; i < strChar.length; i++) {
			System.out.print("(" + strChar[i] + ")");
		}
	}
}
