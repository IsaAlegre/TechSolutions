package Factory;

import Persona.employee.Empleado;
import Persona.employee.GerenteProyecto;
import Persona.employee.Tester;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenteProyectoFactory extends EmployeeFactory {
    private static final List<String> HERRAMIENTAS = Arrays.asList(
            "Trello", "Asana", "Jira", "Microsoft Project", "Basecamp", "Monday.com"
    );

    private static final Random RANDOM = new Random();
    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        GerenteProyecto gerente = new GerenteProyecto(nombre, apellido, dni, id, fechaNacimiento);
        String herramientaAsignada = HERRAMIENTAS.get(RANDOM.nextInt(HERRAMIENTAS.size()));
        gerente.setHerramienta(herramientaAsignada);
        return gerente;
    }
}