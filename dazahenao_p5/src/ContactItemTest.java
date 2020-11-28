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

    /*@Test
    void editingFailsWithAllBlankValues(){
        ContactItem item = new ContactItem("", "", "", "");
        assertThrows(IllegalArgumentException.class, ()-> item.setFirstName(""));
    }*/


}