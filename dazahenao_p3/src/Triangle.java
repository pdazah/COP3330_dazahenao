public class Triangle extends Shape2D{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public String TriangleName(){
        return "triangle";
    }

    @Override
    public String getName() {
        return TriangleName();
    }

    @Override
    public double getArea() {
        return base * height / 2;
    }

    @Override
    public double getVolume() {
        return 0;
    }


}
