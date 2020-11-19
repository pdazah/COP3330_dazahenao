import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        List<TaskItem> taskItems = new ArrayList<>();


        int selection = 0;
        while (selection != 3) {
            try {
                selection = showMainMenu();
                switch (selection) {
                    case 1:
                        System.out.println("New task list has been created");
                        //TaskList.listOperationsMenu();

                    case 2:
                        //TaskList.loadList();

                    case 3:

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again");

            }

        }
    }
        public static int showMainMenu() {
            Scanner input = new Scanner(System.in);
            System.out.print("\n"
                    + "Main Menu\n"
                    + "---------\n"
                    + " 1) Create a new list\n"
                    + " 2) Load existing list\n"
                    + " 3) Quit\n");
            int choice1 = input.nextInt();
            return choice1;

        }



    }






