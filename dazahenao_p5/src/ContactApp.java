import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ContactApp {
    private static Scanner input = new Scanner(System.in);
    private ContactList contactList;


    public void run() throws IOException {
        int option = 0;
        do {
            mainMenu();
            try {
                option = input.nextInt();
                switch (option) {
                    case 1:
                        createList();
                        subMenu();
                        break;

                    case 2:
                        loadList();
                        break;
                }
                System.out.println("invalid option, please try again");
            } catch (InputMismatchException err) {
                System.out.println("Invalid input");
                input.nextLine();
            }
        } while (option != 3);
    }


    public void subMenu(){
        mainMenu();
        int option = 0;
        do {
            showOperationsMenu();
            try {
                option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 1:
                        displayItems();
                        break;

                    case 2:
                        addItem();
                        break;

                    case 3:
                        if (contactList.getSize() > 0) {
                            editContact();
                        } else {
                            System.out.println("no contact to edit");
                        }
                        break;

                    case 4:
                        if (contactList.getSize() > 0) {
                            removeContact();
                        } else {
                            System.out.println("no contacts to remove");
                        }
                        break;

                    case 5:
                        if (contactList.getSize() > 0) {
                            saveList();
                        } else {
                            System.out.println("no contacts to save");
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option, please try again");
            }
        } while (option!=6);
    }


    private void createList() {
        contactList = new ContactList();
        System.out.println("New task list has been created");
    }

    public void loadList() {
        System.out.println("enter file name to load");
        String fileName = input.nextLine();
        contactList = new ContactList();
        contactList.load(fileName);
        System.out.println("task has been loaded");
    }

    private void saveList() {
        if (contactList.getSize() > 0) {
            System.out.println("enter file name to save as: ");
            String filename = input.nextLine();
            contactList.save(filename);
            System.out.println("contact list has been saved");
        } else {
            System.out.println("no contacts to save");
        }
    }


    private void removeContact() {
        contactList.printList();
        System.out.println("which contact will your remove? ");
        int index = input.nextInt();
        input.nextLine();
        if(index < contactList.getSize()){
            contactList.remove(index);
        } else {
            System.out.println("Invalid contact number");
        }
    }


    private void editContact() {
        contactList.printList();
        System.out.println("which contact will your edit? ");
        int index = input.nextInt();
        input.nextLine();

        if(index < contactList.getSize()) {
            System.out.printf("enter new first name for contact%d: ", index);
            String firstName = input.nextLine();
            System.out.printf("enter new second name for contact%d: ", index);
            String secondName = input.nextLine();
            System.out.printf("enter new phone number for contact%d: ", index);
            String phoneNumber = input.nextLine();
            System.out.printf("enter new email address for contact%d: ", index);
            String emailAddress = input.nextLine();
            try {
                contactList.update(index, firstName, secondName, phoneNumber,emailAddress);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else{
            System.out.println("invalid entry");
        }
    }


    private void addItem() {
        System.out.println("First name: ");
        String firstName = input.nextLine();
        System.out.println("Second name: ");
        String secondName = input.nextLine();
        System.out.println("Phone number: ");
        String phoneNumber = input.nextLine();
        System.out.println("Email address: ");
        String emailAddress = input.nextLine();
        try {
            contactList.add(new ContactItem(firstName,secondName,phoneNumber,emailAddress));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private void displayItems() {
        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println(contactList.printList());
    }


    private void mainMenu(){
        System.out.println("Main Menu\n");
        System.out.println("---------\n");
        System.out.println("1) Create a new list\n");
        System.out.println("2) Load existing list\n");
        System.out.println("3) quit");
    }

    private void showOperationsMenu(){
        System.out.println("List Operation Menu\n");
        System.out.println("-------------------\n");
        System.out.println("1) view the list\n");
        System.out.println("2) add a contact\n");
        System.out.println("3) edit a contact\n");
        System.out.println("4) remove a contact\n");
        System.out.println("5) save the current list\n");
        System.out.println("6) quit to the main menu\n");
    }
}
