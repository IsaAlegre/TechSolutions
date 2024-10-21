package strategy;

import Persona.employee.EmpleadoBase;
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

    public EmpleadoBase assignTask(Task task, List<EmpleadoBase> empleados ) {
       return  strategy.assignTask(task, empleados);
    }
}
