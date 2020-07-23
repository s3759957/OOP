//import java.util.Scanner;
//
////public class Week1 {
////    public static void main(String[] args) {
////        int count = 0;
////        for (int i = 100; i < 201; i++) {
////
////            if (i % 5 == 0) {
////                if (i % 6 == 0) {
////                    continue;
////                } else {
////                    count ++;
////                    System.out.print(i + " ");
////                    if (count % 10==0){
////                        System.out.println();
////                    }
////                }
////            } else if (i % 6 == 0) {
////                if (i % 5 == 0) {
////                    continue;
////                } else {
////                    count ++;
////                    System.out.print(i + " ");
////                    if (count % 10==0){
////                        System.out.println();
////                    }
////                }
////            }
////
////        }
////    }
////}
////public class Week1{
////    public static void main(String[] args) {
////        int t =1;
////        System.out.println("  Miles\t  Kilometers\t|\tKilometers\tMiles");
////        for (int i = 1; i<11;i++){
////            System.out.printf("\t%2d\t\t\t%5.2f\t\t|\t\t %2d\t\t%4.2f\n",i,i*1.609,i*5+15,(i*5+15)*(12.43/20));
////        }
////
////    }
////}
//public class Week1{
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the number of lines: ");
//        int num = input.nextInt();
//        for (int i = 1;i<num+1;i++){
//            System.out.print("\t\t\t");
//            for (int j = num; j > 0;j--) {
//                if (j <= i ){
//                    System.out.print(j+"\t");
//                }else System.out.print("\t");
//            }
//            for (int j = 2; j < num +1;j++) {
//                if (j <= i ){
//                    System.out.print(j+"\t");
//                }else System.out.print("\t");
//            }
//            System.out.println();
//        }
//
//    }
//}
