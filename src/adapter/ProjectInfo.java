package adapter;

import model.Task;

import java.util.List;

public class ProjectInfo {
    private String projectName;
    private String manager;
    private List<Task> tasks;

    public ProjectInfo(String projectName, String manager, List<Task> tasks) {
        this.projectName = projectName;
        this.manager = manager;
        this.tasks = tasks;
    }

    // Getters y setters
    public String getProjectName() {
        return projectName;
    }

    public String getManager() {
        return manager;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
