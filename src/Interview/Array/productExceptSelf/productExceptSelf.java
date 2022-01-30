package Interview.Array.productExceptSelf;

public class productExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if (i==0){
                left[i]=1;
                right[nums.length-1-i]=1;
            }else {
                left[i]=nums[i-1]*left[i-1];
                right[nums.length-1-i]=nums[nums.length-i]*right[nums.length-i];
            }
        }
        for (int i=0;i<res.length;i++){
            res[i]=left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(test));
    }
}
