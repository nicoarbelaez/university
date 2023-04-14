package herencia;

public class Furgoneta extends Coche{
	private int capacidadCarga;
	private int plazasExtras;
	
	public Furgoneta(int plazasExtras, int capacidadCarga) {
		super();
		
		this.capacidadCarga = capacidadCarga;
		this.plazasExtras = plazasExtras;
	}
}
