package strategy;

import model.Employee;
import model.Task;

import java.util.List;
//Esta estrategia asigna la tarea al empleado con más experiencia.
public class MostExperiencedStrategy implements TaskAssignmentStrategy{
    @Override
    public void assignTask(Task task, List<Employee> employees) {
        Employee mostExperiencedEmployee = employees.stream()
                .max((e1, e2) -> Integer.compare(e1.getExperience(), e2.getExperience()))
                .orElse(null);

        if (mostExperiencedEmployee != null) {
            mostExperiencedEmployee.assignTask(task);
            System.out.println("Tarea '" + task.getTaskName()+ "' asignada a " + mostExperiencedEmployee.getName() + " (más experiencia)");
        }
    }

}
