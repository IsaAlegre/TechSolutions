package strategy;

import Persona.employee.Empleado;
import model.Task;

import java.util.List;

public interface TaskAssignmentStrategy {
    Empleado assignTask(Task task, List<Empleado> empleados);
}
