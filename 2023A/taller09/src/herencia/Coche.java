package herencia;

public class Coche {
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	private String color;
	private int pesoTotal;
	private boolean asientosCuero, climatizador;
	
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		pesoPlataforma = 500;
	}
	
	public String dimeDatosGenerales() {
		return "La plataforma del vehículo tine " + ruedas + " ruedas " +
	". Mide " + largo / 1000 + " metros con un ancho de " + ancho +
	" cm y un peso de plataforma de " + pesoPlataforma + " kg";
	}
	
	public void estableceColor(String colorCoche) {
		color = colorCoche;
	}

	public String dimeColor() {
		return "El color del coche es " + color;
	}
	
	public void configurarAsientos(String asientosCuero) {
		if(asientosCuero.equalsIgnoreCase("Si")) {
			this.asientosCuero = true;
		}else {

			this.asientosCuero = false;
		}
	}
	
	public String dimeClimatizador() {
		if(climatizador == true) {
			return "El coche incorporado climatizador";
		}else {
			return "El coche lleva aire acondicionado";
		}
	}
	
	public String dimePesoCoche() {
		int pesoCarroceria = 500;
		pesoTotal = pesoPlataforma + pesoCarroceria;
		
		if(asientosCuero == true) {
			pesoTotal = pesoTotal + 50;
		}else {
			pesoTotal = pesoTotal + 20;
		}
		
		return "El peso del coche es " + pesoTotal;
	}
}
