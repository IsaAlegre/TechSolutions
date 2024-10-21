package Persona.employee;

// GerenteProyecto.java
public class GerenteProyecto extends EmpleadoBase {
    public GerenteProyecto(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        super(nombre, apellido, dni, id, fechaNacimiento);
    }

    @Override
    public String getRol() {
        return "Gerente de Project.Proyecto";
    }
}
