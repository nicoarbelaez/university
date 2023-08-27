package pointTwo;

import java.util.Random;

public class Persona {
	private String nombre = "";
	private int edad = 0;
	private String dni = "";
	private char sexo;
	// private final char sexo;
	// Peso en Kg
	private double peso = 0.0f;
	// Altura en M
	private double altura = 0.0f;

	public Persona() {

		generaDNI();
	}

	public Persona(String nombre, int edad, char sexo) {
		setNombre(nombre);
		setEdad(edad);
		setSexo(sexo);
		generaDNI();
	}

	public Persona(String nombre, int edad, char sexo, double peso, double altura) {
		setNombre(nombre);
		setEdad(edad);
		setSexo(sexo);
		setPeso(peso);
		setAltura(altura);
		generaDNI();
	}

	public byte calcularIMC() {
		final byte sobrpeso = 1;
		final byte delgado = 0;
		final byte normal = -1;

		double pesoIdeal = getPeso() / (Math.pow(getAltura(), 2));
		if (pesoIdeal < 20) {
			return normal;
		} else if (pesoIdeal >= 20 && pesoIdeal <= 25) {
			return delgado;
		}

		// Suponemos que no paso ningun condicional
		// if(pesoIdeal > 25)
		return sobrpeso;
	}

	public boolean esMayorDeEdad() {
		return getEdad() >= 18;
	}

	private char comprobarSexo(char sexo) {
		// Transformamos el char en Strgin para usar equals
		String sexoStr = sexo + "";
		if (sexoStr.equalsIgnoreCase("H") || sexoStr.equalsIgnoreCase("M")) {
			return sexo;
		}

		return 'H';
	}

	public String toString() {
		return "Nombre: " + getNombre() + "\nEdad: " + getEdad() + "\nDNI: " + getDNI() + "\nSexo: " + getSexo() + "\nPeso: "
				+ getPeso() + "\nAltura: " + getAltura();
	}

	private void generaDNI() {
		Random random = new Random();
		String dni = "";
		for (int i = 0; i < 8; i++) {
			dni += random.nextInt(9);
		}
		System.out.println();
		
		this.dni = dni;

	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return dni;
	}

	// public void setDNI(int dNI) {
	// dni = dNI;
	// }

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {

		this.sexo = comprobarSexo(sexo);
	}

}
