package list.BasicOperations;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String description) {
        taskList.add(new Task(description));
    }

    public void removeTask(String description) {
        taskList.removeIf(task -> task.getDescription().equalsIgnoreCase(description));

        /* remove if it's the same thing as the code below
        for (Task task: taskList) {
            if(task.getDescription().equalsIgnoreCase(description)){
                taskList.remove(task);
            }
        }*/
    }

    public int countList() {
        return taskList.size();
    }

    public List<Task> listAllDescriptions() {
        return taskList;
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        System.out.println("Number of tasks: " + taskList.countList());
        taskList.addTask("Task 1");
        taskList.addTask("Task 2");
        taskList.addTask("Task 3");
        taskList.addTask("Task 3");
        taskList.addTask("Task 1");

        System.out.println("Number of tasks: " + taskList.countList());

        taskList.removeTask("Task 1");

        System.out.println("Number of tasks: " + taskList.countList());

        System.out.println(taskList.listAllDescriptions());
        }
    }
