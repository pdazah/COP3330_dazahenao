import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    //create a menu to call ContactApp ot TaskApp
    private static final Scanner input = new Scanner(System.in);

    private static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }

    public void run() {
        int option = -1;

        while (true) {
            showAppSelectMenu();
            try {
                option = getMenuOption();
                switch (option){
                    case 1:
                        ContactApp contactApp = new ContactApp();
                        contactApp.execute();
                        break;

                    case 2:
                        TaskApp taskApp =  new TaskApp();
                        taskApp.execute();
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }catch(InputMismatchException err){ System.out.println("Invalid input");
            }
        }
    }

    private int getMenuOption() {
        return input.nextInt();
    }

    private void showAppSelectMenu () {
        System.out.println("Select your application");
        System.out.println("-----------------------");
        System.out.println("1) task list\n");
        System.out.println("2) contact list\n");
        System.out.println("3) quit");
    }

}

