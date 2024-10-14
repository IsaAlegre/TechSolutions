package adapter;

public class OldDatabase {
    public String getData() {
        // Devuelve datos en un formato incompatible (por simplicidad, lo devolvemos como un String JSON)

        return "{\"projectName\":\"New Project\",\"manager\":\"Jane Smith\",\"tasks\":[{\"taskName\":\"Planning\",\"status\":\"pending\"},{\"taskName\":\"Implementation\",\"status\":\"in_progress\"}]}";
    }
}
