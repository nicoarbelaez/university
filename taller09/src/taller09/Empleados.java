package taller09;

public class Empleados {
	private String name;
	private String section = "Administración";
	private int id;
	private static int idNext = 1;
	
	public Empleados(String name) {
		setName(name);
		id = idNext;
		idNext++;
	}
	
	public String devuelveDatos() {
		return "El nombre es: " + getName() + " la sección es: " + getSection() + " y el ID: " + getId();
	}
	
	public static String dameIdSiguiente() {
		return "El siguiente ID es: " + getIdNext();
	}
	
	public void cambiarSeccionn(String section) {
		setSection(section);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIdNext() {
		return idNext;
	}

	public static void setIdNext(int idNext) {
		Empleados.idNext = idNext;
	}
	
	
}
