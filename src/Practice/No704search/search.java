package Practice.No704search;

//给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
//
//        示例 1:
//        输入: nums = [-1,0,3,5,9,12], target = 9
//        输出: 4
//        解释: 9 出现在 nums 中并且下标为 4
//
//        示例2:
//        输入: nums = [-1,0,3,5,9,12], target = 2
//        输出: -1
//        解释: 2 不存在 nums 中因此返回 -1

public class search {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：39.5 MB, 在所有 Java 提交中击败了20.35%的用户
    public static int search1(int[] nums, int target) {
        return searchTarget(nums,target,0,nums.length);
    }
    public static int searchTarget(int[] nums,int target,int begin,int end){
        int mid = (end - begin)/2 + begin;
        if (end-1<=begin && target != nums[begin]){
            return -1;
        }
        if (nums[mid] == target){
            return mid;
        }else if (nums[mid] > target){
            return searchTarget(nums,target,begin,mid);
        }else{
            return searchTarget(nums,target,mid,end);
        }
    }

//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：39 MB, 在所有 Java 提交中击败了95.72%的用户
    public int search2(int[] nums, int target) {
        return searchTarget2(nums,target,0, nums.length);
    }
    public int searchTarget2(int[] nums,int target,int begin,int end){
        int central = (end-begin)/2+begin;
        if (begin>=end-1 && nums[begin]!=target){
            return -1;
        }
        if (nums[central]==target){
            return central;
        }else if (nums[central]>target){
            return searchTarget2(nums,target,begin,central);
        }else {
            return searchTarget2(nums,target,central,end);
        }
    }



        public static void main(String[] args) {
        int[] test = new int[]{-1,0,3,5,9,12};
        int[] test2 = new int[]{1,0,3,5,9,12};
        System.out.println(search1(test2,2));
    }
}
