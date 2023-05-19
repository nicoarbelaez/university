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

	public void addItem() {
		System.out.println("+---------------------------------+");
		System.out.println("|     Spaceship inventory ADD     |");
		System.out.println("+---------------------------------+");
		System.out.println("[1] Shuttle vehicles");
		System.out.println("[2] Unmanned spacecraft");
		System.out.println("[3] Manned spacecraft");
		System.out.println("[0] Return");
		System.out.print(">> ");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			spacecraftList.add(new ShuttleVehicles());
			break;
		case 2:
			spacecraftList.add(new UnmannedSpacecraft());
			break;
		case 3:
			spacecraftList.add(new MannedSpacecraft(1, 2));
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
		spacecraftList.remove(1);
	}

	public void searchItem() {
	}

	public String toString() {
	    if (spacecraftList.isEmpty()) {
	        return "There is no registered spacecraft";
	    }

	    StringBuilder sb = new StringBuilder();
	    sb.append("+-").append("-".repeat(10)).append("-+-").append("-".repeat(15)).append("-+---------------------+\n");
	    sb.append("| ").append(String.format("%-10s", "ID")).append(" | ").append(String.format("%-15s", "Date")).append(" | Name                |\n");
	    sb.append("+-").append("-".repeat(10)).append("-+-").append("-".repeat(15)).append("-+---------------------+\n");

	    for (Spacecraft spacecraft : spacecraftList) {
	        sb.append("| ").append(String.format("%-10s", spacecraft.getId())).append(" | ")
	                .append(String.format("%-15s", spacecraft.getDateOfActivity())).append(" | ")
	                .append(String.format("%-20s", spacecraft.getName())).append(" |\n");
	    }

	    sb.append("+-").append("-".repeat(10)).append("-+-").append("-".repeat(15)).append("-+---------------------+\n");

	    return sb.toString();
	}

}
