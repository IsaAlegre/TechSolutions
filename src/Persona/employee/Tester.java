package Persona.employee;

// Tester.java
public class Tester extends EmpleadoBase {
    public Tester(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        super(nombre, apellido, dni, id, fechaNacimiento);
    }

    @Override
    public String getRol() {
        return "Tester";
    }
}
