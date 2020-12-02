import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    private ContactItem contactItem;
    ContactList tempList = new ContactList();

    @Test
    public void addingItemsIncreasesSize(){
        ContactList tempList = new ContactList();
        ContactItem item = new ContactItem("Steven", "Spielberg", "441-234-5423", "email@domain.com");
        assertEquals(tempList.getSize(), 0);
        tempList.add(item);
        assertEquals(tempList.getSize(), 1);
    }


    @Test
    public void editingItemsFailsWithAllBlankValues(){
        contactItem = new ContactItem("Steven","Spielberg","441-234-5423","email@domain.net");
        tempList.add(contactItem);
        assertThrows(IllegalArgumentException.class,()->tempList.update(0,"","","",""));
    }


    @Test
    public void editingSucceedsWithBlankFirstName(){
        contactItem = new ContactItem("","Spielberg","441-234-5423","email@domain.net");
        contactItem.setPhoneNumber("432-234-4312");
        assertEquals(contactItem.getPhoneNumber(),"432-234-4312");
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        contactItem = new ContactItem("Steven","Spielberg","441-234-5423","email@domain.net");
        contactItem.secondName = "";
        assertEquals(contactItem.getSecondName(),"");
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        contactItem = new ContactItem("Steven","Spielberg","441-234-5423","email@domain.net");
        contactItem.phoneNumber = "";
        assertEquals(contactItem.getPhoneNumber(),"");
    }


    @Test
    public void editingSucceedsWithNonBlankValues(){
        contactItem = new ContactItem("Steven","Spielberg","441-234-5423","email@domain.net");
        contactItem.firstName = "Marcus";
        assertEquals(contactItem.getFirstName(),"Marcus");
    }


    @Test
    public void removingItemsDecreasesSize(){
        ContactList tempList = new ContactList();
        ContactItem i = new ContactItem("Steven", "Spielberg", "441-234-5423", "email@domain.com");
        tempList.add(i);
        assertEquals(tempList.getSize(), 1);
        tempList.remove(0);
        assertEquals(tempList.getSize(), 0);
    }


    @Test
    public void savedContactListCanBeLoaded(){


    }

}