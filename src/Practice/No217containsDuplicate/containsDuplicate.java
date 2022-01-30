package Practice.No217containsDuplicate;

//        给定一个整数数组，判断是否存在重复元素。
//        如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
//        示例 1:
//        输入: [1,2,3,1]
//        输出: true
//
//        示例 2:
//        输入: [1,2,3,4]
//        输出: false
//
//        示例3:
//        输入: [1,1,1,3,3,4,3,2,4,2]
//        输出: true


import java.util.HashSet;

public class containsDuplicate {
//    执行用时：9 ms, 在所有 Java 提交中击败了9.20%的用户
//    内存消耗：44.5 MB, 在所有 Java 提交中击败了21.57%的用户
    public boolean containsDuplicate1(int[] nums) {
        boolean res = false;
        HashSet temp = new HashSet();
        for (int i=0;i<nums.length;i++){
            if (temp.contains(nums[i])){
                return true;
            }else {
                temp.add(temp.add(nums[i]));
            }
        }
        return res;
    }

//    执行用时：5 ms, 在所有 Java 提交中击败了56.24%的用户
//    内存消耗：45.6 MB, 在所有 Java 提交中击败了9.67%的用户
    public static boolean containsDuplicate2(int[] nums) {
        HashSet temp = new HashSet();
        for (int i=0;i<nums.length;i++){
                temp.add(nums[i]);
        }
        return !(nums.length==temp.size());
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        System.out.println(containsDuplicate2(test));
    }
}
