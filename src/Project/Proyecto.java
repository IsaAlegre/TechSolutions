package Project;// src/com/techsolutions/project/Project.Proyecto.java

import Persona.cliente.Cliente;
import Persona.employee.Empleado;
import Persona.employee.GerenteProyecto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
    private String nombre;
    private String Descripcion;
    private String id;
    private Date fechaDeInicio;
    private Cliente cliente;
    private GerenteProyecto gerente;
    private List<Empleado> empleados;


    public Proyecto(String nombre, String descripcion,String id, Date fechaDeInicio, Cliente cliente) {
        this.nombre = nombre;
        this.Descripcion = descripcion;
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
        this.cliente = cliente;
        this.empleados = new ArrayList<>();
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }


    public void asignarEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " " + empleado.getApellido() + " asignado al proyecto " + nombre);
        } else {
            System.out.println("El empleado ya está asignado al proyecto.");
        }
    }

    public void borrarEmpleado(String idEmpleado) {
        Empleado empleado = empleados.stream().filter(e -> e.getId().equals(idEmpleado)).findFirst().orElse(null);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " " + empleado.getApellido() + " eliminado del proyecto " + nombre);
        } else {
            System.out.println("Empleado con ID " + idEmpleado + " no encontrado en el proyecto.");
        }
    }


    @Override
    public String toString() {
        return "Project.Proyecto: " + nombre + ", Cliente: " + cliente.getNombre() + " " + cliente.getApellido();
    }
}
