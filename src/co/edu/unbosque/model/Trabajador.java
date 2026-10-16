package co.edu.unbosque.model;

public class Trabajador {
	protected String nombreTrabajador;
	protected char departamentoTrabajador;
	protected int cedulaTrabajador;
	protected int salarioTrabajador;
	
	public Trabajador(String nombreTrabajador, char departamentoTrabajador, int cedulaTrabajador,
			int salarioTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
		this.departamentoTrabajador = departamentoTrabajador;
		this.cedulaTrabajador = cedulaTrabajador;
		this.salarioTrabajador = salarioTrabajador;
	}

	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	public char getDepartamentoTrabajador() {
		return departamentoTrabajador;
	}

	public void setDepartamentoTrabajador(char departamentoTrabajador) {
		this.departamentoTrabajador = departamentoTrabajador;
	}

	public int getCedulaTrabajador() {
		return cedulaTrabajador;
	}

	public void setCedulaTrabajador(int cedulaTrabajador) {
		this.cedulaTrabajador = cedulaTrabajador;
	}

	public int getSalarioTrabajador() {
		return salarioTrabajador;
	}

	public void setSalarioTrabajador(int salarioTrabajador) {
		this.salarioTrabajador = salarioTrabajador;
	}
	
	

	
}
