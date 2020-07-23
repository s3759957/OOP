//public class Run {
//    public static void main(String[] args) {
//        Human AJ = new Human();
//        Human JK = new Human ();
//        System.out.println(AJ.numOfHuman);
//        int num = AJ.getNumOfHuman();
//    }
//}

//public class Run {
//    public static void main(String[] args) {
//        int[] a = {1, 2};
//        swap(a);
//        System.out.println("a[0] = " + a[0] + " a[1] = " + a[1]);
//    }
//
//    public static void swap(int[] b) {
//        int temp = b[0];
//        b[0] = b[1];
//        b[1] = temp;
//    }
//}
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}

class B extends Circle {
    private double length;

    B(double radius, double length) {
        super(radius);
        this.length = length;
    }

    public double getArea() {
        return super.getArea() * length;
    }
}

public class Run {
    public static void main(String[] args) {
        B c = new B(3,4);
        System.out.println(c.getArea());

    }
}