package model;

public class Task {
    private String taskName;
    private String status;
    private String description;

    public Task(String taskName , String status, String description) {
        this.taskName  = taskName ;
        this.status = status;
        this.description = description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getTaskName() {
        return taskName ;
    }

    public String getDescripcion() {
        return description;
    }
}
