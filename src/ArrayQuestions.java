import java.util.*;

public class ArrayQuestions {


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

    public int secondSmallestElement(int[] a) {

        int sSmallest = Integer.MAX_VALUE;
        int smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < smallest) {
                sSmallest = smallest;
                smallest = a[i];
            } else if (a[i] != smallest && a[i] < sSmallest) {
                sSmallest = a[i];
            }
        }
        return sSmallest;
    }

    public static boolean checkArraySortedOrNot(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int removeDuplicate(int[] arr) {
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

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return (i + 1);
    }

    public static void leftRotateArrayByOnePlace(int[] arr, int start) {
        //tc -> O(n)
        //SC-> O(1)
        // if some one says extra space then O(1)
        // if some say space use in algo O(n) due to the array use
        int temp = arr[start];
        int i;
        for (i = start; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    public static ArrayList<Integer> leftRotateArrayByDPlace(int[] a, int D) {
        //USE SET IN ARRAY LIST TO SET VALUE TO CERTAIN INDEX
        // DON't use add

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : a) {
            arr.add(i);
        }
        System.out.println(D);
        int iterationCount = 0;
        for (int j = 1; j <= (D % arr.size()); j++) {
            System.out.println(++iterationCount);
            int temp = arr.getFirst();
            int i = 0;
            for (; i < arr.size() - 1; i++) {

                arr.set(i, arr.get(i + 1));
            }
            arr.set(i, temp);
        }
        return arr;
    }

    public void rotate(int[] nums, int k) {
        //O(n)
        // sc -> O(d);
        int n = nums.length;
        // System.out.println(n);
        // int d=(k % n);
        // System.out.println(d);
        // int []temp=new int[d];
        // for (int j = 0; j < d; j++) {
        //     temp[j]=nums[n-1-j];
        // }

        // for (int i = n-1; i >= d ; i--) {
        //         nums[i]=nums[i-d];
        // }
        // for(int i=0;i<d;i++){
        //     nums[i]=temp[d-1-i];
        // }


        //Tc -> O(2n)
        //sc-> O(1)
        int d = (k % n);
        reverse(nums, 0, n - d);
        reverse(nums, n - d, n);
        reverse(nums, 0, n);


    }

    public void reverse(int[] arr, int vali, int n) {
        int i = vali, j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void moveZeroToEnd(int[] arr, int n) {
//        boolean sap=true;
//        int count=0;
//        while (sap || count<n-1){
//            sap=false;
//            for(int i=0;i<=n-2-count;i++){
//                if(arr[i]==0){
//                    int temp=arr[i];
//                    arr[i]=arr[i+1];
//                    arr[i+1]=temp;
//                    sap=true;
//                }
//            }
//            count++;
//        }

        //better soln done by me
        //O(n^2) worst case O(n)
//        int i=0,c=n;
//        while (i<c){
//            if(arr[i]==0){
//                leftRotateArrayByOnePlace(arr,i);
//                c--;
//            }else {
//                i++;
//            }
//        }
        // TC -> O(n), Sc->O(1)
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[j] == 0 && arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            } else if (arr[j] != 0) {
                j++;
            }
        }


    }

    public static int linearSearch(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


    public static int[] unionArray(int[] arr1, int[] arr2) {

        //O(n1log n  + n2log n ) + O(n1 + n2)
        //Sc-> O(n1 + n2) + O(n1+n2)
//        Set<Integer> integerSet=new HashSet<>();
//
//        //O(nlog n)
//        for (int i : arr1){
//            integerSet.add(i);
//        }
//        for (int i : arr2){
//            integerSet.add(i);
//        }
//        int j=0;
//        int []arr=new int[integerSet.size()];
//        for (int i : integerSet){
//            arr[j++]=i;
//        }
        ArrayList<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                unionList.add(arr1[i]);
                i++;
            } else {
                unionList.add(arr1[j]);
                j++;
            }
        }
        while (i < arr1.length) {
            unionList.add(arr1[i]);
            i++;
        }
        while (j < arr2.length) {
            unionList.add(arr2[j]);
            j++;
        }

        int[] arr = new int[unionList.size()];
        int c=0;
        for (int p : unionList) {
            arr[c++] = p;
        }

        return arr;
    }


    public static void main(String[] args) {
//        for (int i = 0; i < n; i++) {
//            a[i] = i + 1;
//        }
//        System.out.println("Total Array" + Arrays.toString(a));
//        Arrays.sort(a);
//        System.out.println("Total Array" + Arrays.toString(a));
//
//        int uniqueN=removeDuplicate(a);
//        System.out.println(uniqueN);
//        System.out.println("Unique Elements");
//        for(int i=0;i<uniqueN;i++){
//            System.out.print(a[i]+", ");
//        }

//        moveZeroToEnd(a,n);
        int[] a = getRandomArray(3);
        int[] b = getRandomArray(5);
        System.out.println("Total Array A" + Arrays.toString(a));
        System.out.println("Total Array B" + Arrays.toString(b));
        System.out.println("Total Array ANS" + Arrays.toString(unionArray(a, b)));
    }

    public static int[] getRandomArray(int n) {
        int[] a = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }
//        for (int i = 0; i < n; i++) {
//            a[i] = i + 1;
//        }
        return a;
    }


}
