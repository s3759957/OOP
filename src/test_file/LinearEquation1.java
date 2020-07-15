package test_file;

import java.util.Scanner;

class LinearEquation {
    private double a ,b, c, d, e, f;
    LinearEquation(double[] arr){
        this.a = arr[0];
        this.b = arr[1];
        this.c = arr[2];
        this.d = arr[3];
        this.e = arr[4];
        this.f = arr[5];
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }
    public boolean isSolvable() {
        if (a*d-b*c != 0) {
            return true;
        } else return false;
    }
    public double getX() {
        return (e*d-b*f)/(a*d-b*c);
    }
    public double getY() {
        return (a*f-e*c)/(a*d-b*c);
    }

}
public class LinearEquation1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double [] arr = new double[6];
        System.out.print("Enter a, b, c, d, e, f respectively with space in-between: ");
        for (int i = 0; i < 6; i ++){
            arr[i] = input.nextDouble();
        }
        LinearEquation equation = new LinearEquation(arr);
        if (equation.isSolvable() == false) {
            System.out.println("The equation has no solution !!!");
        } else {
            System.out.println("X = "+ equation.getX());
            System.out.println("y = "+ equation.getY());
        }
    }
}
