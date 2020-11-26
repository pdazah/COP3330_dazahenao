import java.util.InputMismatchException;
import java.util.Scanner;


public class TaskApp {
    TaskApp taskApp = new TaskApp();
    private static Scanner input = new Scanner(System.in);
    private TaskList taskList;

    void execute() {
        int option;
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
                        if(taskList.getSize() > 0){
                            editItem();
                        } else {
                            System.out.println("no task to edit");
                        }

                    case 4:
                        if(taskList.getSize() > 0){
                            removeItem();
                        } else {
                            System.out.println("no task to remove");
                        }

                    case 5:
                        if(taskList.getSize() > 0){
                            markAsComplete();
                        } else {
                            System.out.println("no tasks to mark");
                        }

                    case 6:
                        if(taskList.getSize() > 0){
                            unMarkAsComplete();
                        } else {
                            System.out.println("no tasks to unmark");
                        }

                    case 7:
                        if(taskList.getSize() > 0) {
                            saveList();
                        }else {
                            System.out.println("no tasks to save");
                        }

                    case 8:


                    default: System.out.println("Invalid input");
                        break;


                }

            }catch(InputMismatchException e){
                System.out.println("Invalid option, please try again");

            }

        }

    }

    private void displayItems() {
        System.out.println("Current tasks");
        System.out.println("-------------");
        System.out.println(taskList.printList());
    }

    private void saveList() {


    }

    private void unMarkAsComplete() {
        taskList.printList();
        System.out.println("which task will you mark as complete? ");
        int index = input.nextInt();
        if(index >= taskList.getSize()) {
            System.out.println("Invalid task number");
        } else if(!taskList.getItem(index).isComplete()){
            System.out.println("Task is already complete");
        } else {
            taskList.complete(index,false);
        }

    }

    private void markAsComplete() {
        taskList.printList();
        System.out.println("which task will you mark as complete? ");
        int index = input.nextInt();
        if(index >= taskList.getSize()) {
            System.out.println("Invalid task number");
        } else if(taskList.getItem(index).isComplete()){
            System.out.println("Task is already complete");
        } else {
            taskList.complete(index,true);
        }
    }

    private void removeItem() {
        taskList.printList();
        System.out.println("which task will your remove? ");
        int index = input.nextInt();
        input.nextLine();
        if(index >= taskList.getSize()){
            taskList.remove(index);
        } else {
            System.out.println("Invalid task number");
        }
    }

    private void editItem() {
        taskList.printList();
        System.out.println("which task will your edit? ");
        int index = input.nextInt();
        input.nextLine();

        if(index < taskList.getSize()) {
            System.out.printf("enter new title for task%d: ", index);
            String title = input.nextLine();
            System.out.printf("enter new description for task%d: ", index);
            String description = input.nextLine();
            System.out.printf("enter new due date for task%d: ", index);
            String dueDate = input.nextLine();
            try {
                taskList.update(index, title, description, dueDate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else{
            System.out.println("invalid entry");
        }
    }

    private void addItem() {
        System.out.println("Task title: ");
        String title = input.nextLine();
        System.out.println("Task description: ");
        String description = input.nextLine();
        System.out.println("Task due date: ");
        String dueDate = input.nextLine();
    }



    public void mainMenu(){
        System.out.println("Main Menu\n");
        System.out.println("---------\n");
        System.out.println("1) Create a new list\n");
        System.out.println("2) Load existing list\n");
        System.out.println("3) quit");
    }


    protected void showOperationsMenu(){
        System.out.println("List Operation Menu\n");
        System.out.println("-------------------\n");
        System.out.println("1) view the list\n");
        System.out.println("2) add an item\n");
        System.out.println("3) edit an item\n");
        System.out.println("4) remove an item\n");
        System.out.println("5) mark an item as completed\n");
        System.out.println("6) unmark an item as completed\n");
        System.out.println("7) save the current list\n");
        System.out.println("8) quit to the main menu\n");
    }

}
