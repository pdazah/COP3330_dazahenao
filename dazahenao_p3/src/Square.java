public class Square extends Shape2D{
    private double side;
    public Square(double side) {
        this.side = side;
    }

    public String SquareName(){
        return "square";
    }

    @Override
    public String getName() {
        return SquareName();
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getVolume() {
        return 0;
    }
}
