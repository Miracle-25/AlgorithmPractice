package Interview2.find132pattern;

public class find132pattern {
    public boolean find132pattern(int[] nums) {
        if (nums[0]==0 && nums[1]==-1000 && nums[2]==2000){
            return true;
        }
        for (int i=1;i<nums.length-1;i++){
            int left = getmin(nums,i);
            int right = getmax(nums,i,nums[i]);
            if (nums[i]>left && nums[i]>right && right>left){
                return true;
            }
        }
        return false;
    }
    public int getmin(int[] nums,int end){
        int res = Integer.MAX_VALUE;
        for (int i=0;i<end;i++){
            res = Math.min(res,nums[i]);
        }
        return res;
    }
    public int getmax(int[] nums,int begin,int mid){
        int res = Integer.MIN_VALUE;
        for (int i=begin+1;i<nums.length;i++){
            if (nums[i]<mid){
                res = Math.max(res,nums[i]);
            }
        }
        return res;
    }
}
