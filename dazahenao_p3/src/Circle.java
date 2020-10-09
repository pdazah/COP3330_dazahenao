public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public String CircleArea(){
        return "circle";
    }

    @Override
    public String getName() {
        return CircleArea();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return 0;
    }
}
