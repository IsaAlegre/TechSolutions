package Factory;

import Persona.employee.Diseñador;
import Persona.employee.EmpleadoBase;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DIseñadorFactory extends EmployeeFactory {
    private static final List<String> HERRAMIENTAS = Arrays.asList(
            "Figma", "Adobe Illustrator", "Sketch", "Fronty", "Dafont", "InDesign"
    );
    private static final Random RANDOM = new Random();

    @Override
    public EmpleadoBase crearEmpleado(String nombre, String apellido, String dni, String id, String fechaNacimiento) {
        Diseñador diseñador = new Diseñador(nombre, apellido, dni, id, fechaNacimiento);
        String herramientaAsignada = HERRAMIENTAS.get(RANDOM.nextInt(HERRAMIENTAS.size()));
        diseñador.setHerramienta(herramientaAsignada);
        return diseñador;
    }
}
