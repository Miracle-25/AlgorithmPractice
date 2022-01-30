package Interview.BeforeBeginning.singleNumber;

import java.util.*;

public class singleNumber {
    public static int singleNumber(int[] nums) {
        List<Integer> hasNum = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if (hasNum.contains(nums[i])){
                continue;
            }else if (map.containsKey(nums[i])){
                map.remove(nums[i]);
                hasNum.add(nums[i]);
            }else {
                map.put(nums[i],1);
            }
        }
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] test = new int[]{2,2,1};
//        System.out.println(singleNumber(test));
        String test = "hdfs://nopartation_table";
        System.out.println(test.lastIndexOf('#'));
    }
}
