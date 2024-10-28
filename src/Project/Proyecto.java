package Project;// src/com/techsolutions/project/Project.Proyecto.java

import Persona.GerenteProyecto;
import Persona.cliente.Cliente;
import Persona.employee.EmpleadoBase;
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
        return "Proyecto:\n" +
                "  Nombre: " + nombre + "\n" +
                "  Descripción: " + descripcion + "\n" +
                "  ID: " + id + "\n" +
                "  Fecha de Inicio: " + fechaDeInicio + "\n" +
                "  Cliente: " + cliente + "\n" +
                "  Gerente: " + (gerente != null ? gerente.getNombre() + " " + gerente.getApellido() : "Sin asignar") + "\n" +
                "  Tareas: " + tareas.size() + " tareas\n";
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


    public void asignarGerente(GerenteProyecto gerente) {
        this.gerente = gerente;
    }

    // Método para obtener el gerente del proyecto (si necesitas consultarlo después)
    public GerenteProyecto getGerente() {
        return gerente;
    }

}
