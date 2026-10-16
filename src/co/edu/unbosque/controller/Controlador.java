package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.Consola;

public class Controlador {
    private RecursoHumano<Trabajador> recursoHumano;
    private Consola consola;

    public void ejecutar() {
        recursoHumano = new RecursoHumano<>();
        consola = new Consola();

        int opcion;
        do {
            opcion = consola.mostrarMenu();

            switch (opcion) {
                case 1 -> crearTrabajador();
                case 2 -> actualizarTrabajador();
                case 3 -> generarReportePorTipo();
                case 4 -> generarReportePorDepto();
                case 0 -> consola.mostrarMensaje("Saliendo del programa...");
                default -> consola.mostrarMensaje("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void crearTrabajador() {
        consola.mostrarMensaje("=== CREAR TRABAJADOR ===");
        consola.mostrarMensaje("1. Contratista\n2. Tiempo Completo\n3. Ventas");
        
        int tipo = consola.pedirOpcionTipo();  
        
        String nombre = consola.pedirNombre();
        char depto = consola.pedirDepartamentoTrabajador();
        int cedula = consola.pedirCedulaTrabajador();
        int salario = consola.pedirSalarioTrabajdor();
        String cargo = consola.pedirCargoTrabajador();

        Trabajador nuevoTrabajador = null;
        switch (tipo) {
            case 1 -> nuevoTrabajador = new TrabajadorContratista(nombre, depto, cedula, salario, cargo);
            case 2 -> nuevoTrabajador = new TrabajadorTiempoCompleto(nombre, depto, cedula, salario, cargo);
            case 3 -> nuevoTrabajador = new TrabajadorDeVentas(nombre, depto, cedula, salario, cargo);
            default -> {
                consola.mostrarMensaje("Tipo inválido.");
                return;
            }
        }

        if (recursoHumano.guardar(nuevoTrabajador)) {
            consola.mostrarMensaje("Trabajador guardado exitosamente.");
        } else {
            consola.mostrarMensaje("Error: Departamento inválido (use A, B o C).");
        }
    }

    private void actualizarTrabajador() {
        consola.mostrarMensaje("=== ACTUALIZAR TRABAJADOR ===");
        int cedulaBuscar = consola.pedirCedulaTrabajador();
        
        Trabajador clave = new Trabajador("", 'A', cedulaBuscar, 0);  // Solo para búsqueda por cédula
        Trabajador encontrado = recursoHumano.leer(clave);
        
        if (encontrado != null) {
            consola.mostrarMensaje("Encontrado: " + encontrado.getNombreTrabajador() + 
                                 " - Depto: " + encontrado.getDepartamentoTrabajador());
            
            // Pedir nuevos datos
            String nuevoNombre = consola.pedirNombre();
            char nuevoDepto = consola.pedirDepartamentoTrabajador();
            int nuevoSalario = consola.pedirSalarioTrabajdor();
            String nuevoCargo = consola.pedirCargoTrabajador();
            
            // Crear trabajador actualizado (mismo tipo)
            Trabajador actualizado = null;
            if (encontrado instanceof TrabajadorContratista) {
                actualizado = new TrabajadorContratista(nuevoNombre, nuevoDepto, cedulaBuscar, nuevoSalario, nuevoCargo);
            } else if (encontrado instanceof TrabajadorDeVentas) {
                actualizado = new TrabajadorDeVentas(nuevoNombre, nuevoDepto, cedulaBuscar, nuevoSalario, nuevoCargo);
            } else if (encontrado instanceof TrabajadorTiempoCompleto) {
                actualizado = new TrabajadorTiempoCompleto(nuevoNombre, nuevoDepto, cedulaBuscar, nuevoSalario, nuevoCargo);
            }
            
            recursoHumano.actualizar(actualizado);
            consola.mostrarMensaje("Trabajador actualizado exitosamente.");
        } else {
            consola.mostrarMensaje("Trabajador no encontrado.");
        }
    }

    private void generarReportePorTipo() {
        consola.mostrarMensaje("=== REPORTE POR TIPO ===");
        var contratistas = recursoHumano.getContratistasPorDepto();
        var ventas = recursoHumano.getVentasPorDepto();
        var tiempoCompleto = recursoHumano.getTiempoCompletoPorDepto();
        
        for (char depto : new char[]{'A', 'B', 'C'}) {
            consola.mostrarMensaje("Depto " + depto + ":");
            consola.mostrarMensaje("  Contratistas: " + contratistas.get(depto).size());
            consola.mostrarMensaje("  Ventas: " + ventas.get(depto).size());
            consola.mostrarMensaje("  Tiempo Completo: " + tiempoCompleto.get(depto).size());
        }
    }

    private void generarReportePorDepto() {
        consola.mostrarMensaje("=== REPORTE POR DEPARTAMENTO ===");
        var todos = recursoHumano.getTrabajadoresPorDepto();
        for (char depto : new char[]{'A', 'B', 'C'}) {
            int total = todos.get(depto).size();
            consola.mostrarMensaje("Depto " + depto + ": " + total + " trabajadores");
        }
    }
}
