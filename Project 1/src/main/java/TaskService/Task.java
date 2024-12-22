package TaskService;
public class Task {
    private final String taskId; // Unique and unmodifiable
    private String name;
    private String description;

    // Constructor to initialize the task object
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID  is longer than 10 characters or empty, please retry.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name is empty or longer than 20 character, please retry.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description is empty or longer than 50 character, please retry.");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters for updatable fields
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name must not be empty or longer than 20 character, please retry. ");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description must not be empty or longer than 50 character, please retry.");
        }
        this.description = description;
    }
}
