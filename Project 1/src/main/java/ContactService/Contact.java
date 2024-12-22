package ContactService;
public class Contact {
    private final String contactId; // Unique and not updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor to initialize the fields
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID is longer than 10 characters or empty, please retry.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is empty or longer than 10 character, please retry.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is empty or longer than 10 character, please retry.");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number is empty or not 10 characters in lenght or has other values other than numbers.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is longer than 30 characters, please retry.");
        }
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for updatable fields
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is empty or longer than 10 character, please retry.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is empty or longer than 10 character, please retry.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number is empty or not 10 characters in lenght or has other values other than numbers.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is longer than 30 characters, please retry.");
        }
        this.address = address;
    }
}
