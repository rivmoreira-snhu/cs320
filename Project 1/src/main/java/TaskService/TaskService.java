package TaskService;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    // Adding a new task
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists. ID needs to be unique.");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Deleting a task by ID
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID was not found. Task was not deleted.");
        }
        tasks.remove(taskId);
    }

    // Updating task fields by ID
    public void updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID was not found. Task was not updated.");
        }

        if (name != null) {
            task.setName(name);
        }
        if (description != null) {
            task.setDescription(description);
        }
    }

    // Retrieving a task (optional utility for testing)
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
