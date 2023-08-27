package taller09;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado {
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;

		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		altaContrato = calendario.getTime();
	}
	
	public Empleado(String nom) {
		this(nom, 30000, 2000, 01, 01);
	}
	
	public String dameNombre() {
		return nombre;
	}
	
	public double dameSueldo() {
		return sueldo;
	}
	
	public Date dameFechaContrato() {
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}
}
