package Factory;

import Persona.employee.Desarrollador;
import Persona.employee.EmpleadoBase;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DesarrolladorFactory extends EmployeeFactory {
    private static final List<String> HERRAMIENTAS = Arrays.asList(
            "Node.js", "Next.js", "Java", "Python", "React", "Angular"
    );

    private static final Random RANDOM = new Random();

    @Override
    public EmpleadoBase crearEmpleado(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        Desarrollador desarrollador = new Desarrollador(nombre, apellido, dni, id, fechaNacimiento);
        String herramientaAsignada = HERRAMIENTAS.get(RANDOM.nextInt(HERRAMIENTAS.size()));
        desarrollador.setHerramienta(herramientaAsignada);
        return desarrollador;
    }
}
