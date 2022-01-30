package Interview2.No416canPartition;

import java.util.Arrays;

public class canPartition {
    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int all = 0;
        for (int i:nums){
            all = all+i;
        }
        if (all%2==1){
            return false;
        }
        all = all/2;
        for (int i:nums){
            if (i==all){
                return true;
            }else if (i>all){
                return false;
            }else {
                continue;
            }
        }
        boolean[][] res = new boolean[nums.length][all+1];
        for (int i=0;i<nums.length;i++){
            res[i][nums[i]]=true;
        }
        for (int i=0;i<nums.length;i++){
            for (int j=1;j<=all;j++){
                if (i>0){
                    res[i][j]=res[i-1][j] | res[i][j];
                if (j>nums[i]){
                    res[i][j]=res[i-1][j-nums[i]] | res[i][j];
                }else {
                    continue;
                }
                }
            }
        }
        return res[nums.length-1][all];
    }

    public static void main(String[] args) {
        int[] test = new int[]{23,13,11,7,6,5,5};
        System.out.println(canPartition(test));
    }



}
