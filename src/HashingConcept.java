import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class HashingConcept {

    public static void main(String[] args) {
        int[] arr={1,3,2,1,1,3,4,5,2,1,1,3,5,10};
        int[] nms={1,3,2,4,6,7,9,10,11};
        findHighestAndLowest(nms,arr);
    }

    public static void numberHashing(int []nms,int []array){
        int [] hash=new int[12];
        for (int j : array) {
            hash[j]++;
        }

        for(int i : nms){
            System.out.println(hash[i]);
        }
    }

    public static void findHighestAndLowest(int []nms,int []array){
        Map<Integer,Integer> hash=new LinkedHashMap<>();
        for (int j : array) {
            hash.put(j,0);
        }
        for (int j : array) {
            hash.put(j, hash.get(j)+1);
        }


    }
}
