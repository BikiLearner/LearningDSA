import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5};
//        RecursionCode.reverseArray(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

        System.out.println(RecursionCode.getTheNthFibonacci(6));

    }

    public static int gcd(int a, int b) {
        if (a <= 0) {
            return b;
        } else if (b <= 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }


}