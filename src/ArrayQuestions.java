import java.util.*;

public class ArrayQuestions {
    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }
        System.out.println("Total Array" + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Total Array" + Arrays.toString(a));

        int uniqueN=removeDuplicate(a);
        System.out.println(uniqueN);
        System.out.println("Unique Elements");
        for(int i=0;i<uniqueN;i++){
            System.out.print(a[i]+", ");
        }
    }

    public static int largestElementInArray(int[] arr) {
        //Brute force solution
//        Arrays.sort(arr);
//        return arr[arr.length-1];


        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int secondLargestElementInArray(int[] arr) {

        //Brute force solution O(nlog n + n)
//        Arrays.sort(arr);
//        int largestElement=arr[arr.length-1];
//        int secondLarge=-1;
//        for(int i=arr.length-2;i>=0;i--){
//            if(arr[i]!=largestElement){
//                secondLarge=arr[i];
//                break;
//            }
//        }
//        return secondLarge;

        //Better solution O(2n)
//        int largest=arr[0];
//        for (int j : arr) {
//            if (largest < j) {
//                largest = j;
//            }
//        }
//        int secondLarge=-1;
//        for(int i : arr){
//            if(i>secondLarge && i!=largest){
//                secondLarge=i;
//            }
//        }
//
//        return secondLarge;
        //optimal solution O(n)
        int largest = arr[0], second = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > second) {
                second = arr[i];
            }
        }
        int[] ar2 = {1, 2};
        return second;


    }
    public  int secondSmallestElement(int []a){

        int sSmallest=Integer.MAX_VALUE;
        int smallest=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<smallest){
                sSmallest=smallest;
                smallest=a[i];
            }else if(a[i]!=smallest && a[i]<sSmallest){
                sSmallest=a[i];
            }
        }
        return sSmallest;
    }

    public static boolean checkArraySortedOrNot(int []a){
        for (int i=1;i<a.length;i++){
            if(a[i-1]>a[i]){
                return false;
            }
        }
        return true;
    }
    public static int removeDuplicate(int []arr){
        //Brute force O(nlog n + n) SC-> O(n)
//        Set<Integer> noDuplicate=new HashSet<>();
//        for(int i=0;i<arr.length;i++){
//            noDuplicate.add(arr[i]);
//        }
//        int index=0;
//        for (int a : noDuplicate){
//            arr[index++]=a;
//        }
//        return index;

        int i=0;
        for (int j=1;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return (i+1);
    }
}
