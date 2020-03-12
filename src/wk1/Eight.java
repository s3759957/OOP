package wk1;

public class Eight {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i < 201; i ++) {
            if (i % 5 == 0) {
                if (i % 6 != 0) {
                    System.out.print(i + " ");
                    count ++;
                }
                if (count % 10 == 0) {
                    System.out.println();
                    count = 0 ;
                }
            }
            else if (i % 6 == 0) {
                if (i % 5 != 0) {
                    System.out.print(i + " ");
                    count ++;
                }
                if (count % 10 == 0) {
                    System.out.println();
                    count = 0 ;
                }
            }

        }
    }
}
