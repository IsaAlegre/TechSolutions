package strategy;

import model.Employee;
import model.Task;

import java.util.List;

public class TaskAssignmentContext {
    private TaskAssignmentStrategy strategy;

    public TaskAssignmentContext(TaskAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TaskAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignTask(Task task, List<Employee> employees) {
        strategy.assignTask(task, employees);
    }
}
