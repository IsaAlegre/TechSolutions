
package Main;
import Factory.*;
import Manager.GestorProyectosEmpleados;
import Persona.GerenteProyecto;
import Persona.cliente.Cliente;
import Persona.employee.EmpleadoBase;
import Project.Proyecto;
import adapter.OldDatabase;
import adapter.ProjectAdapter;
import adapter.ProjectInfo;
import model.Task;
import strategy.RoleAndLeastTasksStrategy;
import strategy.TaskAssignmentContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Scanner;

import static Project.Proyecto.listarProyectos;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GestorProyectosEmpleados pm = GestorProyectosEmpleados.getInstance();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        // Simulamos la base de datos vieja
        OldDatabase oldDatabase = new OldDatabase();

        // Adaptador para transformar los datos viejos
        ProjectAdapter projectAdapter = new ProjectAdapter(oldDatabase);

        // Obtener la información del proyecto desde la base de datos vieja
        ProjectInfo projectInfo = projectAdapter.getProjectInfo();

        // Verificar si se ha cargado correctamente
        if (projectInfo != null) {
            // Crear cliente y empleado si no existen y agregar automáticamente a las listas estáticas
            Cliente cliente = projectInfo.getCliente();
            EmpleadoBase empleado = projectInfo.getEmpleado();

            // Crear un nuevo proyecto basado en la información extraída y agregarlo a la lista estática de proyectos
            Proyecto newProject = new Proyecto(
                    projectInfo.getProjectName(),
                    projectInfo.getDescripcion(),
                    projectInfo.getId(),
                    projectInfo.getFechaDeInicio(),
                    cliente,
                    projectInfo.getTasks()
            );

            // Imprimir los detalles del proyecto
            System.out.println(projectInfo.imprimirDetalles());
        }
        boolean exit = false;

        while (!exit) {
            mostrarMenu();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarCliente();
                    break;
                case "2":
                    listarClientes();
                    break;
                case "3":
                    modificarCliente();
                    break;
                case "4":
                    borrarCliente();
                    break;
                case "5":
                    agregarEmpleado();
                    break;
                case "6":
                    listarEmpleados();
                    break;
                case "7":
                    modificarEmpleado();
                    break;
                case "8":
                    borrarEmpleado();
                    break;
                case "9":
                    crearProyecto();
                    break;
                case "10":
                    listarProyectos();
                    break;
                case "11":
                    asignarEmpleadoAProyecto();
                    break;
                case "12":
                    asignarTareaAProyecto(); // Manejo de la nueva opción
                    break;
                case "0":
                    exit = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }

            System.out.println(); // Línea en blanco para mejor legibilidad
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== Sistema de Gestión de Proyectos - Tech Solutions =====");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Modificar Cliente");
        System.out.println("4. Borrar Cliente");
        System.out.println("5. Agregar Empleado");
        System.out.println("6. Listar Empleados");
        System.out.println("7. Modificar Empleado");
        System.out.println("8. Borrar Empleado");
        System.out.println("9. Crear Project");
        System.out.println("10. Listar Proyectos");
        System.out.println("11. Asignar Empleado a Projecto");
        System.out.println("12. Asignar Tarea a Proyecto");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void agregarCliente() {
        System.out.println("===== Agregar Cliente =====");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("ID (CLXXX): ");
        String id = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, dni, id, fechaNacimiento, direccion);
        clientes.add(cliente);
        System.out.println("Cliente agregado: " + cliente);
    }

    private static void listarClientes() {
        System.out.println("===== Lista de Clientes =====");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void modificarCliente() {
        System.out.println("===== Modificar Cliente =====");
        System.out.print("Ingrese el ID del cliente a modificar: ");
        String id = scanner.nextLine();

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            System.out.print("Nuevo Nombre (actual: " + cliente.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) nombre = cliente.getNombre();

            System.out.print("Nuevo Apellido (actual: " + cliente.getApellido() + "): ");
            String apellido = scanner.nextLine();
            if (apellido.isEmpty()) apellido = cliente.getApellido();

            System.out.print("Nuevo DNI (actual: " + cliente.getDni() + "): ");
            String dni = scanner.nextLine();
            if (dni.isEmpty()) dni = cliente.getDni();

            System.out.print("Nueva Dirección (actual: " + cliente.getDireccion() + "): ");
            String direccion = scanner.nextLine();
            if (direccion.isEmpty()) direccion = cliente.getDireccion();

            System.out.print("Nueva Fecha de Nacimiento (actual: " + cliente.getFechaNacimiento() + "): ");
            String fechaNacimiento = scanner.nextLine();
            if (fechaNacimiento.isEmpty()) fechaNacimiento = cliente.getFechaNacimiento();

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDni(dni);
            cliente.setDireccion(direccion);
            cliente.setFechaNacimiento(fechaNacimiento);
            System.out.println("Cliente modificado: " + cliente);
        } else {
            System.out.println("Cliente con ID " + id + " no encontrado.");
        }
    }

    private static void borrarCliente() {
        System.out.println("===== Borrar Cliente =====");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = scanner.nextLine();
        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado: " + cliente);
        } else {
            System.out.println("Cliente con ID " + id + " no encontrado.");
        }
    }

    private static Cliente encontrarClientePorId(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Métodos para gestionar Empleados
    private static void agregarEmpleado() {
        System.out.println("===== Agregar Empleado =====");
        System.out.println("Seleccione el rol del empleado:");
        System.out.println("1. Desarrollador");
        System.out.println("2. Tester");
        System.out.println("3. Diseñador");
        System.out.print("Opción: ");
        String opcion = scanner.nextLine();

        String rol = "";
        EmployeeFactory factory = null;

        switch (opcion) {
            case "1":
                rol = "Desarrollador";
                factory = new DesarrolladorFactory();
                break;
            case "2":
                rol = "Tester";
                factory = new TesterFactory();
                break;
            case "3":
                rol = "Diseñador";
                factory = new DIseñadorFactory();
                break;
            default:
                System.out.println("Opción inválida. Empleado no agregado.");
                return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("ID (DEVXXX, TESXXX, GERXXX): ");
        String id = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (dd/MM/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

        EmpleadoBase empleado = factory.crearEmpleado(nombre, apellido, dni, id, fechaNacimiento);
        pm.agregarEmpleado(empleado);
    }

    private static void listarEmpleados() {
        pm.listarEmpleados();
    }

    private static void modificarEmpleado() {
        System.out.println("===== Modificar Empleado =====");
        System.out.print("Ingrese el ID del empleado a modificar: ");
        String id = scanner.nextLine();

        EmpleadoBase empleado = pm.encontrarEmpleadoPorId(id);
        if (empleado != null) {
            System.out.print("Nuevo Nombre (actual: " + empleado.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) nombre = empleado.getNombre();

            System.out.print("Nuevo Apellido (actual: " + empleado.getApellido() + "): ");
            String apellido = scanner.nextLine();
            if (apellido.isEmpty()) apellido = empleado.getApellido();

            System.out.print("Nuevo DNI (actual: " + empleado.getDni() + "): ");
            String dni = scanner.nextLine();
            if (dni.isEmpty()) dni = empleado.getDni();

            System.out.print("Nueva Fecha de Nacimiento (actual: " + empleado.getFechaNacimiento() + "): ");
            String fechaNacimiento = scanner.nextLine();
            if (fechaNacimiento.isEmpty()) fechaNacimiento = empleado.getFechaNacimiento();

            pm.modificarEmpleado(id, nombre, apellido, dni, fechaNacimiento);
        } else {
            System.out.println("Empleado con ID " + id + " no encontrado.");
        }
    }

    private static void borrarEmpleado() {
        System.out.println("===== Borrar Empleado =====");
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        String id = scanner.nextLine();
        pm.borrarEmpleado(id);
    }

    // Métodos para gestionar Proyectos
    private static void crearProyecto() {
        System.out.println("===== Crear Proyecto =====");
        System.out.print("Nombre del Proyecto: ");
        String nombreProyecto = scanner.nextLine();

        System.out.print("Descripción del Proyecto: ");
        String descripcionProyecto = scanner.nextLine();

        String idProyecto = "PR" + System.currentTimeMillis();

        System.out.print("ID del Cliente (CLXXX): ");
        String idCliente = scanner.nextLine();

        Cliente cliente = encontrarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente con ID " + idCliente + " no encontrado. Proyecto no creado.");
            return;
        }

        Date fechaDeInicio = new Date();

        // Crear una lista vacía de tareas para el proyecto
        List<Task> tareas = new ArrayList<>();

        System.out.println("===== Datos del Gerente del Proyecto =====");
        System.out.print("Nombre del Gerente: ");
        String nombreGerente = scanner.nextLine();
        System.out.print("Apellido del Gerente: ");
        String apellidoGerente = scanner.nextLine();
        System.out.print("DNI del Gerente: ");
        String dniGerente = scanner.nextLine();
        String idGerente = "GER" + System.currentTimeMillis();
        System.out.print("Fecha de Nacimiento del Gerente (dd/MM/yyyy): ");
        String fechaNacimientoGerente = scanner.nextLine();

        // Crear el gerente con los datos ingresados
        GerenteProyecto gerente = new GerenteProyecto(nombreGerente, apellidoGerente, dniGerente, idGerente, fechaNacimientoGerente);
        System.out.println("Gerente asignado al proyecto: " + gerente.getNombre() + " " + gerente.getApellido());

        // Crear el proyecto con el cliente y las tareas
        Proyecto proyecto = new Proyecto(nombreProyecto, descripcionProyecto, idProyecto, fechaDeInicio, cliente, tareas);
        proyecto.asignarGerente(gerente);  // Asigna el gerente al proyecto (asumiendo que este método existe en Proyecto)
        pm.agregarProyecto(proyecto);

        System.out.println("Proyecto creado exitosamente: " + proyecto);
    }

    private static void asignarEmpleadoAProyecto() {
        System.out.println("===== Asignar Empleado a Project =====");
        System.out.print("Nombre del Project: ");
        String nombreProyecto = scanner.nextLine();
        Proyecto proyecto = pm.encontrarProyectoPorNombre(nombreProyecto);
        if (proyecto == null) {
            System.out.println("Project.Proyecto con nombre " + nombreProyecto + " no encontrado.");
            return;
        }

        System.out.print("ID del Empleado a asignar: ");
        String idEmpleado = scanner.nextLine();
        EmpleadoBase empleado = pm.encontrarEmpleadoPorId(idEmpleado);
        if (empleado == null) {
            System.out.println("Empleado con ID " + idEmpleado + " no encontrado.");
            return;
        }

        proyecto.asignarEmpleado(empleado);


    }

    private static void asignarTareaAProyecto() {
        System.out.println("===== Asignar Tarea a Project =====");
        System.out.print("Nombre del Project: ");
        String nombreProyecto = scanner.nextLine();
        Proyecto proyecto = pm.encontrarProyectoPorNombre(nombreProyecto);

        if (proyecto == null) {
            System.out.println("Project con nombre " + nombreProyecto + " no encontrado.");
            return;
        }

        System.out.print("Descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        Task tarea = new Task("Nueva Tarea", descripcion, "PENDIENTE");  // Crea una nueva tarea

        proyecto.agregarTarea(tarea); // Agrega la tarea al proyecto

        System.out.println("Seleccione el rol para asignar la tarea:");
        System.out.println("1. Desarrollador");
        System.out.println("2. Tester");
        System.out.println("3. Diseñador");
        String opcion = scanner.nextLine();

        String rol = "";
        switch (opcion) {
            case "1":
                rol = "Desarrollador";
                break;
            case "2":
                rol = "Tester";
                break;
            case "3":
                rol = "Diseñador";
                break;
            default:
                System.out.println("Opción inválida. Tarea no asignada.");
                return;
        }

        // Creamos el contexto de asignación de tareas
        TaskAssignmentContext context = new TaskAssignmentContext(new RoleAndLeastTasksStrategy(rol));

        // Obtener la lista de empleados del gestor
        List<EmpleadoBase> empleados = pm.getEmpleados(); // Asegúrate de que este método existe en tu gestor

        // Asignar la tarea utilizando la estrategia
        EmpleadoBase empleadoAsignado = context.assignTask(tarea, empleados); // Asignamos la tarea usando Strategy

        if (empleadoAsignado != null) {
            System.out.println("Tarea asignada a empleado: " + empleadoAsignado.getNombre() + " " + empleadoAsignado.getApellido());

            // **Aca está la parte del patrón Observer**
            // Agregar el empleado como observador de la tarea
            tarea.añadirObservador(empleadoAsignado);
            System.out.println(empleadoAsignado.getNombre() + " ha sido agregado como observador de la tarea.");

            // Cambiar el estado de la tarea para disparar la notificación
            System.out.println("Cambiando el estado de la tarea...");
            tarea.setStatus("COMPLETADO");  // Cambiamos el estado de la tarea para probar la notificación
        } else {
            System.out.println("No se pudo asignar la tarea, no hay empleados disponibles para el rol " + rol);
        }
    }
}


