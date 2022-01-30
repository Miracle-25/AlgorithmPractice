package Practice.No977sortedSquares;

//        给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//        示例 1：
//        输入：nums = [-4,-1,0,3,10]
//        输出：[0,1,9,16,100]
//        解释：平方后，数组变为 [16,1,0,9,100]
//        排序后，数组变为 [0,1,9,16,100]
//
//        示例 2：
//        输入：nums = [-7,-3,2,3,11]
//        输出：[4,9,9,49,121]

public class sortedSquares {
//    执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：39.7 MB, 在所有 Java 提交中击败了96.51%的用户
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i=0,j= nums.length-1;
        int temp = nums.length-1;
        while (temp>-1){
            if (nums[i]*nums[i]<nums[j]*nums[j]){
                res[temp]=nums[j]*nums[j];
                j--;
            }else {
                res[temp]=nums[i]*nums[i];
                i++;
            }
            temp--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-4,-1,0,3,10};
        System.out.println(sortedSquares(test));
    }
}
