package Factory;

import Persona.employee.EmpleadoBase;
import Persona.employee.Tester;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TesterFactory extends EmployeeFactory {

    private static final List<String> HERRAMIENTAS = Arrays.asList(
            "Selenium", "JMeter", "Postman", "Cypress", "JUnit", "TestRail"
    );

    private static final Random RANDOM = new Random();

    @Override
    public EmpleadoBase crearEmpleado(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        Tester tester = new Tester(nombre, apellido, dni, id, fechaNacimiento);
        String herramientaAsignada = HERRAMIENTAS.get(RANDOM.nextInt(HERRAMIENTAS.size()));
        tester.setHerramienta(herramientaAsignada);
        return tester;
    }
}