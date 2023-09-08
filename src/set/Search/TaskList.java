package set.Search;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskList {
    private final Set<Task> tasks;

    public TaskList() {
        this.tasks = new HashSet<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(String description) {
        tasks.removeIf(String -> String.getDescription().equalsIgnoreCase(description));
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public int countTasks() {
        return tasks.size();
    }

    public Set<Task> getCompleted() {
        return tasks.stream().filter(Task -> Task.getCompleted().equals(true)).collect(Collectors.toSet());
    }

    public Set<Task> getPending() {
        return tasks.stream().filter(Task -> Task.getCompleted().equals(false)).collect(Collectors.toSet());
    }

    public void markAsComplete(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.setCompleted(true);
            }
        }
    }

    public void markAsPending(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.setCompleted(false);
            }
        }
    }

    public void removeAll() {
        tasks.clear();
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        System.out.println("Tasks quantity: " + taskList.countTasks());

        taskList.addTask("Make coffee");
        taskList.addTask("Take trash out");
        taskList.addTask("Clean room");
        taskList.addTask("Study");

        System.out.println("Tasks: " + taskList.getTasks());

        taskList.markAsComplete("Make coffee");
        taskList.markAsComplete("Clean room");

        System.out.println("Tasks: " + taskList.getTasks());

        taskList.markAsPending("Make coffee");

        System.out.println("Tasks: " + taskList.getTasks());

        taskList.removeTask("Study");

        System.out.println("Tasks: " + taskList.getTasks());


        System.out.println("Tasks quantity: " + taskList.countTasks());
        System.out.println("Completed Tasks: " + taskList.getCompleted());
        System.out.println("Pending Tasks: " + taskList.getPending());


        taskList.removeAll();
        System.out.println("Tasks: " + taskList.getTasks());

    }
}
