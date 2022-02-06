package OfferII.No089rob;

public class rob {
    public int rob(int[] nums) {
        int num = nums.length;
        if (num==1){
            return nums[0];
        }
        if (num==2){
            return Math.max(nums[0],nums[1]);
        }
        if (num==3){
            return Math.max(nums[0]+nums[2],nums[1]);
        }
        int[] res = new int[num];
        res[0]=nums[0];
        res[1]=nums[1];
        for (int i=2;i<num;i++){
            res[i]=Math.max(res[i-3],res[i-2])+nums[i];
        }
        return Math.max(res[num-2],res[num-1]);
    }
}
