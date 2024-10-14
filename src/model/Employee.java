package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int experience;
    private List<Task> tasks;
    private String rol;

    public Employee(String name, int experience, List<Task> tasks, String rol) {
        this.name = name;
        this.experience = experience;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void assignTask(Task task) {
        tasks.add(task);
    }

    public String getRol() {
        return rol;
    }
}
