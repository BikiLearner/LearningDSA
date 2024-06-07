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


}
