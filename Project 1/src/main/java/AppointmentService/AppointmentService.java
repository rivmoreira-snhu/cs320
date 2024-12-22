package AppointmentService;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AppointmentService {
    private final Map<String, Appointment> appointments;
    private static final Logger logger = Logger.getLogger(AppointmentService.class.getName());

    public AppointmentService() {
        this.appointments = new HashMap<>();
        logger.info("AppointmentService initialized.");
    }

    // Adding a new appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            logger.warning("Attempt to add duplicate appointment ID: " + appointment.getAppointmentId());
            throw new IllegalArgumentException("Appointment ID already exists. ID must be unique.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
        logger.info("Appointment added with ID: " + appointment.getAppointmentId());
    }

    // Deleting an appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            logger.warning("Attempt to delete non-existent appointment ID: " + appointmentId);
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(appointmentId);
        logger.info("Appointment deleted with ID: " + appointmentId);
    }

    // Updating an existing appointment
    public void updateAppointment(String appointmentId, java.util.Date newDate, String newDescription) {
        if (!appointments.containsKey(appointmentId)) {
            logger.warning("Attempt to update non-existent appointment ID: " + appointmentId);
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
    
        // Validate new date
        if (newDate == null || newDate.before(new java.util.Date())) {
            logger.warning("Invalid appointment date provided for update: " + newDate);
            throw new IllegalArgumentException("Appointment date cannot be null or in the past.");
        }
    
        // Validate new description
        if (newDescription == null || newDescription.length() > 50) {
            logger.warning("Invalid appointment description provided for update: " + newDescription);
            throw new IllegalArgumentException("Description cannot be null or exceed 50 characters.");
        }
    
        // Create updated appointment
        Appointment updatedAppointment = new Appointment(appointmentId, newDate, newDescription);
        appointments.put(appointmentId, updatedAppointment);
        logger.info("Appointment updated with ID: " + appointmentId);
    }
    
    // Getter for appointment map (for testing purposes)
    public Map<String, Appointment> getAppointments() {
        return new HashMap<>(appointments); // Return a copy to prevent modification
    }
}
