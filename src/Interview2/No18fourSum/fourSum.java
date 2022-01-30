package Interview2.No18fourSum;

import java.util.*;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int a=0;a<nums.length-3;a++){
            if (a>0 && nums[a]==nums[a-1]){
                continue;
            }
            int target_a = target-nums[a];
            for (int b=a+1;b<nums.length-2;b++){
                if (b>a+1 && nums[b]==nums[b-1]){
                    continue;
                }
                int target_b = target_a-nums[b];
                int d=nums.length-1;
                for (int c=b+1;c<nums.length-1;c++){
                    if (c>b+1 && nums[c]==nums[c-1]){
                        continue;
                    }
                    while (d>c && nums[d]+nums[c]>target_b){
                        d--;
                    }
                    if (d==c){
                        break;
                    }
                    if (nums[d]+nums[c]==target_b){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        temp.add(nums[d]);
                        res.add(temp);
                    }
                }
            }
        }

        Map map = new Hashtable();
        Set set = new HashSet();

        return res;

    }
}
