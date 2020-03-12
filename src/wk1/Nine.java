package wk1;

public class Nine {
    public static void main(String[] args) {
        for (int i = 1; i < 8 ; i++) {
            for (int j = 7; j < 0; j-- ) {
                if (j <= i) {
                    System.out.printf("%d",j);
                }else {
                    System.out.printf("");
                }
            }
        }
    }
}
