public class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public String SphereName(){
        return "sphere";
    }

    @Override
    public String getName() {
        return SphereName();
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        return (4.0/3.0)*Math.PI*(radius*radius*radius);
    }
}
