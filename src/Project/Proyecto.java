package Project;// src/com/techsolutions/project/Project.Proyecto.java

import Persona.cliente.Cliente;
import Persona.employee.EmpleadoBase;
import Persona.employee.GerenteProyecto;
import model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private String id;
    private Date fechaDeInicio;
    private Cliente cliente;
    private GerenteProyecto gerente;
    private List<EmpleadoBase> empleados;
    private List<Task> tareas;
    public static List<Proyecto> proyectos = new ArrayList<>();
    public Proyecto(String nombre, String descripcion, String id, Date fechaDeInicio, Cliente cliente, List<Task> tasks) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
        this.cliente = cliente;
        this.empleados = new ArrayList<>();
        this.tareas = new ArrayList<>();
        proyectos.add(this);

    }


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public GerenteProyecto getGerente() {
        return gerente;
    }

    public void setGerente(GerenteProyecto gerente) {
        this.gerente = gerente;
    }

    public List<EmpleadoBase> getEmpleados() {
        return empleados;
    }

    public void agregarTarea(Task tarea) {
        this.tareas.add(tarea);
        System.out.println("Tarea agregada al proyecto: " + tarea.getDescripcion());
    }



    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", id='" + id + '\'' +
                ", fechaDeInicio=" + fechaDeInicio +
                ", cliente=" + cliente +
                ", tareas=" + tareas.size() + " tareas" +
                '}';
    }

    public void asignarEmpleado(EmpleadoBase empleado) {
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " " + empleado.getApellido() + " asignado al proyecto " + nombre);
        } else {
            System.out.println("El empleado ya está asignado al proyecto.");
        }
    }

    public void borrarEmpleado(String idEmpleado) {
        EmpleadoBase empleado = empleados.stream().filter(e -> e.getId().equals(idEmpleado)).findFirst().orElse(null);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " " + empleado.getApellido() + " eliminado del proyecto " + nombre);
        } else {
            System.out.println("Empleado con ID " + idEmpleado + " no encontrado en el proyecto.");
        }
    }

    // Método para encontrar una tarea por su nombre
    public Task buscarTareaPorDescripcion(String descripcion) {
        for (Task tarea : this.tareas) {
            if (tarea.getDescripcion().equalsIgnoreCase(descripcion)) { // Compara la descripción
                return tarea; // Devuelve la tarea si encuentra una coincidencia
            }
        }
        return null; // Devuelve null si no encuentra ninguna tarea
    }

    public void resumenEstadoTareas() {
        int tareasPendientes = 0;
        int tareasEnCurso = 0;
        int tareasFinalizadas = 0;

        for (Task tarea : tareas) {
            switch (tarea.getStatus()) {
                case "PENDIENTE":
                    tareasPendientes++;
                    break;
                case "EN CURSO":
                    tareasEnCurso++;
                    break;
                case "FINALIZADA":
                    tareasFinalizadas++;
                    break;
            }
        }

        System.out.println("Estado del Proyecto: " + nombre);
        System.out.println("Tareas Pendientes: " + tareasPendientes);
        System.out.println("Tareas en Curso: " + tareasEnCurso);
        System.out.println("Tareas Finalizadas: " + tareasFinalizadas);
    }



    // Método para listar todos los proyectos
    public static void listarProyectos() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
        } else {
            for (Proyecto proyecto : proyectos) {
                System.out.println(proyecto);
            }}}

}
