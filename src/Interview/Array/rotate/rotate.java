package Interview.Array.rotate;

public class rotate {
    public void rotate1(int[] nums, int k) {
        k=k%nums.length;
        for (int j=0;j<k;j++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }
    public void rotate2(int[] nums, int k){
        int[] arr = new int[nums.length];
        for (int i=0;i< nums.length;i++){
            arr[i]=nums[i];
        }
        int len = nums.length;
        k=k% len;
        for (int i=len-1;i>=0;i--){
            if (i-k>=0){
            nums[i]=arr[i-k];
            }else {
                nums[i]=arr[len+i-k];
            }
        }
    }
}
