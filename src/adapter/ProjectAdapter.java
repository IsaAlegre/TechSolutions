package adapter;

import model.Task;

import java.util.ArrayList;
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
            // Si no se encuentra la clave, devuelve un valor vacío
            return "";
        }
        // Ajusta el índice para saltar la longitud de searchKey
        startIndex += searchKey.length();
        int endIndex = jsonData.indexOf("\"", startIndex);
        if (endIndex == -1) {
            // Si no se encuentra el final del valor, devuelve un valor vacío
            return "";
        }
        return jsonData.substring(startIndex, endIndex);
    }

    public ProjectInfo getProjectInfo() {
        String jsonData = oldDatabase.getData();

        // Parsear manualmente los datos JSON (básico)
        String projectName = parseValue(jsonData, "projectName");
        String manager = parseValue(jsonData, "manager");

        // Inicializa una lista de tareas
        List<Task> tasks = new ArrayList<>();

        int startIndex = jsonData.indexOf("[{");
        int endIndex = jsonData.indexOf("}]") + 2;

        if (startIndex != -1 && endIndex != -1) {
            String tasksArray = jsonData.substring(startIndex, endIndex);
            String[] taskEntries = tasksArray.split("\\},\\{");

            for (String taskEntry : taskEntries) {
                // Agregar llaves faltantes para que cada entrada sea un JSON válido
                taskEntry = "{" + taskEntry.replace("[", "").replace("]", "").replace("}", "") + "}";
                String taskName = parseValue(taskEntry, "taskName");
                String status = parseValue(taskEntry, "status");

                // Solo agregar la tarea si los valores no están vacíos
                if (!taskName.isEmpty() && !status.isEmpty()) {
                    tasks.add(new Task(taskName, status));
                }
            }
        }

        // Devuelve null si el nombre del proyecto o el gerente no están presentes
        if (projectName.isEmpty() || manager.isEmpty()) {
            System.out.println("Error: El JSON no contiene la información necesaria del proyecto.");
            return null;
        }

        return new ProjectInfo(projectName, manager, tasks);
    }
}
