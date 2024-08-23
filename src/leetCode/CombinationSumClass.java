package leetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumClass {
    public static void main(String []args){
        int [] a={2,3,6,7};
        System.out.println(combinationSum(a,7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;

    }

    public static void findCombination(int index,int [] can ,int target, List<List<Integer>> ans , List<Integer> ds){
        if(index==can.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(can[index]<=target){
            ds.add(can[index]);
            findCombination(index,can,target-can[index],ans,ds);
            ds.removeLast();
        }
        findCombination(index+1,can,target,ans,ds);
    }
}
