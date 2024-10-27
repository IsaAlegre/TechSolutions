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


    public void agregarTarea(Task tarea) {
        tareas.add(tarea);
        System.out.println("Tarea agregada al proyecto: " + tarea.getDescripcion());
    }

    // Método para listar tareas
    public List<Task> getTareas() {
        return tareas;
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

    // Método para listar todos los proyectos
    public static void listarProyectos() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
        } else {
            for (Proyecto proyecto : proyectos) {
                System.out.println(proyecto);
            }}}

}
