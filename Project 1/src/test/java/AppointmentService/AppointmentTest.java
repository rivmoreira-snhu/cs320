package AppointmentService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    private Appointment appointment;

    // Constants for test values
    private static final String APPOINTMENT_ID = "55555555";
    private static final String VALID_DESCRIPTION = "Weekly Architect meeting";
    private static final Date FUTURE_DATE = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
    private static final String LONG_DESCRIPTION = "This description is way too long and exceeds the maximum allowed length of 50 characters.";

    @BeforeEach
    public void setUp() {
        // Initialize a valid appointment object for testing
        appointment = new Appointment(APPOINTMENT_ID, FUTURE_DATE, VALID_DESCRIPTION);
    }

    @Test
    public void testValidAppointmentCreation() {
        // Test case: Create a valid appointment and validate its properties
        assertEquals(APPOINTMENT_ID, appointment.getAppointmentId());
        assertNotNull(appointment.getAppointmentDate());
        assertEquals(VALID_DESCRIPTION, appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        // Test case: Appointment ID null or too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("7777777777777", new Date(), "Description");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        // Test case: Appointment date in the past or null
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(APPOINTMENT_ID, new Date(System.currentTimeMillis() - 86400000), VALID_DESCRIPTION);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(APPOINTMENT_ID, null, VALID_DESCRIPTION);
        });
    }

    @Test
    public void testInvalidDescription() {
        // Test case: Description null or too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(APPOINTMENT_ID, FUTURE_DATE, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(APPOINTMENT_ID, FUTURE_DATE, LONG_DESCRIPTION);
        });
    }
}
