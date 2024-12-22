package AppointmentService;
public class Appointment {
    private final String appointmentId; // Unique and unmodifiable
    private final java.util.Date appointmentDate; // Required and must not be in the past
    private final String description; // Required and up to 50 characters

    // Constructor to initialize the appointment object
    public Appointment(String appointmentId, java.util.Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is longer than 10 characters or empty, please retry.");
        }
        if (appointmentDate == null || appointmentDate.before(new java.util.Date())) {
            throw new IllegalArgumentException("Appointment date cannot be empty and must not be in the past, please retry.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is empty or longer than 50 character, please retry.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter methods
    public String getAppointmentId() {
        return appointmentId;
    }

    public java.util.Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
