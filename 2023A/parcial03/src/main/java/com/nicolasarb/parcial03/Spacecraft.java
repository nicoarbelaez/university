package main.java.com.nicolasarb.parcial03;

import java.util.ArrayList;
import java.util.List;

public class Spacecraft {

	private String name;
	private String model;
	private double length;
	private double width;
	private double height;
	private double weight;
	private String propulsionSystem;
	private String launchVehicle;
	private String orbit;
	private String dateOfActivity;
	private List<String> missions;
	private List<String> fuelsAndOxidizingAgents;

	public Spacecraft() {
		this.name = "";
		this.model = "";
		this.length = 0;
		this.width = 0;
		this.height = 0;
		this.weight = 0;
		this.propulsionSystem = "";
		this.launchVehicle = "";
		this.orbit = "";
		this.dateOfActivity = "";
		this.missions = new ArrayList<>();
		this.fuelsAndOxidizingAgents = new ArrayList<>();
	}

	public Spacecraft(String name, String model, double length, double width, double height, double weight, String propulsionSystem, String launchVehicle, String orbit, String dateOfActivity,
			List<String> missions, List<String> fuelsAndOxidizingAgents) {
		this.name = name;
		this.model = model;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.propulsionSystem = propulsionSystem;
		this.launchVehicle = launchVehicle;
		this.orbit = orbit;
		this.dateOfActivity = dateOfActivity;
		this.missions = missions;
		this.fuelsAndOxidizingAgents = fuelsAndOxidizingAgents;
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

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPropulsionSystem() {
		return this.propulsionSystem;
	}

	public void setPropulsionSystem(String propulsionSystem) {
		this.propulsionSystem = propulsionSystem;
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

	public void setDateOfActivity(String dateOfActivity) {
		this.dateOfActivity = dateOfActivity;
		// LocalDate dateOfActivity = ejemplo.getDateOfActivity();
	}

	public List<String> getMissions() {
		return this.missions;
	}

	public void setMissions(List<String> missions) {
		this.missions = missions;
	}

	public List<String> getFuelsAndOxidizingAgents() {
		return fuelsAndOxidizingAgents;
	}

	public void setFuelsAndOxidizingAgents(List<String> fuelsAndOxidizingAgents) {
		this.fuelsAndOxidizingAgents = fuelsAndOxidizingAgents;
	}

}
