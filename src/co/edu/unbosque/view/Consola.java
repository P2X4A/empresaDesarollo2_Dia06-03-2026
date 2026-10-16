package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {

    private Scanner consola = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("""
                Elija una opcion a realizar
                1. Crear Trabajador (Contratista, Tiempo Completo, Empleado Ventas) Con Departamento
                2. Actualizar La Informacion De Un Trabajador (Contratista, Tiempo Completo, Empleado De Ventas)
                3. Generar Reporte Para La Distribucion De Trabajadores Por Area (Contratista, Tiempo Completo, Empleado De Ventas)
                4. Generar Reporte Para La Distribucion De Trabajadores Por Departamento (A,B,C)
                0. Salir Del Programa
                """);
        return consola.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int pedirOpcionTipo() {
        mostrarMensaje("1. Contratista\n2. Tiempo Completo\n3. Empleado Ventas");
        mostrarMensaje("Elija tipo (1-3): ");
        return consola.nextInt();
    }

    public String pedirNombre() {
        mostrarMensaje("Ingrese el nombre del trabajador: ");
        // Limpiar buffer si hay enter pendiente
        consola.nextLine();
        return consola.nextLine().trim();
    }

    public char pedirDepartamentoTrabajador() {
        mostrarMensaje("Ingrese el departamento (A, B o C): ");
        String input = consola.next().trim().toUpperCase();
        return input.length() > 0 ? input.charAt(0) : 'A';
    }

    public int pedirCedulaTrabajador() {
        mostrarMensaje("Ingrese la cédula del trabajador: ");
        return consola.nextInt();
    }

    public int pedirSalarioTrabajdor() {
        mostrarMensaje("Ingrese el salario del trabajador: ");
        return consola.nextInt();
    }

    public String pedirCargoTrabajador() {
        mostrarMensaje("Ingrese el cargo del trabajador: ");
        // Limpiar buffer
        consola.nextLine();
        return consola.nextLine().trim();
    }

    // Método adicional para confirmar operaciones
    public boolean confirmarOperacion() {
        mostrarMensaje("¿Confirmar? (s/n): ");
        String respuesta = consola.next().trim().toLowerCase();
        return respuesta.startsWith("s");
    }

    // Para limpiar buffer si es necesario
    public void limpiarBuffer() {
        consola.nextLine();
    }
}
