package strategy;

import model.Employee;
import model.Task;

import java.util.List;

public interface TaskAssignmentStrategy {
    void assignTask(Task task, List<Employee> employees);
}
