package strategy;

import model.Employee;
import model.Task;

import java.util.List;
// estrategia para asignar tareas al empleado con mennos tareas
public class LeastTasksStrategy implements TaskAssignmentStrategy{
    @Override
    public void assignTask(Task task, List<Employee> employees) {
        Employee leastTasksEmployee = employees.stream()
                .min((e1, e2) -> Integer.compare(e1.getTasks().size(), e2.getTasks().size()))
                .orElse(null);

        if (leastTasksEmployee != null) {
            leastTasksEmployee.assignTask(task);
            System.out.println("Tarea '" + task.getTaskName() + "' asignada a " + leastTasksEmployee.getName() + " (menos tareas)");
        }
    }
}


