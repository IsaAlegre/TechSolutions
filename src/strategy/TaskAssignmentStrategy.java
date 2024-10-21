package strategy;

import Persona.employee.EmpleadoBase;
import model.Task;

import java.util.List;

public interface TaskAssignmentStrategy {
    EmpleadoBase assignTask(Task task, List<EmpleadoBase> empleados);
}
