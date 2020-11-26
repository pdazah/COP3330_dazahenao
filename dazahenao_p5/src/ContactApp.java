import java.util.InputMismatchException;
import java.util.Scanner;


public class ContactApp {
    private static Scanner input = new Scanner(System.in);
    ContactApp contactApp = new ContactApp();
    private ContactList contactList;

    void execute(){
        mainMenu();
        int option = -1;
        while (true) {
            mainMenu();
            try {
                option = input.nextInt();
                switch (option){
                    case 1:
                        displayItems();

                    case 2:
                        addItem();

                    case 3:
                        if(contactList.getSize() > 0){
                            editItem();
                        } else {
                            System.out.println("no contact to edit");
                        }

                    case 4:
                        if(contactList.getSize() > 0){
                            removeItem();
                        } else {
                            System.out.println("no contacts to remove");
                        }

                    case 6:
                        if(contactList.getSize() > 0) {
                            saveList();
                        }else {
                            System.out.println("no contacts to save");
                        }

                    case 7: break;


                    default: System.out.println("Invalid input");
                        break;


                }

            }catch(InputMismatchException e){
                System.out.println("Invalid option");

            }

        }

    }

    private void saveList() {


    }

    private void removeItem() {


    }

    private void editItem() {


    }

    private void addItem() {


    }


    private void displayItems() {
        System.out.println("Current Contacts");
        System.out.println("-------------");
        //System.out.println(contactList.printList());
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
        System.out.println("2) add an item\n");
        System.out.println("3) edit an item\n");
        System.out.println("4) remove an item\n");
        System.out.println("5) save the current list\n");
        System.out.println("6) quit to the main menu\n");
    }
}
