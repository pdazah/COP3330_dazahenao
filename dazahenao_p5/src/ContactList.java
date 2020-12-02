import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;



public class ContactList {
   // private static final Scanner input = new Scanner(System.in);
    List<ContactItem> contactItems;

    public ContactList() {
        this.contactItems = new ArrayList<>();
    }

    public void add(ContactItem item) {
        contactItems.add(item);
    }

    public void remove(int index) {
        contactItems.remove(index);
    }

    public void update(int index,String firstName, String secondName, String phoneNumber, String emailAddress) {
        if (!(index == (int)index) && index>=0){
            throw new IllegalArgumentException("Invalid index, please try again");
        } else if (firstName.isBlank() && secondName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank())
            {
                throw new IllegalArgumentException("Invalid entry, all fields are empty");
            } else
                this.getItem(index).update(firstName, secondName, phoneNumber, emailAddress);
   }

    public ContactItem getItem(int index) {
        return contactItems.get(index);
    }

    public int getSize() {
        return contactItems.size();
    }


    //this method will open the file for reading
    public void load(String fileName) {
        List<ContactItem> tempList = contactItems;
        contactItems = new ArrayList<>();
        try(Scanner input = new Scanner(Paths.get(fileName))){
            String defaultName = input.nextLine();
            if (defaultName.equalsIgnoreCase("contacts")) {
                while (input.hasNext()) {
                    String firstName = input.nextLine();
                    String secondName = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String emailAddress = input.nextLine();
                    ContactItem contactItem = new ContactItem(firstName, secondName, phoneNumber, emailAddress);
                    this.add(contactItem);
                }
            }else {
                contactItems = tempList;
                throw new InputMismatchException("filename is not a TaskList, loading failed.");
            }
        } catch (FileNotFoundException ex) {
            contactItems = tempList;
            throw new IllegalArgumentException("file not found, loading failed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public void save(String fileName) {
        try(Formatter output = new Formatter(fileName)) {
            output.format("contacts%n");
            for (ContactItem contactItem : contactItems) {
                output.format("%s%n", contactItem.getFirstName());
                output.format("%s%n", contactItem.getSecondName());
                output.format("%s%n", contactItem.getPhoneNumber());
                output.format("%s%n", contactItem.getEmailAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String printList() {
        StringBuilder sb = new StringBuilder();
        ContactItem item;
        for (int i = 0; i < this.getSize(); i++) {
            item = this.getItem(i);
            sb.append(String.format("%d) %s%n", i, item));
        }
        return sb.toString();
    }
}