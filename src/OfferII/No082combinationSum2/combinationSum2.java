package OfferII.No082combinationSum2;

import java.util.*;

public class combinationSum2 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static Set<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recordRes(candidates,0,target);
        for (List<Integer> list:set){
            res.add(list);
        }
        return res;
    }

    public static void recordRes(int[] candidates,int begin,int target){
        if (target==0){
            List<Integer> list = new ArrayList<>();
            for (int i:temp){
                list.add(i);
            }
            if (!set.contains(list)){
//                res.add(list);
                set.add(list);
            }
            return;
        }
        for (int i=begin;i<candidates.length;i++){
            if (candidates[i]<=target){
                temp.add(candidates[i]);
                recordRes(candidates,i+1,target-candidates[i]);
                temp.remove(temp.size()-1);
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(test,8));
    }
}
