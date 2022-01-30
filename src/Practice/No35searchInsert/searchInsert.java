package Practice.No35searchInsert;

//        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//        请必须使用时间复杂度为 O(log n) 的算法。
//
//        示例 1:
//        输入: nums = [1,3,5,6], target = 5
//        输出: 2
//
//        示例2:
//        输入: nums = [1,3,5,6], target = 2
//        输出: 1
//
//        示例 3:
//        输入: nums = [1,3,5,6], target = 7
//        输出: 4
//
//        示例 4:
//        输入: nums = [1,3,5,6], target = 0
//        输出: 0
//
//        示例 5:
//        输入: nums = [1], target = 0
//        输出: 0。

public class searchInsert {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：37.8 MB, 在所有 Java 提交中击败了92.61%的用户
    public static int searchInsert(int[] nums, int target) {
        return search(nums,0,nums.length,target);
    }
    public static int search(int[] nums, int begin, int end, int target){
        if (begin>=end-1){
            return nums[begin]>target?begin:begin+1;
        }
        int mid = (end-begin)/2+begin;
        if (nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            return search(nums,begin,mid,target);
        }else {
            return search(nums,mid,end,target);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,6};
        System.out.println(searchInsert(test,0));
    }
}
