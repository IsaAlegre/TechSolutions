package Persona.employee;

import Persona.Persona;
import model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Empleado.java
public abstract class EmpleadoBase implements Empleado {
    private String nombre;
    private String apellido;
    private String dni;
    private String id;
    private String fechaNacimiento;
    private String herramienta;
    private List<Task> assignedTasks;

    public EmpleadoBase(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.assignedTasks = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getHerramienta() {
        return herramienta;
    }

    @Override
    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public void performTask(Task task) {
        assignedTasks.add(task); // Agrega la tarea a la lista de tareas asignadas
    }

    public int getAssignedTasksCount() {
        return assignedTasks.size(); // Devuelve la cantidad de tareas asignadas
    }


    @Override
    public String toString() {
        return getRol() + " - ID: " + id + ", Nombre: " + nombre + " " + apellido + ", Herramienta: " + herramienta;
    }
}

