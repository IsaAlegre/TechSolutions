package strategy;

import model.Employee;
import model.Task;

import java.util.List;

public class ByRoleStrategy {
    private String requiredRole;

    public ByRoleStrategy(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    @Override
    public Employee  assignTask(Task tarea, List<Employee > employees) {
        // Buscar el empleado con el rol requerido
        for (Employee employee : empleados) {
            if (employee .getRole().equalsIgnoreCase(requiredRole)) {
                return empleados;
            }
        }
        return null; // Si no se encuentra un empleado con ese rol
    }
}
