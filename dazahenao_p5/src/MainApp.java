import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    //create a menu to call ContactApp ot TaskApp
    private static final Scanner input = new Scanner(System.in);
    private ContactApp contactApp;
    private TaskApp taskApp = new TaskApp();
    public static MainApp app = new MainApp();


    public static void main(String[] args) {
        app.run();
    }


    public void run() {
        int option = 0;
        do {
            showAppSelectMenu();
            try {
                option = input.nextInt();
                switch (option) {
                    case 1:
                        TaskApp run = new TaskApp();
                        run.execute();
                        break;

                    case 2:
                        ContactApp run1 = new ContactApp();
                        run1.run();
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (InputMismatchException | IOException err) {
                System.out.println("Invalid input");
                input.nextLine();
            }
        }while(option!=3);
    }


    private void showAppSelectMenu() {
        System.out.println("Select your application\n");
        System.out.println("-----------------------\n");
        System.out.println("1) task list\n");
        System.out.println("2) contact list\n");
        System.out.println("3) quit");
    }
}