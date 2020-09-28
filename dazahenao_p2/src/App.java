import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static double accumulator = 0d;//variable used in BMI average calculation

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();
        while (moreInput()) {
        double height = getUserHeight();
        double weight = getUserWeight();

        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        bmiData.add(bmi);
        displayBmiInfo(bmi);
        }
    displayBmiStatistics(bmiData);
    }


    public static boolean moreInput() {
        char c='P';
        while(!(c=='y' || c=='Y' || c=='N' || c=='n')){ //validates only 'y' or 'n' are entered
        System.out.println("Press 'Y' to continue or 'N' to exit ");
        Scanner sc = new Scanner(System.in);
        c = Character.toUpperCase(sc.next().charAt(0));}
        return ((c == 'Y') || (c == 'y'));
    }


    public static double getUserHeight() {
        Scanner console = new Scanner(System.in);
        double height;
        do {
            System.out.println("height (in inches)? ");
            height = console.nextDouble();
            if(height<=0){
                System.out.println("Please enter a positive number!");
        }
        } while (height <= 0);
        return height;
    }


    public static double getUserWeight() {
        Scanner console = new Scanner(System.in);
        double weight;
        do{
            System.out.println("weight (in pounds)? ");
            weight = console.nextDouble();
            if(weight<=0){
                System.out.println("Please enter a positive number!");
            }
        } while (weight <= 0);
        return weight;
    }


    public static void displayBmiInfo(BodyMassIndex bmi) {
        double score = bmi.bmiScoreCalc();
        System.out.printf("%s%.1f\n","BMI Score: ",score);
        bmi.bmiCategory();
        accumulator += score; //value used to calculate BMI average
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        System.out.printf("%s%.1f","Average BMI Score: ",accumulator/ bmiData.size());
    }
}