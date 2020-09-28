public class BodyMassIndex{
    public double height; //Instance variables
    public double weight;


    public BodyMassIndex(double height2, double weight2){ //Constructor
        this.height = height2;
        this.weight = weight2;
    }


    public double bmiScoreCalc(){ //Calculates BMI Score
        double bmiScore = ((703*this.weight) / (this.height*this.height));
        return bmiScore;
    }


    public void bmiCategory(){ //Compares BMI with standards and displays category
        if (bmiScoreCalc() < 18.5) {
            System.out.println("Category: underweight \n");
        } else if (bmiScoreCalc() < 25) {
            System.out.println("Category: normal \n");
        } else if (bmiScoreCalc() < 30) {
            System.out.println("Category: overweight \n");
        } else {
            System.out.println("Category: obese \n");
        }
    }
}
