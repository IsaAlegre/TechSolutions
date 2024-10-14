package model;

public class Task {
    private String taskName;
    private String status;

    public Task(String taskName , String status) {
        this.taskName  = taskName ;
        this.status = status;
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
}
