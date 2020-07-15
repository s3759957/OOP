package test_file;


class Rectangle {
    double width;
    double height;
    Rectangle(){
        width = 1.0;
        height = 1.0;
    }
    Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return height*width;
    }
    public double getPerimeter() {
        return height*2+2*width;
    }
}
public class Rectangle1 {
    public static void main(String[] args) {
        Rectangle One = new Rectangle(4.0,40.0);
        Rectangle Two = new Rectangle(3.5,35.9);
        System.out.printf("Rectangle One: %.2f - %.2f - %.2f - %.2f\n",One.width,One.height, One.getArea(),One.getPerimeter());
        System.out.printf("Rectangle Two: %.2f - %.2f - %.2f - %.2f",Two.width,Two.height, Two.getArea(),Two.getPerimeter());
    }
}

