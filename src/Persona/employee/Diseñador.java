package Persona.employee;

public class Diseñador extends EmpleadoBase {
    public Diseñador(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        super(nombre, apellido, dni, id, fechaNacimiento);
    }
    @Override
    public String getRol() {
        return "Diseñador";
    }
}
