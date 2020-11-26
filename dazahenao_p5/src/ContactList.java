import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactList {
    private static Scanner input = new Scanner(System.in);
    private List<ContactItem> contactItems;

    public ContactList(){
        this.contactItems = new ArrayList<ContactItem>();
    }

    public void add(ContactItem item) {
        contactItems.add(item);
    }

    public void remove(int index){
        contactItems.remove(index);
    }

    public ContactItem getItem(int index){
        return contactItems.get(index);
    }

    public int getSize(){
        return contactItems.size();
    }

}

