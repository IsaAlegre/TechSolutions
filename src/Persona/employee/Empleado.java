package Persona.employee;

import Persona.Persona;
import model.Task;

import java.util.ArrayList;
import java.util.List;

// Empleado.java
public abstract class Empleado extends Persona {
    private String herramienta;
    private List<Task> assignedTasks;
    public Empleado(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        super(nombre, apellido, dni, id, fechaNacimiento);
        this.assignedTasks = new ArrayList<>();
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public abstract String getRol();

    public void performTask(Task task) {
        assignedTasks.add(task); // Agrega la tarea a la lista de tareas asignadas
    }

    public int getAssignedTasksCount() {
        return assignedTasks.size(); // Devuelve la cantidad de tareas asignadas
    }

    @Override
    public String toString() {
        return getRol() + " - " + super.toString() + ", Herramienta: " + herramienta;
    }

}

