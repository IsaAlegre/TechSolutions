package Factory;

import Persona.employee.EmpleadoBase;

// Factory.EmployeeFactory.java
public abstract class EmployeeFactory {
    public abstract EmpleadoBase crearEmpleado(String nombre, String apellido, String dni, String id, String fechaNacimiento);
}
