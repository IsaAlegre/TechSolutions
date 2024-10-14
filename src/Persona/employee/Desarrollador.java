package Persona.employee;

// Desarrollador.java
public class Desarrollador extends EmpleadoBase {
    public Desarrollador(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        super(nombre, apellido, dni, id, fechaNacimiento);
    }

    @Override
    public String getRol() {
        return "Desarrollador";
    }
}
