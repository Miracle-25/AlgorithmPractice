package Interview.StackHeapQueue.maxSlidingWindow;

public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        for (int i=0;i< res.length;i++){
            if (i==0){
                res[i] = compute(nums,i,k);
            }else {
                if (nums[i-1]==res[i-1] && nums[i+k-1]<res[i-1]){
                    res[i] = compute(nums,i,k);
                }else if (nums[i+k-1]>res[i-1]){
                    res[i] = nums[i+k-1];
                }else {
                    res[i] = res[i-1];
                }
            }
        }
        return res;
    }

    public static int compute(int[] nums,int begin,int k){
        int res = nums[begin];
        for (int i=1;i<k;i++){
            if (nums[begin+i]<=res){
                continue;
            }else {
                res=nums[begin+i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,-1,-3,5,3,6,7};
        int[] test2 = new int[]{4,3,11};
        System.out.println(compute(test2,0,3));
    }
}
