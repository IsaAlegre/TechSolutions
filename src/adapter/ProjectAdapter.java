package adapter;

import Persona.cliente.Cliente;
import Persona.employee.EmpleadoBase;
import model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectAdapter {
    private OldDatabase oldDatabase;

    public ProjectAdapter(OldDatabase oldDatabase) {
        this.oldDatabase = oldDatabase;
    }

    private String parseValue(String jsonData, String key) {
        String searchKey = "\"" + key + "\":\"";
        int startIndex = jsonData.indexOf(searchKey);
        if (startIndex == -1) {
            return ""; // Clave no encontrada
        }
        startIndex += searchKey.length();
        int endIndex = jsonData.indexOf("\"", startIndex);
        if (endIndex == -1) {
            return ""; // Fin del valor no encontrado
        }
        return jsonData.substring(startIndex, endIndex);
    }

    public ProjectInfo getProjectInfo() {
        String jsonData = oldDatabase.getData();

        // Parsear manualmente los datos JSON (básico)
        String projectName = parseValue(jsonData, "projectName");
        String manager = parseValue(jsonData, "manager");
        String descripcion = parseValue(jsonData, "descripcion");
        String id = parseValue(jsonData, "id");
        Date fechaDeInicio = new Date(); // Suponiendo que quieres establecer la fecha de inicio a la fecha actual


        String clientName = parseValue(jsonData, "nombre");
        String clientApellido = parseValue(jsonData, "apellido");
        String clientDNI = parseValue(jsonData, "dni");
        String clientId = parseValue(jsonData, "id");
        String clientFechaNacimiento = parseValue(jsonData, "fechaNacimiento");
        String clientDireccion = parseValue(jsonData, "direccion");

// Crear objeto Cliente
        Cliente cliente = new Cliente(clientName, clientApellido, clientDNI, clientId, clientFechaNacimiento, clientDireccion);

// Parsear información del empleado
        String empleadoId = parseValue(jsonData, "id");
        String empleadoNombre = parseValue(jsonData, "nombre");
        String empleadoApellido = parseValue(jsonData, "apellido");
        String empleadoDNI = parseValue(jsonData, "dni");
        String empleadoFechaNacimiento = parseValue(jsonData, "fechaNacimiento");

// Crear objeto Empleado
        EmpleadoBase empleado = new EmpleadoBase(empleadoNombre, empleadoApellido, empleadoDNI, empleadoId, empleadoFechaNacimiento) {
            @Override
            public String getRol() {
                return "";
            }
        };

        // Inicializa una lista de tareas
        List<Task> tasks = new ArrayList<>();
        int startIndex = jsonData.indexOf("[{");
        int endIndex = jsonData.indexOf("}]") + 2;

        if (startIndex != -1 && endIndex != -1) {
            String tasksArray = jsonData.substring(startIndex, endIndex);
            String[] taskEntries = tasksArray.split("\\},\\{");

            for (String taskEntry : taskEntries) {
                // Asegúrate de que cada entrada sea un JSON válido
                taskEntry = taskEntry.trim();
                taskEntry = taskEntry.startsWith("{") ? taskEntry : "{" + taskEntry;
                taskEntry = taskEntry.endsWith("}") ? taskEntry : taskEntry + "}";

                String taskName = parseValue(taskEntry, "taskName");
                String status = parseValue(taskEntry, "status");
                String descripcionTarea = parseValue(taskEntry, "descripcion"); // Asumiendo que esto también existe

                // Solo agregar la tarea si los valores no están vacíos
                if (!taskName.isEmpty() && !status.isEmpty()) {
                    tasks.add(new Task(taskName, descripcionTarea, status));
                }
            }
        }

        // Comprobar si hay errores en la información del proyecto
        if (projectName.isEmpty() || manager.isEmpty()) {
            System.out.println("Error: El JSON no contiene la información necesaria del proyecto.");
            return null;
        }

        // Crear y devolver un nuevo objeto ProjectInfo
        return new ProjectInfo(projectName, manager, tasks, cliente, empleado, descripcion, id, fechaDeInicio);
    }
}
