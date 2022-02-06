package OfferII.No090Rob;

public class rob {
    public static int rob(int[] nums){
        int n = nums.length;
        int[] test = new int[n];
        for (int i=1;i<n;i++){
            test[i-1]=nums[i];
        }
        test[n-1]=nums[0];
        System.out.println(compute(nums));
        System.out.println(compute(test));
        return Math.max(compute(nums),compute(test));
    }
    public static int compute(int[] nums) {
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        if (n==2){
            return Math.max(nums[0],nums[1]);
        }
        if (n==3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        boolean[] hasFirest = new boolean[n];
        int[] res = new int[n];
        res[0]=nums[0];
        hasFirest[0]=true;
        res[1]=nums[1];
        hasFirest[1]=false;
        res[2]=res[0]+nums[2];
        hasFirest[2]=true;
        for (int i=3;i<n-1;i++){
            if (res[i-2]>res[i-3]){
                hasFirest[i]=hasFirest[i-2];
            }else if (res[i-2]<res[i-3]){
                hasFirest[i]=hasFirest[i-3];
            }else {
                hasFirest[i]=hasFirest[i-2] && hasFirest[i-3];
            }
            res[i]=Math.max(res[i-2],res[i-3])+nums[i];
        }
        if (hasFirest[n-3] && hasFirest[n-4]){
            res[n-1]=Math.max(res[n-4],res[n-3])+nums[n-1]-nums[0];
        }else if (hasFirest[n-3]){
            res[n-1]=Math.max(res[n-4],res[n-3]-nums[0])+nums[n-1];
        }else if (hasFirest[n-4]){
            res[n-1]=Math.max(res[n-4]-nums[0],res[n-3])+nums[n-1];
        }else {
            res[n-1]=Math.max(res[n-4],res[n-3])+nums[n-1];
        }
        return Math.max(hasFirest[n-1]?Math.max(res[n-2],res[n-1]-nums[0]):Math.max(res[n-2],res[n-1]),res[n-3]);
    }

    public static void main(String[] args) {
        int[] test=new int[]{1,2,1,1};
        int[] test2=new int[]{1,2,6,1,8,10,10,2};
        System.out.println(rob(test));
    }
}
