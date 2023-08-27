package main.java.com.nicolasarb.parcial03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spacecraft {

	public static final int GROUND_DISTANCE = 36000;
	public static final float GRAVITY = 9.8f;

	private static int idCounter = 0;
	private int id;
	private String name;
	private String model;
	private String type;
	private double length; // Altura
	private double diameter; // Diametro
	private double stages; // Etapas
	private double weight; // Peso
	private String push; // Empuje
	private String state; // Estado
	private String propulsionSystem;
	private String propellantCapacity; // Capacidad de combustible
	private String launchVehicle;
	private String orbit;
	private String dateOfActivity;
	private String fuelsAndOxidizingAgents;
	private final List<String> missions = new ArrayList<String>();

	private Scanner sc;
	protected Spacecraft(Scanner sc) {
		this.sc = sc;
	}

	public void inputSpaceShipInfo() {
		try {
			System.out.print("Name: ");
			this.setName(sc.next());
			System.out.print("Model: ");
			this.setModel(sc.next());
			System.out.print("Length: ");
			this.setLength(sc.nextDouble());
			System.out.print("Diameter: ");
			this.setDiameter(sc.nextDouble());
			System.out.print("Stages: ");
			this.setStages(sc.nextDouble());
			System.out.print("Weight: ");
			this.setWeight(sc.nextDouble());
			System.out.print("Push: ");
			this.setPush(sc.next());
			System.out.print("State: ");
			this.setState(sc.next());
			System.out.print("Propulsion system: ");
			this.setPropulsionSystem(sc.next());
			System.out.print("Propellant capacity: ");
			this.setPropellantCapacity(sc.next());
			System.out.print("Launch vehicle: ");
			this.setLaunchVehicle(sc.next());
			System.out.print("Orbit: ");
			this.setOrbit(sc.next());
			System.out.print("Date of activity: ");
			this.setDateOfActivity(sc.next());
			System.out.print("Missions: ");
			this.setMissions(sc.next());
			System.out.print("Fuels and oxidizing agents: ");
			this.setFuelsAndOxidizingAgents(sc.next());
		} catch (Exception e) {
			System.out.println(ColorConstant.RED);
			System.out.println("Invalid input. Try again...");
			System.out.println(ColorConstant.RESET);
			this.inputSpaceShipInfo();
		}
	}

	public void testInputSpaceShipInfo(String type) {
		setId(idCounter);
		this.setName(type + " BW" + (int) (idCounter * 1.5));
		this.setModel(type + "SN" + idCounter);
		this.setLength(120.0);
		this.setDiameter(9.0);
		this.setStages(2);
		this.setWeight(4400000.0);
		this.setPush("72 MN");
		this.setState("In development");
		this.setPropulsionSystem("Raptor");
		this.setPropellantCapacity("1200 t");
		this.setLaunchVehicle("Super Heavy");
		this.setOrbit("Low Earth orbit");
		this.setDateOfActivity("20" + (int) (idCounter * 0.2 + 1) + (int) (idCounter * 0.1 + 1) + "-0"
				+ (int) (idCounter * 0.6 + 1) + "-2" + (int) (idCounter * 0.5 + 1));
		this.setMissions(type + "development program, Starlink, Lunar " + type + ", Mars " + type);
		this.setFuelsAndOxidizingAgents("240 t CH4 + 860 t O2");
	}

	public String toString() {
		return "ID: " + this.getId() + "\n" + "Name: " + this.getName() + "\n" + "Model: " + this.getModel() + "\n"
				+ "Type: " + this.getType() + "\n" + "Length: " + this.getLength() + "\n" + "Diameter: "
				+ this.getDiameter() + "\n" + "Stages: " + this.getStages() + "\n" + "Weight: " + this.getWeight()
				+ "\n" + "Push: " + this.getPush() + "\n" + "State: " + this.getState() + "\n" + "Propulsion system: "
				+ this.getPropulsionSystem() + "\n" + "Propellant capacity: " + this.getPropellantCapacity() + "\n"
				+ "Launch vehicle: " + this.getLaunchVehicle() + "\n" + "Orbit: " + this.getOrbit() + "\n"
				+ "Date of activity: " + this.getDateOfActivity() + "\n" + "Missions: " + this.getMissions() + "\n"
				+ "Fuels and oxidizing agents: " + this.getFuelsAndOxidizingAgents() + "\n";
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		if (id > idCounter || id < idCounter)
			throw new IllegalArgumentException("El id debe ser igual a " + idCounter);
		this.id = id;
		idCounter++;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getDiameter() {
		return this.diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getStages() {
		return this.stages;
	}

	public void setStages(double stages) {
		this.stages = stages;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPush() {
		return this.push;
	}

	public void setPush(String push) {
		this.push = push;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPropulsionSystem() {
		return this.propulsionSystem;
	}

	public void setPropulsionSystem(String propulsionSystem) {
		this.propulsionSystem = propulsionSystem;
	}

	public String getPropellantCapacity() {
		return this.propellantCapacity;
	}

	public void setPropellantCapacity(String propellantCapacity) {
		this.propellantCapacity = propellantCapacity;
	}

	public String getLaunchVehicle() {
		return this.launchVehicle;
	}

	public void setLaunchVehicle(String launchVehicle) {
		this.launchVehicle = launchVehicle;
	}

	public String getOrbit() {
		return this.orbit;
	}

	public void setOrbit(String orbit) {
		this.orbit = orbit;
	}

	public String getDateOfActivity() {
		return dateOfActivity;
	}

	public void setDateOfActivity(String dateOfActivity) throws DateTimeParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateOfActivity, formatter);
		this.dateOfActivity = date.format(formatter);
	}

	public String getFuelsAndOxidizingAgents() {
		return this.fuelsAndOxidizingAgents;
	}

	public void setFuelsAndOxidizingAgents(String fuelsAndOxidizingAgents) {
		this.fuelsAndOxidizingAgents = fuelsAndOxidizingAgents;
	}

	public String getMissions() {
		String missions = "";
		for (String mission : this.missions) {
			missions += mission + ", ";
		}
		return missions.substring(0, missions.length() - 2);
	}

	public void setMissions(String missions) {
		String[] missionsArray = missions.split(",\\s*");
		// ",\\s*" es una expresion regular que separa por comas y espacios
		for (String mission : missionsArray) {
			this.missions.add(mission.trim());
		}
	}

}
