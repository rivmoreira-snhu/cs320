package AppointmentService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Appointment appointment1;
    private Appointment appointment2;

    // Constants for test values
    private static final String APPOINTMENT_ID = "5555555";
    private static final String DESCRIPTION_1 = "Weekly Architect meeting";
    private static final String DESCRIPTION_2 = "1:1 with supervisor";
    private static final String UPDATED_DESCRIPTION = "Updated meeting description";
    private static final Date FUTURE_DATE_1 = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
    private static final Date FUTURE_DATE_2 = new Date(System.currentTimeMillis() + 172800000); // 2 days in the future
    private static final Date UPDATED_FUTURE_DATE = new Date(System.currentTimeMillis() + 172800000); // 2 days in the future

    @BeforeEach
    public void setUp() {
        // Initialize the AppointmentService and reusable appointment objects
        appointmentService = new AppointmentService();
        appointment1 = new Appointment(APPOINTMENT_ID, FUTURE_DATE_1, DESCRIPTION_1);
        appointment2 = new Appointment(APPOINTMENT_ID, FUTURE_DATE_2, DESCRIPTION_2);
    }

    @Test
    public void testAddAppointment() {
        // Test adding a valid appointment
        appointmentService.addAppointment(appointment1);
        assertTrue(appointmentService.getAppointments().containsKey(APPOINTMENT_ID));
        assertEquals(appointment1, appointmentService.getAppointments().get(APPOINTMENT_ID));

        // Test adding an appointment with a duplicate ID
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        // Test deleting an existing appointment
        appointmentService.addAppointment(appointment1);
        appointmentService.deleteAppointment(APPOINTMENT_ID);
        assertFalse(appointmentService.getAppointments().containsKey(APPOINTMENT_ID));

        // Test deleting a non-existent appointment
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment(APPOINTMENT_ID);
        });
    }
    @Test
    public void testUpdateAppointment() {
        // Add an initial appointment
        appointmentService.addAppointment(appointment1);

        // Update the appointment with a new date and description
        appointmentService.updateAppointment(APPOINTMENT_ID, UPDATED_FUTURE_DATE, UPDATED_DESCRIPTION);

        // Retrieve the updated appointment and verify the changes
        Appointment updatedAppointment = appointmentService.getAppointments().get(APPOINTMENT_ID);
        assertEquals(UPDATED_FUTURE_DATE, updatedAppointment.getAppointmentDate());
        assertEquals(UPDATED_DESCRIPTION, updatedAppointment.getDescription());
    }

    @Test
    public void testUpdateNonexistentAppointment() {
        // Attempt to update an appointment that does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointment("9999999", UPDATED_FUTURE_DATE, UPDATED_DESCRIPTION);
        });
    }

    @Test
    public void testUpdateWithInvalidData() {
        // Add an initial appointment
        appointmentService.addAppointment(appointment1);

        // Attempt to update with a null date
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointment(APPOINTMENT_ID, null, UPDATED_DESCRIPTION);
        });

        // Attempt to update with a date in the past
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointment(APPOINTMENT_ID, pastDate, UPDATED_DESCRIPTION);
        });

        // Attempt to update with a null description
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointment(APPOINTMENT_ID, UPDATED_FUTURE_DATE, null);
        });

        // Attempt to update with an overly long description
        String longDescription = "This description exceeds the maximum allowed length of 50 characters.";
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointment(APPOINTMENT_ID, UPDATED_FUTURE_DATE, longDescription);
        });
    }
}
