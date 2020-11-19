import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class TaskList{

    private static Scanner input = new Scanner(System.in);

    List<TaskItem> taskItemList;

    public TaskList() {
        taskItemList = new ArrayList<>();
    }

    public TaskItem get(int index) {
        return taskItemList.get(index);
    }

    public void add(TaskItem item) {
        taskItemList.add(item);
    }


    public void listOperationsMenu() {
        int option = 0;
        while (option != 8) {
            try {
                System.out.print("\n"
                        + " 1) View the list\n"
                        + " 2) Add an item\n"
                        + " 3) Edit an item\n"
                        + " 4) Remove an item\n"
                        + " 5) Mark an item as completed\n"
                        + " 6) Unmark an item as completed\n"
                        + " 7) Save current list\n"
                        + " 8) Quit to main menu\n\n");
                option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 1:
                        listCurrentTask();
                        break;

                    case 2:
                        System.out.println("2");
                        createItem();
                        break;

                    case 3:
                        System.out.println("3");
                        modifyItem();
                        break;

                    case 4:
                        System.out.println("4");
                        //removeItem();
                        break;

                    case 5:
                        System.out.println("5");
                        //markAsComplete();
                        break;

                    case 6:
                        System.out.println("6");
                        //unmarkAsComplete();
                        break;

                    case 7:
                        System.out.println("Enter the filename to save as: ");
                        String name = input.nextLine();
                        //write(name);
                        break;

                    case 8:
                        break;
                }

            } catch (Exception exception) {
                System.out.println("Please enter a valid choice!!!");
            }
        }
    }


    protected void createItem() {

        String title, description, duedate;
        boolean complete = false;
        System.out.println("title: ");
        title = input.nextLine();
        System.out.println("description: ");
        description = input.nextLine();
        System.out.println("due date: ");
        duedate = input.nextLine();
        System.out.println("completed: false");
        taskItemList.add(new TaskItem(title, description, duedate, false));
    }


    protected void modifyItem() {
        String title, description, duedate;
        boolean complete = false;
        int index = 0;
        System.out.println("Which task will you edit ");
        index = input.nextInt();
        System.out.println("Enter new title for task " + index);
        title = input.nextLine();
        System.out.println("Enter a new description for task " + index);
        description = input.nextLine();
        System.out.println("Enter a new task due date for task " + index);
        duedate = input.nextLine();
        taskItemList.add(index, new TaskItem(title, description, duedate, complete));
    }


    public void unmarkAsComplete(int index) {
        taskItemList.get(index).setItemCompleted(false);
        //Use comparator
    }

    public void markAsComplete(int index) {
        taskItemList.get(index).setItemCompleted(true);
    }

    public void removeItem() {
        System.out.println("Deleting item");
    }

    protected void listCurrentTask() {
        System.out.print("Current task");
        System.out.println("------------\n");
        for (int i = 0; i < taskItemList.size(); i++) {
            System.out.println(taskItemList.get(i));
        }

    }

    public void loadList() throws IOException {
        String filename;
        System.out.println("Enter the file name to load");
        filename = input.nextLine();
        input = new Scanner(Paths.get(filename));{
            while(input.hasNext()){
                for(int i =0;i<taskItemList.size();i++){}


            }
        }
        listOperationsMenu();
    }


    public void createList(String filename) {

        try {
            File output = new File(filename);
            if (output.createNewFile()) {
                System.out.println("new task list has been created\n");
                listOperationsMenu();
            } else {
                System.out.println("File Already Exists");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}






