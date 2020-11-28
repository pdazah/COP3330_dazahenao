import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class,()->new ContactItem(" "," "," "," "));
    }

    @Test
    void creationSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem("George","Lucas","321-456-7890"," ");
        assertEquals("George " + "Lucas " + "321-456-7890 " + " ",item.toString());
    }

    @Test
    void creationSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem(" ","Lucas","321-456-7890","email@domain.com");
        assertEquals("  " + "Lucas " + "321-456-789 " + "email@domain.com",item.toString());
    }

    @Test
    void creationSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem("George"," ","321-456-7890","email@domain.com");
        assertEquals("George" + "   " + "321-456-7890 " + "email@domain.com",item.toString());
    }

    @Test
    void creationSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem("George","Lucas"," ","email@domain.com");
        assertEquals("George " + "Lucas " + "  " + "email@domain.com",item.toString());
    }

    @Test
    void creationSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem("George","Lucas","321-456-7890 ","email@domain.com");
        assertEquals("George " + "Lucas " + "321-456-7890 " + " email@domain.com",item.toString());
    }

    @Test
    void editingFailsWithAllBlankValues(){
        ContactItem item = new ContactItem("", "", "321-123-4567", "");
        assertThrows(IllegalArgumentException.class, ()-> item.setPhoneNumber(""));
    }

    @Test
    void editingSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem("George", "Lucas", "321-123-4567", "");
        item.setPhoneNumber("443-345-6543");
        assertEquals("George " + "Lucas " + "443-345-6543 " + "",item.toString());
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem("", "Lucas", "321-123-4567", "email@domain.net");
        item.setEmailAddress("myotheremail@domain.net");
        assertEquals(" " + "Lucas " + "321-123-4567 " + "myotheremail@domain.net",item.toString());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem("George", "", "321-123-4567", "email@domain.net");
        item.setEmailAddress("myotheremail@domain.net");
        assertEquals("George " + " " + "321-123-4567 " + "myotheremail@domain.net",item.toString());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem("George", "Lucas", "", "email@domain.net");
        item.setEmailAddress("myotheremail@domain.net");
        assertEquals("George " + "Lucas " + " " + "myotheremail@domain.net",item.toString());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem("George", "Lucas", "345-789-1243", "email@domain.net");
        item.setEmailAddress("myotheremail@domain.net");
        assertEquals("George " + "Lucas " + "345-789-1243 " + "myotheremail@domain.net",item.toString());
    }
}