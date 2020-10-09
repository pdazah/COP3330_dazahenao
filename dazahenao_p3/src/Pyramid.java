public class Pyramid extends Shape3D {
    private double width, height, length = 0d;
    public Pyramid(double width, double length,double height){
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public String PyramidName(){
        return "pyramid";
    }

    @Override
    public String getName() {
        return PyramidName();
    }

    @Override
    public double getArea() {
    return (length * width) + (length * Math.sqrt(Math.pow(width / 2, 2) +
            Math.pow(height, 2))) + (width * Math.sqrt(Math.pow(length / 2, 2) + Math.pow(height, 2)));
    }

    @Override
    public double getVolume() {
        return (width * height * length)/3;
    }
}
