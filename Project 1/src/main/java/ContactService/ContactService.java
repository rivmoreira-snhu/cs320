package ContactService;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Please select another value for Contact ID, entered value already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Please select another value for Contact ID, entered value not found.");
        }
        contacts.remove(contactId);
    }

    // Update contact fields by ID
    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null) {
            contact.setPhone(phoneNumber);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Retrieve a contact (optional utility method for testing)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
