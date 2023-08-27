package main.java.com.nicolasarb.parcial03.manned_spacecraft;

import main.java.com.nicolasarb.parcial03.Spacecraft;
import main.java.com.nicolasarb.parcial03.interfaces.ISpacecraft;

public class MannedSpacecraft extends Spacecraft implements ISpacecraft {
	private int storagePerPerson; // Cubic meters
	private int crewCapacity;
	
	MannedSpacecraft(int storagePerPerson, int crewCapacity){
		this.storagePerPerson = storagePerPerson;
		this.crewCapacity = crewCapacity;
	}

	public int getStoragePerPerson() {
		return storagePerPerson;
	}

	public void setStoragePerPerson(int storagePerPerson) {
		this.storagePerPerson = storagePerPerson;
	}

	public int getCrewCapacity() {
		return crewCapacity;
	}

	public void setCrewCapacity(int crewCapacity) {
		this.crewCapacity = crewCapacity;
	}

	@Override
	public double calculateSpeed(double time) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateGForce(double speed) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateFuelRunOutTime(double fuelCapacity, double fuelConsumption) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateDistance(float x1, float x2, float y1, float y2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double computeMaxSpeed(double acceleration, double mass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double computeOrbitalPeriod(double semimajorAxis, double massOfCentralBody) {
		// TODO Auto-generated method stub
		return 0;
	}
}
