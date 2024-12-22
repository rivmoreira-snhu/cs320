package ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Instance of ContactService for managing contacts
    private ContactService contactService;

    // Reusable contact objects for testing
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    public void setUp() {
        // Initialize the ContactService and reusable contact objects
        contactService = new ContactService();
        contact1 = new Contact("12345", "Angel", "Rivera", "5552615303", "3000 South Randolph Street");
        contact2 = new Contact("54321", "John", "Doe", "5559876543", "4000 North Randolph Street");
    }

    @Test
    public void testAddContact() {
        // Add a new contact and verify it's stored in the ContactService
        contactService.addContact(contact1);
        assertEquals(contact1, contactService.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContactIdThrowsException() {
        // Attempt to add two contacts with the same ID and ensure an exception is thrown
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact1));
    }

    @Test
    public void testDeleteContact() {
        // Add and then delete a contact, ensuring it is removed from ContactService
        contactService.addContact(contact2);
        contactService.deleteContact("54321");
        assertNull(contactService.getContact("54321"));
    }

    @Test
    public void testUpdateContact() {
        // Add a contact and update its fields
        contactService.addContact(contact1);
        contactService.updateContact("12345", "Angelo", "Smith", "5557891234", "5000 North Randolph Street");

        // Retrieve the updated contact and verify all changes
        Contact updatedContact = contactService.getContact("12345");
        assertEquals("Angelo", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("5557891234", updatedContact.getPhone());
        assertEquals("5000 North Randolph Street", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContactThrowsException() {
        // Attempt to update a contact that doesn't exist and ensure an exception is thrown
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("99999", "Angel", null, null, null));
    }
}
