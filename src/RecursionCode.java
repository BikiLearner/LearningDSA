// Recursion tree


public class RecursionCode {

    public static int printName(int nTimes){
        if(nTimes==0){
            return 1;
        }

        return nTimes * printName(nTimes-1);
    }
    public static void reverseArray(int []arr,int i,int j){
        if(i>=j){
            return;
        }
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        reverseArray(arr,i+1,j-1);
    }

    public static int sumOfNNumbers(int n){
        if(n==0){
            return 0;
        }
        return sumOfNNumbers(n-1)+n;
    }

    public static boolean checkPalindrome(String str,int i,int len){
        if(i>=len/2){
            return true;
        }else if(str.charAt(i)!=str.charAt(len-i-1)){
            return false;
        }else {
            return checkPalindrome(str,i+1,len);
        }
    }


    // TC -> 2^n exponential TC
    public static int getTheNthFibonacci(int n){
        if(n<=1){
            return n;
        }
        return getTheNthFibonacci(n-1)+getTheNthFibonacci(n-2);
    }


    public static double myPow(double x, int n) {
        if(n == 0) return x;
        return x * myPow(x,n-1);
    }
    public static void main(String [] args){
        System.out.println(myPow(2,-2));
    }


}
