package strategy;

import Persona.employee.Empleado;
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

    public Empleado assignTask(Task task, List<Empleado > empleados ) {
       return  strategy.assignTask(task, empleados);
    }
}
