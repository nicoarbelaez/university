package main.java.com.nicolasarb.parcial03.shuttle_vehicles;

import main.java.com.nicolasarb.parcial03.Spacecraft;
import main.java.com.nicolasarb.parcial03.interfaces.ISpacecraft;

public class ShuttleVehicles extends Spacecraft implements ISpacecraft {

	private double payloadCapacity;
	
	public ShuttleVehicles(){
		super("ShuttleVehicles");
	}
	
	public double getPayloadCapacity() {
		return payloadCapacity;
	}

	public void setPayloadCapacity(double payloadCapacity) {
		this.payloadCapacity = payloadCapacity;
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
