import java.util.Arrays;

public class doubleUp {
    public static void main(String[] args) {
        int [] arg= { 1,2,3};

         doubleUp(arg);

        System.out.println(Arrays.toString(arg));

    }
    public static void doubleUp(int[] arr){
//        for (int i = 0; i < arr.length; i ++){
//            arr[i] = arr[i] * 2;
//        }
        for (int elt: arr){
            elt = elt * 2;
        }
    }
}
