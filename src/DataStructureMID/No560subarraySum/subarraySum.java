package DataStructureMID.No560subarraySum;

//        给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为k的连续子数组的个数。
//
//        示例 1：
//        输入：nums = [1,1,1], k = 2
//        输出：2
//
//        示例 2：
//        输入：nums = [1,2,3], k = 3
//        输出：2

public class subarraySum {
//    执行用时：1337 ms, 在所有 Java 提交中击败了28.86%的用户
//    内存消耗：41.8 MB, 在所有 Java 提交中击败了11.34%的用户
    public static int subarraySum(int[] nums, int k) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0]==k?1:0;
        }
        int res=0;
        for (int l=0;l<nums.length-1;l++){
            int temp=nums[l];
            if (temp==k){
                res++;
            }
            for (int r = l + 1; r < nums.length; r++) {
                        temp = temp + nums[r];
                    if (temp == k) {
                        res++;
                    }
            }

        }
        if (nums[nums.length-1]==k){
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,1,1};
        int[] test2 = new int[]{1,2,3};
        int[] test3 = new int[]{1,-1,0};
        int[] test4 = new int[]{0,0};
        System.out.println(subarraySum(test1,2));
        System.out.println(subarraySum(test2,3));
        System.out.println(subarraySum(test3,0));
        System.out.println(subarraySum(test4,0));
    }
}
