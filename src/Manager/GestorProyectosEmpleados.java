
package Manager;
import Persona.employee.Empleado;
import Persona.employee.EmpleadoBase;
import Project.Proyecto;
import java.util.ArrayList;
import java.util.List;

public class GestorProyectosEmpleados {
    private static GestorProyectosEmpleados instance;
    private List<Proyecto> proyectos;
    private List<EmpleadoBase> empleados;

    // Constructor privado para evitar instanciación
    private GestorProyectosEmpleados() {
        proyectos = new ArrayList<>();
        empleados = new ArrayList<>();
    }

    // Método para obtener la instancia única de ProjectManager
    public static GestorProyectosEmpleados getInstance() {
        if (instance == null) {
            synchronized (GestorProyectosEmpleados.class) {
                if (instance == null) {
                    instance = new GestorProyectosEmpleados();
                }
            }
        }
        return instance;
    }


    // Métodos para gestionar Empleados
    public void agregarEmpleado(EmpleadoBase empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado);
    }

    public void borrarEmpleado(String id) {
        EmpleadoBase empleado = encontrarEmpleadoPorId(id);
        if (empleado != null) {
            empleados.remove(empleado);
            System.out.println("Empleado eliminado: " + empleado);
        } else {
            System.out.println("Empleado con ID " + id + " no encontrado.");
        }
    }

    public void modificarEmpleado(String id, String nuevoNombre, String nuevoApellido, String nuevoDni, String nuevaFechaNacimiento) {
        Empleado empleado = encontrarEmpleadoPorId(id);
        if (empleado != null) {
            if (empleado instanceof EmpleadoBase) {
                EmpleadoBase empleadoBase = (EmpleadoBase) empleado;
                empleadoBase.setNombre(nuevoNombre);
                empleadoBase.setApellido(nuevoApellido);
                empleadoBase.setDni(nuevoDni);
                empleadoBase.setFechaNacimiento(nuevaFechaNacimiento);
                System.out.println("Empleado modificado: " + empleado);
            } else {
                System.out.println("El empleado encontrado no es de tipo EmpleadoBase.");
            }
        } else {
            System.out.println("Empleado con ID " + id + " no encontrado.");
        }
    }


    public void listarEmpleados() {
        System.out.println("===== Lista de Empleados =====");
        for (EmpleadoBase empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public EmpleadoBase encontrarEmpleadoPorId(String id) {
        for (EmpleadoBase e : empleados) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    // Métodos para gestionar Proyectos
    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
        System.out.println("Project.Proyecto agregado: " + proyecto);
    }

    public void listarProyectos() {
        System.out.println("===== Lista de Proyectos =====");
        for (Proyecto proyecto : proyectos) {
            System.out.println(proyecto);
        }
    }

    public Proyecto encontrarProyectoPorNombre(String nombre) {
        for (Proyecto p : proyectos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public List<EmpleadoBase> getEmpleados() {
        return empleados;
    }


}
