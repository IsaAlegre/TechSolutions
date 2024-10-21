package strategy;

import Persona.employee.EmpleadoBase;

import model.Task;

import java.util.List;

public class RoleAndLeastTasksStrategy implements TaskAssignmentStrategy {
        private String requiredRole;

        public RoleAndLeastTasksStrategy(String requiredRole) {
            this.requiredRole = requiredRole;
        }



        @Override
        public EmpleadoBase assignTask(Task task, List<EmpleadoBase> empleados) {
            EmpleadoBase selectedEmployee = null;

            for (EmpleadoBase empleado : empleados) {
                if (empleado.getRol().equals(requiredRole)) {
                    // Si aún no hemos seleccionado un empleado o el actual tiene menos tareas asignadas
                    if (selectedEmployee == null || empleado.getAssignedTasksCount() < selectedEmployee.getAssignedTasksCount()) {
                        selectedEmployee = empleado;
                    }
                }
            }

            if (selectedEmployee != null) {
                selectedEmployee.performTask(task);
                System.out.println("Tarea asignada a " + selectedEmployee.getNombre() + " con rol " + selectedEmployee.getRol());
            } else {
                System.out.println("No hay empleados disponibles con el rol requerido: " + requiredRole);
            }
            return selectedEmployee;
        }
    }

