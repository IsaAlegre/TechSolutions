package Factory;

import Persona.employee.Empleado;

// Factory.EmployeeFactory.java
public abstract class EmployeeFactory {
    public abstract Empleado crearEmpleado(String nombre, String apellido, String dni, String id, String fechaNacimiento);
}
