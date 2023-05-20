package main.java.com.nicolasarb.parcial03.shuttle_vehicles;

import java.util.Scanner;

import main.java.com.nicolasarb.parcial03.Spacecraft;
import main.java.com.nicolasarb.parcial03.interfaces.ISpacecraft;

public class ShuttleVehicles extends Spacecraft implements ISpacecraft {

	public final String type = "Shuttle vehicle";
	private double payloadCapacity; // Capacidad de carga util

	private Scanner sc;

	public ShuttleVehicles(Scanner sc) {
		super(sc);
		this.sc = sc;

		this.inputData();
	}

	public ShuttleVehicles(boolean test, Scanner sc) {
		super(sc);
		this.sc = sc;

		if (test)
			this.testInputSpaceShipInfo(this.type);
		else
			this.inputData();
	}

	@Override
	public void inputData() {
		this.inputSpaceShipInfo();
		System.out.print("Payload capacity: ");
		this.setPayloadCapacity(sc.nextDouble());

	}

	public String toString() {
		return super.toString() + "\n" + "Payload capacity: " + this.getPayloadCapacity();
	}

	public double getPayloadCapacity() {
		return payloadCapacity;
	}

	public void setPayloadCapacity(double payloadCapacity) {
		this.payloadCapacity = payloadCapacity;
	}

	@Override
	public double calculateSpeed(double time) {
		// velocidad = distancia / tiempo
		double distance = calculateDistance(0, Spacecraft.GROUND_DISTANCE, 0, 0);
		return distance / time;
	}

	@Override
	public double calculateGForce(double speed) {
		// fuerza G = aceleración centrípeta / gravedad
		double accelerationCentripetal = speed * speed / Spacecraft.GROUND_DISTANCE;
		return accelerationCentripetal / Spacecraft.GRAVITY;
	}

	@Override
	public double calculateFuelRunOutTime(double fuelCapacity, double fuelConsumption) {
		// tiempo de agotamiento de combustible = capacidad de combustible / consumo de
		// combustible
		return fuelCapacity / fuelConsumption;
	}

	@Override
	public double calculateDistance(float x1, float x2, float y1, float y2) {
		// distancia = sqrt((x2 - x1)^2 + (y2 - y1)^2)
		double deltaX = x2 - x1;
		double deltaY = y2 - y1;
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

	@Override
	public double computeMaxSpeed(double acceleration, double mass) {
		// velocidad máxima = raíz cuadrada(2 * aceleración * distancia / masa)
		double distance = calculateDistance(0, Spacecraft.GROUND_DISTANCE, 0, 0);
		return Math.sqrt(2 * acceleration * distance / mass);
	}

	@Override
	public double computeOrbitalPeriod(double semiMajorAxis, double massOfCentralBody) {
		// periodo orbital = 2 * pi * raíz cuadrada(semieje mayor^3 / (constante
		// gravitacional * masa del cuerpo central))
		return 2 * Math.PI * Math.sqrt(Math.pow(semiMajorAxis, 3) / (Spacecraft.GRAVITY * massOfCentralBody));
	}
}
