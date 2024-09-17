package CheckAukat;

import java.util.*;

public class ArrayAkut {
    public static int[] reverseArray(int [] arr){
        int left =0, right = arr.length-1;
        while (left<=right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return arr;
    }
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int i : candyType) set.add(i);

        int sizeOfSet = set.size();
        int candyEatingPossible = candyType.length / 2;
        if(sizeOfSet < candyEatingPossible) return sizeOfSet;
        else return candyEatingPossible;
    }
    public static void main(String [] args){
        int []a ={1,2,3,4,5};
        System.out.println(Arrays.toString(reverseArray(a)));
        Set<Integer> set=new HashSet<>();
        for (int i : a) {
            set.add(i);
        }


    }
}
