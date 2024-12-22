package TaskService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    // Instance of TaskService for managing tasks
    private TaskService taskService;

    // Reusable task objects for testing
    private Task task1;
    private Task task2;

    @BeforeEach
    public void setUp() {
        // Initialize the TaskService and reusable task objects for testing
        taskService = new TaskService();
        task1 = new Task("12345", "Task One", "This is the task Description for Task One.");
        task2 = new Task("54321", "Task Two", "This is another task Description for Task Two.");
    }

    @Test
    public void testAddTask() {
        // Test case: Add a valid task and verify it is stored in TaskService
        taskService.addTask(task1); // Add the first task
        assertEquals(task1, taskService.getTask("12345")); // Ensure the task is retrievable by its ID
    }

    @Test
    public void testAddDuplicateTaskThrowsException() {
        // Test case: Adding a task with a duplicate ID should throw an exception
        taskService.addTask(task1); // Add the first task
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task1)); // Add the same task again and check for exception
    }

    @Test
    public void testDeleteTask() {
        // Test case: Add and delete a task, ensuring it is removed from TaskService
        taskService.addTask(task2); // Add the second task
        taskService.deleteTask("54321"); // Delete the task by its ID
        assertNull(taskService.getTask("54321")); // Verify the task is no longer retrievable
    }

    @Test
    public void testUpdateTask() {
        // Test case: Add a task and update its fields, verifying all changes are applied
        taskService.addTask(task1); // Add the first task
        taskService.updateTask("12345", "Updated Task", "Updated Task Desc"); // Update the task's fields

        Task updatedTask = taskService.getTask("12345"); // Retrieve the updated task
        assertEquals("Updated Task", updatedTask.getName()); // Verify updated name
        assertEquals("Updated Task Desc", updatedTask.getDescription());  // Verify the description was updated
    }

    @Test
    public void testUpdateNonexistentTaskThrowsException() {
        // Test case: Attempting to update a task that doesn't exist should throw an exception
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("99999", "Name", "Description")); // Update non-existent task and verify exception
    }
}
