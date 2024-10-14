package model;

import Observer.Observable;
import Observer.Observador;

import java.util.ArrayList;
import java.util.List;

public class Task implements Observable {
    private String taskName;
    private String status;
    private String description;
    private List<Observador> observadores;

    public Task(String taskName, String description, String status) {
        this.taskName = taskName;
        this.status = "Pendiente"; // Estado inicial
        this.observadores = new ArrayList<>();
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void añadirObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() { // Cambiado a plural, y sin parámetros
        for (Observador observador : observadores) {
            observador.actualizar(this); // `this` es la instancia actual de Task
        }
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
        notificarObservadores(); // Notificar a todos los observadores
    }

    public String getStatus() {
        return status;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescripcion() {
        return description;
    }
}
