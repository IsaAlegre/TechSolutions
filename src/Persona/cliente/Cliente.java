package Persona.cliente;

import Persona.Persona;

// Persona.cliente.Cliente.java
public class Cliente extends Persona {
    private String direccion;

    public Cliente(String nombre, String apellido, String dni, String id, String fechaNacimiento, String direccion) {
        super(nombre, apellido, dni, id, fechaNacimiento);
        this.direccion = direccion;
    }

    // Getter y Setter
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona.cliente.Cliente - " + super.toString() + ", Dirección: " + direccion;
    }
}
