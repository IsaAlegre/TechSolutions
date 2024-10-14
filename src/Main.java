import adapter.OldDatabase;

import adapter.ProjectAdapter;
import adapter.ProjectInfo;
import model.Employee;
import model.Task;
import strategy.LeastTasksStrategy;
import strategy.MostExperiencedStrategy;
import strategy.TaskAssignmentContext;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Develop feature A", "completd");
        Task task2 = new Task("Test feature B", "pending");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 5));
        employees.add(new Employee("Bob", 2));
        employees.add(new Employee("Charlie", 3));

        // Creamos el contexto con la estrategia de menos tareas
        TaskAssignmentContext context = new TaskAssignmentContext(new LeastTasksStrategy());
        context.assignTask(task1, employees);

        // Cambiamos la estrategia a la de más experiencia
        context.setStrategy(new MostExperiencedStrategy());
        context.assignTask(task2, employees);





        OldDatabase oldDatabase = new OldDatabase();
        ProjectAdapter projectAdapter = new ProjectAdapter(oldDatabase);

        ProjectInfo projectInfo = projectAdapter.getProjectInfo();

        if (projectInfo != null) {
            System.out.println("Nombre del Proyecto: " + projectInfo.getProjectName());
            System.out.println("Gerente: " + projectInfo.getManager());
            for (Task task : projectInfo.getTasks()) {
                System.out.println("Tarea: " + task.getTaskName() + " - Estado: " + task.getStatus());
            }
        } else {
            System.out.println("No se pudo obtener la información del proyecto.");
        }
    }
}