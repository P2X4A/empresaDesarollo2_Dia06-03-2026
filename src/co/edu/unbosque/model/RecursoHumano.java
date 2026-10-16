package co.edu.unbosque.model;

import co.edu.unbosque.interfaces.IEmpleado;
import java.util.*;

public class RecursoHumano<T extends Trabajador> implements IEmpleado<T> {

	private Map<Character, List<T>> trabajadoresPorDepto;
	private Map<Character, List<TrabajadorContratista>> contratistasPorDepto;
	private Map<Character, List<TrabajadorDeVentas>> ventasPorDepto;
	private Map<Character, List<TrabajadorTiempoCompleto>> tiempoCompletoPorDepto;

	public RecursoHumano() {
		trabajadoresPorDepto = new HashMap<>();
		contratistasPorDepto = new HashMap<>();
		ventasPorDepto = new HashMap<>();
		tiempoCompletoPorDepto = new HashMap<>();
		inicializarDepartamentos();
	}

	private void inicializarDepartamentos() {
		char[] deptos = { 'A', 'B', 'C' };
		for (char depto : deptos) {
			trabajadoresPorDepto.put(depto, new ArrayList<>());
			contratistasPorDepto.put(depto, new ArrayList<>());
			ventasPorDepto.put(depto, new ArrayList<>());
			tiempoCompletoPorDepto.put(depto, new ArrayList<>());
		}
	}

	@Override
	public boolean guardar(T trabajador) {
		if (trabajador == null || !esDeptoValido(trabajador.getDepartamentoTrabajador())) {
			return false;
		}

		char depto = trabajador.getDepartamentoTrabajador();
		trabajadoresPorDepto.get(depto).add(trabajador);

		if (trabajador instanceof TrabajadorContratista) {
			contratistasPorDepto.get(depto).add((TrabajadorContratista) trabajador);
		} else if (trabajador instanceof TrabajadorDeVentas) {
			ventasPorDepto.get(depto).add((TrabajadorDeVentas) trabajador);
		} else if (trabajador instanceof TrabajadorTiempoCompleto) {
			tiempoCompletoPorDepto.get(depto).add((TrabajadorTiempoCompleto) trabajador);
		}

		return true;
	}

	@Override
	public T leer(T claveTrabajador) {
		if (claveTrabajador == null) {
			return null;
		}
		// Busca por cédula en todas las listas por departamento
		int cedulaBuscada = claveTrabajador.getCedulaTrabajador();
		for (List<T> lista : trabajadoresPorDepto.values()) {
			for (T t : lista) {
				if (t.getCedulaTrabajador() == cedulaBuscada) {
					return t;
				}
			}
		}
		return null;
	}

	@Override
	public void actualizar(T trabajadorActualizado) {
		if (trabajadorActualizado == null) {
			return;
		}

		T existente = leer(trabajadorActualizado);
		if (existente != null) {
			char depto = trabajadorActualizado.getDepartamentoTrabajador();
			int index = trabajadoresPorDepto.get(depto).indexOf(existente);

			if (index != -1) {
				// Reemplaza en lista general
				trabajadoresPorDepto.get(depto).set(index, trabajadorActualizado);

				// Actualiza también en lista específica por tipo
				actualizarEnListaEspecifica(depto, existente, trabajadorActualizado);
			}
		}
	}

	private void actualizarEnListaEspecifica(char depto, T viejo, T nuevo) {
		if (viejo instanceof TrabajadorContratista) {
			int idx = contratistasPorDepto.get(depto).indexOf((TrabajadorContratista) viejo);
			if (idx != -1) {
				contratistasPorDepto.get(depto).set(idx, (TrabajadorContratista) nuevo);
			}
		} else if (viejo instanceof TrabajadorDeVentas) {
			int idx = ventasPorDepto.get(depto).indexOf((TrabajadorDeVentas) viejo);
			if (idx != -1) {
				ventasPorDepto.get(depto).set(idx, (TrabajadorDeVentas) nuevo);
			}
		} else if (viejo instanceof TrabajadorTiempoCompleto) {
			int idx = tiempoCompletoPorDepto.get(depto).indexOf((TrabajadorTiempoCompleto) viejo);
			if (idx != -1) {
				tiempoCompletoPorDepto.get(depto).set(idx, (TrabajadorTiempoCompleto) nuevo);
			}
		}
	}

	private boolean esDeptoValido(char depto) {
		return depto == 'A' || depto == 'B' || depto == 'C';
	}

	// Getters para reportes en controlador
	public Map<Character, List<T>> getTrabajadoresPorDepto() {
		return trabajadoresPorDepto;
	}

	public Map<Character, List<TrabajadorContratista>> getContratistasPorDepto() {
		return contratistasPorDepto;
	}

	public Map<Character, List<TrabajadorDeVentas>> getVentasPorDepto() {
		return ventasPorDepto;
	}

	public Map<Character, List<TrabajadorTiempoCompleto>> getTiempoCompletoPorDepto() {
		return tiempoCompletoPorDepto;
	}
}
