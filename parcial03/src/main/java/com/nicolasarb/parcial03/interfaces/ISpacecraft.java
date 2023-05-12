package main.java.com.nicolasarb.parcial03.interfaces;

public interface ISpacecraft {
	/**
	* Calcular la velocidad de la nave espacial.
	*
	* @param time El tiempo en segundos.
	* @return La velocidad de la nave espacial en metros por segundo.
	*/
	double calculateSpeed(double time);

	/**
	* Calcular la fuerza g experimentada por la nave espacial.
	*
	* @param speed La velocidad de la nave espacial en metros por segundo.
	* @return La fuerza g experimentada por la nave espacial.
	*/
	double calculateGForce(double speed);

	/**
	* Calcula cuándo se acabará el combustible de la nave espacial.
	*
	* @param fuelCapacity La capacidad de combustible de la nave espacial en kilogramos.
	* @param fuelConsumption El consumo de combustible de la nave espacial en kilogramos
	*                        por segundo.
	* @return El tiempo en segundos para quedarse sin combustible.
	*/
	double calculateFuelRunOutTime(double fuelCapacity, double fuelConsumption);
	
	/**
	* Calcular la distancia entre dos puntos.
	*
	* @param x1 La coordenada x del primer punto (A)
	* @param y1 La coordenada y del primer punto (A)
	* @param x2 La coordenada x del primer punto (B)
	* @param y2 La coordenada y del primer punto (B)
	* @return La distancia del punto A al punto B
	*/
	double calculateDistance(float x1, float x2, float y1, float y2);

	/**
	* Calcular la velocidad máxima de la nave en base a su masa y aceleración.
	*
	* @param aceleración La aceleración de la nave
	* @param mass La masa del barco
	* @return La velocidad máxima de la nave
	*/
	double computeMaxSpeed(double acceleration, double mass);

	/**
	* Calcular el periodo orbital de un objeto que orbita alrededor de un cuerpo central. (Cuánto tiempo se tarda en dar la vuelta)
	*
	* @param semimajorAxis La distancia entre el objeto y el centro del cuerpo central.
	* @param massOfCentralBody La masa del cuerpo central.
	* @return El período orbital del objeto, en segundos.
	*/
	double computeOrbitalPeriod(double semimajorAxis, double massOfCentralBody);

}
