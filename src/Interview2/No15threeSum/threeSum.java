package Interview2.No15threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length;
        //对nums排序
        Arrays.sort(nums);
        for (int a=0;a<n-2;a++){
            if (a>0 && nums[a]==nums[a-1]){
                continue;
            }
            int target = 0-nums[a];
            for (int b=a+1;b<n-1;b++){
                if (b>a+1 && nums[b]==nums[b-1]){
                    continue;
                }

                for (int c=n-1;c>b;c--){
                    if (c<n-1 && nums[c]==nums[c+1]){
                        continue;
                    }
                    if (nums[b]+nums[c]<target){
                        break;
                    } else if (target==nums[c]+nums[b]){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(test));
    }

}
