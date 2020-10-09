public class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public String CubeName(){
        return "cube";
    }

    @Override
    public String getName() {
        return CubeName();
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(side, 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

}
