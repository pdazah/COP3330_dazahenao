import java.util.InputMismatchException;
import java.util.Scanner;


public class TaskApp {
    private static Scanner input = new Scanner(System.in);
    private TaskList taskList;


    public void execute() {
        int option = 0;
        do {
            mainMenu();
              option = input.nextInt();
                switch (option) {
                    case 1:
                        createList();
                        subMenu();
                        break;

                    case 2:
                        try {
                             loadList();
                             subMenu();
                        } catch (IllegalArgumentException | InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
                if(option!=1 && option!=2 && option!=3){
                    System.out.println("invalid option, please try again");
                }
        } while (option != 3);
    }


    private void createList() {
        taskList = new TaskList();
        System.out.println("New task list has been created");
    }


    private void loadList() {
        System.out.println("enter file name to load");
        String fileName = input.next();
        taskList = new TaskList();
        taskList.load(fileName);
        System.out.println("task has been loaded");
        }


    public void subMenu(){
        int option = 0;
        do {
            showOperationsMenu();
            try {
                option = input.nextInt();
                input.nextLine();
                switch (option){
                    case 1:
                        displayItems();
                        break;

                    case 2:
                        addItem();
                        break;

                    case 3:
                        if(taskList.getSize() > 0){
                            editItem();
                        } else {
                            System.out.println("no task to edit");
                        }
                        break;

                    case 4:
                        if(taskList.getSize() > 0){
                            removeItem();
                        } else {
                            System.out.println("no task to remove");
                        }
                        break;

                    case 5:
                        if(taskList.getSize() > 0){
                            markAsComplete();
                        } else {
                            System.out.println("no tasks to mark");
                        }
                        break;

                    case 6:
                        if(taskList.getSize() > 0){
                            unMarkAsComplete();
                        } else {
                            System.out.println("no tasks to unmark");
                        }
                        break;

                    case 7:
                        if(taskList.getSize() > 0) {
                            saveList();
                        }else {
                            System.out.println("no tasks to save");
                        }
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid option, please try again");
            }
        }while(option!=8);
    }


    private void displayItems() {
        System.out.println("Current tasks");
        System.out.println("-------------");
        System.out.println(taskList.printList());
    }


    private void saveList() {
        if (taskList.getSize() > 0) {
            System.out.println("enter file name to save as: ");
            String filename = input.nextLine();
            taskList.save(filename);
            System.out.println("task list has been saved");
        } else {
            System.out.println("no task to save");
        }
    }


    private void unMarkAsComplete() {
        showCompletedItems();
        System.out.println("which task will you mark as complete? ");
        int index = input.nextInt();
        if(index >= taskList.getSize()) {
            System.out.println("Invalid task number");
        } else if(!taskList.getItem(index).isComplete()){
            System.out.println("Task is already incomplete");
        } else {
            taskList.taskComplete(index,false);
        }
    }


    private void markAsComplete() {
        showUncompletedItems();
        System.out.println("which task will you mark as complete? ");
        int index = input.nextInt();
        if(index >= taskList.getSize()) {
            System.out.println("Invalid task number");
        } else if(taskList.getItem(index).isComplete()){
            System.out.println("Task is already complete");
        } else {
            taskList.taskComplete(index,true);
        }
    }


    private void showCompletedItems() {
        System.out.println("completed tasks");
        System.out.println("---------------");
        System.out.println();
        System.out.println(taskList.viewCompletedTasks());
        System.out.println();
    }


    private void showUncompletedItems() {
        System.out.println("completed tasks");
        System.out.println("---------------");
        System.out.println();
        System.out.println(taskList.viewUncompletedTasks());
        System.out.println();
    }


    private void removeItem() {
        taskList.printList();
        System.out.println("which task will your remove? ");
        int index = input.nextInt();
        input.nextLine();
        if(index < taskList.getSize()){
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
            System.out.printf("enter new due date (YYYY-MM-DD) for task%d: ", index);
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
        try {
            taskList.add(new TaskItem(title,description,dueDate));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public void mainMenu(){
        System.out.println("Main Menu\n");
        System.out.println("---------\n");
        System.out.println("1) Create a new list\n");
        System.out.println("2) Load existing list\n");
        System.out.println("3) quit");
        System.out.println(">");
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
        System.out.println(">");;
    }
}
