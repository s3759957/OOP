package wk1;

public class number {
    public static void main(String[] args) {
//        int[] arr1 = new int[10];
//        double a = 1.61 ;
        System.out.printf("\tMiles\tKilometers\tKilometers\tMiles\n");
        for (int i = 1; i < 11; i ++) {

            System.out.printf("%5d\t%10.2f\t|\t%10d\t%10.2f\n", i, i*1.61, 15+5*i, (15+5*i)*(1/1.61));
        }

    }
}
