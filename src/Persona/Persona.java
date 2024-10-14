package Persona;

// Persona.Persona.java
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String id;
    private String fechaNacimiento; // Formato: "dd/MM/yyyy"

    public Persona(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getId() {
        return id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Métodos para agregar, borrar, modificar y listar personas
    // Estos métodos pueden ser gestionados por Manager.ProjectManager
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + " " + apellido + ", DNI: " + dni + ", Fecha de Nacimiento: " + fechaNacimiento;
    }
}
