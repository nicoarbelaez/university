package main.java.com.nicolasarb.parcial03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.nicolasarb.parcial03.manned_spacecraft.MannedSpacecraft;
import main.java.com.nicolasarb.parcial03.shuttle_vehicles.ShuttleVehicles;
import main.java.com.nicolasarb.parcial03.unmanned_spacecraft.UnmannedSpacecraft;

public class Inventory {
	private final static List<Spacecraft> spacecraftList = new ArrayList<>();
	private Scanner sc;

	public Inventory(Scanner sc) {
		this.sc = sc;
	}

	private boolean isEmptySpacecraftList() {
		if (spacecraftList.isEmpty()) {
			System.out.println(ColorConstant.RED);
			System.out.println("There is no registered spacecraft");
			System.out.println(ColorConstant.RESET);
			return true;
		}
		return false;
	}

	public void addItem() {
		System.out.println("+---------------------------------+");
		System.out.println("|     Spaceship inventory ADD     |");
		System.out.println("+---------------------------------+");
		System.out.println("Spaceship conut: " + spacecraftList.size());
		System.out.println("[1] Shuttle vehicles");
		System.out.println("[2] Unmanned spacecraft");
		System.out.println("[3] Manned spacecraft");
		System.out.println("[4] Test");
		System.out.println("[0] Return");
		System.out.print(">> ");

		int option = sc.nextInt();

		switch (option) {
			case 1:
				spacecraftList.add(new ShuttleVehicles(this.sc));
				break;
			case 2:
				spacecraftList.add(new UnmannedSpacecraft(this.sc));
				break;
			case 3:
				spacecraftList.add(new MannedSpacecraft(this.sc));
				break;
			case 4:
				spacecraftList.add(new ShuttleVehicles(true, this.sc));
				spacecraftList.add(new UnmannedSpacecraft(true, this.sc));
				spacecraftList.add(new MannedSpacecraft(true, this.sc));
				break;
			case 0:
				System.out.println("Returning to the main menu...");
				break;
			default:
				this.addItem();
				break;

		}
	}

	public void removeItem() {
		System.out.println("+------------------------------------+");
		System.out.println("|     Spaceship inventory REMOVE     |");
		System.out.println("+------------------------------------+");
		if (isEmptySpacecraftList())
			return;

		System.out.println("Please enter the ID of the spacecraft you want to remove");
		System.out.print(">> ");
		int id = sc.nextInt();
		for (Spacecraft spacecraft : spacecraftList) {
			if (spacecraft.getId() == id) {
				System.out.print("Are you sure you want to remove the spacecraft with the ID " + id + "? [Y/N] ");
				String option = sc.next().charAt(0) + "";
				if (option.equalsIgnoreCase("Y")) {
					spacecraftList.remove(spacecraft);
					System.out.println("The spacecraft with the ID " + id + " has been removed");
				}
				return;
			}
		}
		System.out.println("The spacecraft with the ID " + id + " does not exist");
	}

	public void searchItem() {
		System.out.println("+------------------------------------+");
		System.out.println("|     Spaceship inventory SEARCH     |");
		System.out.println("+------------------------------------+");
		if (isEmptySpacecraftList())
			return;

		System.out.println("Please enter the ID or name of the spacecraft you want to search");
		System.out.print(">> ");
		String search = sc.next();
		for (Spacecraft spacecraft : spacecraftList) {
			if (spacecraft.getId() == Integer.parseInt(search) || spacecraft.getName().contains(search)) {
				System.out.println(spacecraft.toString());
				return;
			}
		}
		System.out.println("The spacecraft with the ID or name " + search + " does not exist");
	}

	public String toString() {
		System.out.println("+------------------------------------+");
		System.out.println("|     Spaceship inventory SEARCH     |");
		System.out.println("+------------------------------------+");
		if (isEmptySpacecraftList())
			return "";

		String strTemplate = "+------------+-------------------+---------------------+\n";
		strTemplate += "|     ID     |       Date        |         Name        |\n";
		strTemplate += "+------------+-------------------+---------------------+\n";

		for (Spacecraft spacecraft : spacecraftList) {
			strTemplate += "| " + String.format("%-10s", spacecraft.getId()) + " | " +
					String.format("%-17s", spacecraft.getDateOfActivity()) + " | " +
					String.format("%-20s", spacecraft.getName()) + " |\n";
		}

		strTemplate += "+------------+-------------------+---------------------+\n";

		return strTemplate;
	}

}
