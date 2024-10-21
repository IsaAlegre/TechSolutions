package Persona.employee;

import java.util.Date;

public interface Empleado {
    String getId();
    String getNombre();
    String getApellido();
    String getHerramienta();
    String getFechaNacimiento();
    String getRol();

    // Métodos Setter
    void setHerramienta(String herramienta);
    void setNombre(String nombre);
    void setApellido(String apellido);
    void setDni(String dni);
    void setFechaNacimiento(String fechaNacimiento);
}
