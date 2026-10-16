package co.edu.unbosque.model;

public class TrabajadorTiempoCompleto extends Trabajador {
	private String cargoTrabajador;

	public TrabajadorTiempoCompleto(String nombreTrabajador, char departamentoTrabajador, int cedulaTrabajador,
			int salarioTrabajador, String cargoTrabajador) {
		super(nombreTrabajador, departamentoTrabajador, cedulaTrabajador, salarioTrabajador);
		this.cargoTrabajador = cargoTrabajador;
	}

	public String getCargoTrabajador() {
		return cargoTrabajador;
	}

	public void setCargoTrabajador(String cargoTrabajador) {
		this.cargoTrabajador = cargoTrabajador;
	}

}
