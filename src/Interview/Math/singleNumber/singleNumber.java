package Interview.Math.singleNumber;

public class singleNumber {
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1;i<nums.length;i++){
            res = res^nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,2,1};
        System.out.println(singleNumber(test));
    }
}
