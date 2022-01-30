package OfferII.No081combinationSum;

import java.util.*;

public class combinationSum {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length==1){
            if (target==candidates[0]){
                temp.add(target);
                res.add(temp);
            }
            return res;
        }
        Arrays.sort(candidates);
        recordRes(candidates,target,0);
        return res;
    }
    public static void recordRes(int[] arr,int target,int begin){
        if (target==0){
            List<Integer> list = new ArrayList<>();
            for (int i:temp){
                list.add(i);
            }
            res.add(list);
        }else {
            for (int i=begin;i<arr.length;i++){
                if (target>=arr[i]){
                    temp.add(arr[i]);
                    recordRes(arr,target-arr[i],i);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,3,5};
        Map treeMap = new TreeMap();
        Map HashTable = new Hashtable();
        System.out.println(combinationSum(test,8));
    }
}
