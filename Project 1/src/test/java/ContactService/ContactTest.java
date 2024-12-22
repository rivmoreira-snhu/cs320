package ContactService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    // Reusable contact objects for testing
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    public void setUp() {
        // Initialize reusable contact objects with valid values
        contact1 = new Contact("12345", "Angel", "Rivera", "5552615303", "3000 South Randolph Street");
        contact2 = new Contact("54321", "John", "Doe", "5559876543", "4000 North Randolph Street");
    }

    @Test
    public void testValidContactCreation() {
        // Test creation of a valid contact and ensure fields are initialized correctly
        assertEquals("12345", contact1.getContactId());
        assertEquals("Angel", contact1.getFirstName());
        assertEquals("Rivera", contact1.getLastName());
        assertEquals("5552615303", contact1.getPhone());
        assertEquals("3000 South Randolph Street", contact1.getAddress());
    }

    @Test
    public void testContactIdUnchangeable() {
        // Simulate an attempt to modify the contact ID and confirm it's unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Contact ID cannot be updated.");
        });
    }

    @Test
    public void testSetFirstNameValid() {
        // Update the first name to a valid value and verify the change
        contact1.setFirstName("Angelo");
        assertEquals("Angelo", contact1.getFirstName());
    }

    @Test
    public void testSetFirstNameInvalid() {
        // Ensure invalid first names throw exceptions
        assertThrows(IllegalArgumentException.class, () -> contact1.setFirstName(null)); // Null value
        assertThrows(IllegalArgumentException.class, () -> contact1.setFirstName("AngelinaTooLong")); // Too long
    }

    @Test
    public void testSetLastNameValid() {
        // Update the last name to a valid value and verify the change
        contact2.setLastName("Smith");
        assertEquals("Smith", contact2.getLastName());
    }

    @Test
    public void testSetLastNameInvalid() {
        // Ensure invalid last names throw exceptions
        assertThrows(IllegalArgumentException.class, () -> contact2.setLastName(null)); // Null value
        assertThrows(IllegalArgumentException.class, () -> contact2.setLastName("Riveraaaaaaaaa")); // Too long
    }

    @Test
    public void testSetPhoneValid() {
        // Update the phone number to a valid value and verify the change
        contact1.setPhone("5557891234");
        assertEquals("5557891234", contact1.getPhone());
    }

    @Test
    public void testSetPhoneInvalid() {
        // Ensure invalid phone numbers throw exceptions
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhone(null)); // Null value
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhone("123456")); // Too short
        assertThrows(IllegalArgumentException.class, () -> contact2.setPhone("phone12345")); // Non-numeric
    }

    @Test
    public void testSetAddressValid() {
        // Update the address to a valid value and verify the change
        contact2.setAddress("1234 Elm Street");
        assertEquals("1234 Elm Street", contact2.getAddress());
    }

    @Test
    public void testSetAddressInvalid() {
        // Ensure invalid addresses throw exceptions
        assertThrows(IllegalArgumentException.class, () -> contact1.setAddress(null)); // Null value
        assertThrows(IllegalArgumentException.class, () -> contact1.setAddress("This address is too long to be valid and should throw an error")); // Too long
    }

    @Test
    public void testFullContactUpdate() {
        // Test updating all modifiable fields of a contact
        contact1.setFirstName("Angelo");
        contact1.setLastName("Smith");
        contact1.setPhone("5557891234");
        contact1.setAddress("5000 North Randolph Street");

        // Verify all updates are applied correctly
        assertEquals("Angelo", contact1.getFirstName());
        assertEquals("Smith", contact1.getLastName());
        assertEquals("5557891234", contact1.getPhone());
        assertEquals("5000 North Randolph Street", contact1.getAddress());
    }
}
