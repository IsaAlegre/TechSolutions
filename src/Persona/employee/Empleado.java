package Persona.employee;

import Persona.Persona;

// Empleado.java
public abstract class Empleado extends Persona {
    private String herramienta;
    public Empleado(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        super(nombre, apellido, dni, id, fechaNacimiento);
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public abstract String getRol();

    @Override
    public String toString() {
        return getRol() + " - " + super.toString() + ", Herramienta: " + herramienta;
    }

}

