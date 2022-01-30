package Interview2.No53maxSubArray;

public class maxSubArray {
    public int maxSubArray(int[] nums){
        int res = 0;
        int[] temp = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if (i==0){
                temp[i]=nums[i];
                res=temp[i];
            }else {
                temp[i]=Math.max(temp[i-1]+nums[i],nums[i]);
                res = Math.max(temp[i],res);
            }
        }
        return res;
    }
}
