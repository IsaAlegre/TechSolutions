package adapter;

import Persona.cliente.Cliente;
import Persona.employee.Empleado;
import model.Task;

import java.util.Date;
import java.util.List;

public class ProjectInfo {
    private String projectName;
    private String manager;
    private List<Task> tasks;
    private Cliente cliente;
    private Empleado empleado;
    private String descripcion;
    private String id;
    private Date fechaDeInicio;

    public ProjectInfo(String projectName, String manager, List<Task> tasks, Cliente cliente, Empleado empleado, String descripcion, String id, Date fechaDeInicio) {
        this.projectName = projectName;
        this.manager = manager;
        this.tasks = tasks;
        this.cliente = cliente;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
    }

    // Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getManager() {
        return manager;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String imprimirDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del Proyecto: ").append(projectName).append("\n")
                .append("Descripción: ").append(descripcion).append("\n")
                .append("ID: ").append(id).append("\n")
                .append("Fecha de Inicio: ").append(fechaDeInicio).append("\n");

        // Detalles del cliente
        String clientDetails = cliente != null ?
                "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + ", DNI: " + cliente.getDni() + ", Dirección: " + cliente.getDireccion()
                : "Sin cliente";
        sb.append(clientDetails).append("\n");

        // Detalles del empleado
        String empleadoDetails = empleado != null ?
                "Empleado: ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre() + ", DNI: " + empleado.getDni() + ", Fecha de Nacimiento: " + empleado.getFechaNacimiento()
                : "Sin empleado";
        sb.append(empleadoDetails).append("\n");

        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                sb.append("Tarea: ").append(task.getTaskName()).append(", ")
                        .append("estado: ").append(task.getDescripcion()).append(", ")
                        .append("descripcion: ").append(task.getStatus()).append("\n");
            }
        } else {
            sb.append("No hay tareas asignadas.\n");
        }

        return sb.toString();
    }
}
