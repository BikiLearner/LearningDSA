import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortingLearning {
    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(n);
        }
        QuickSort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }


    public static int[] selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i; j < len - 1 - i; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }


    public static int[] bubbleSort(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            boolean didSwap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        return arr;
    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>();
        int i = low, j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }
        while (j <= high) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = low; k <=high; k++) {
            arr[k] = temp.get(k-low);
        }

    }

    public static void QuickSort(int [] arr, int low , int high){
        if(low<high) {
            int pivotIndex = pivotIndexVal(arr, low, high);
            QuickSort(arr, low, pivotIndex-1);
            QuickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int pivotIndexVal(int [] arr, int low , int high){
        int pivot=arr[low];
        int i=low,j=high;
        while (i<j){
            // for descending order arr[i]>=pivot
            while (arr[i]<=pivot && i<=high-1){
                i++;
            }
            // for descending order arr[j]<pivot
            while (arr[j]>pivot && j>=low+1){
                j--;
            }
            if(j>i){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
        int temp=arr[j];
        arr[j]=pivot;
        arr[low]=temp;
        return j;
    }

}
