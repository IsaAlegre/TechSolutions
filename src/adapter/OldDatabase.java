package adapter;

public class OldDatabase {
    public String getData() {
        // Devuelve datos en un formato incompatible
        return "{\"projectName\":\"Nuevo Proyecto\"," +
                "\"manager\":\"Jane Smith\"," +
                "\"descripcion\":\"Descripción del proyecto\"," +
                "\"id\":\"PR1728897800549\"," +
                "\"fechaDeInicio\":\"2024-10-14\"," +
                "\"cliente\":{\"nombre\":\"Juan\",\"apellido\":\"Pérez\",\"dni\":\"12345678\",\"id\":\"CLI001\",\"fechaNacimiento\":\"1985-05-10\",\"direccion\":\"Calle Falsa 123\"}," +
                "\"empleado\":{\"nombre\":\"Carlos\",\"apellido\":\"González\",\"dni\":\"87654321\",\"id\":\"EMP001\",\"fechaNacimiento\":\"1990-08-15\"}," +
                "\"tasks\":[{\"taskName\":\"Planificación\",\"descripcion\":\"Planificación del proyecto\",\"status\":\"pendiente\"}," +
                "{\"taskName\":\"Implementación\",\"descripcion\":\"Desarrollo del sistema\",\"status\":\"en progreso\"}]}";
    }
}
