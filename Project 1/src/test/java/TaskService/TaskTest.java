package TaskService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    // Reusable task object for testing
    private Task task;

    @BeforeEach
    public void setUp() {
        // Initialize a valid task object for testing
        task = new Task("12345", "First Task", "This is the description for the first task.");
    }

    @Test
    public void testValidTaskCreation() {
        // Test case: Create a valid task and verify all fields are initialized correctly
        assertEquals("12345", task.getTaskId()); // Verify task ID
        assertEquals("First Task", task.getName()); // Verify name
        assertEquals("This is the description for the first task.", task.getDescription()); // Verify description
    }

    @Test
    public void testInvalidTaskId() {
        // Test case: Validate that a null or overly long task ID throws an exception
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description")); // Null ID
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description")); // ID too long
    }

    @Test
    public void testInvalidTaskName() {
        // Test case: Validate that a null or overly long task name throws an exception
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Task Description")); // Null name
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "This task name is far too long to be valid.", "Task Description")); // Name too long
    }

    @Test
    public void testInvalidTaskDescription() {
        // Test case: Validate that a null or overly long task description throws an exception
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Task Name", null)); // Null description
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Task Name", "This description exceeds the allowed length for task descriptions and should throw an error.")); // Description too long
    }

    @Test
    public void testUpdateTaskName() {
        // Test case: Update the task name and verify the change
        task.setName("Updated Task Name");
        assertEquals("Updated Task Name", task.getName()); // Verify updated name
    }

    @Test
    public void testInvalidUpdateTaskName() {
        // Test case: Validate that updating the name to null or an overly long value throws an exception
        assertThrows(IllegalArgumentException.class, () -> task.setName(null)); // Null name
        assertThrows(IllegalArgumentException.class, () -> task.setName("This task name is far too long to be valid.")); // Name too long
    }

    @Test
    public void testUpdateTaskDescription() {
        // Test case: Update the task description and verify the change
        task.setDescription("Updated Task Description");
        assertEquals("Updated Task Description", task.getDescription()); // Verify updated description
    }

    @Test
    public void testInvalidUpdateTaskDescription() {
        // Test case: Validate that updating the description to null or an overly long value throws an exception
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null)); // Null description
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("This description exceeds the allowed length for task descriptions and should throw an error.")); // Description too long
    }
}
