package set.Search;

import java.util.Objects;

public class Task {
    private final String description;
    private Boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }

    @Override
    public String toString() {
        String status;
        if(completed.equals(true)){
            status = "COMPLETED";
        }else {
            status = "PENDING";
        }
        return '[' +
                " description= " + description + '\'' +
                " status= " + status +
                ']';
    }
}
