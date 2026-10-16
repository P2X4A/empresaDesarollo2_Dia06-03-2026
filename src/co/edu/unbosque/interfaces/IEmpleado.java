package co.edu.unbosque.interfaces;

public interface IEmpleado <I> {
	//CRUD de toda la vida
	boolean guardar(I guardarTrabajador);
	I leer(I leerTrabajador);
	void actualizar(I leerTrabajador);

}
