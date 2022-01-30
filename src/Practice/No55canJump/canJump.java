package Practice.No55canJump;

//给定一个非负整数数组nums你最初位于数组的第一个下标 。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个下标。
//
//示例1：
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//示例2：
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。



public class canJump {
    public static boolean canJump1(int[] nums) {
    boolean res = false;
    int first = nums[0];
    if (nums.length<=first || nums.length==1){
        return true;
    }
    for (int i=1;i<first+1;i++){
            res = canJump1(changeArray(nums,i));
            if (res){
                break;
            }
    }
    return res;
    }
    public static int[] changeArray(int[] nums,int i){
        int[] res = new int[nums.length-i];
        for (int j=0;j<res.length;j++){
            res[j]=nums[i+j];
        }
        return res;
    }

//    执行用时：3 ms, 在所有 Java 提交中击败了52.13%的用户
//    内存消耗：39.9 MB, 在所有 Java 提交中击败了34.78%的用户
    public static boolean canJump2(int[] nums) {
        int right = 0;
        boolean res = false;
        for(int i=0;i<nums.length;++i){
            if(i<=right){
                right = Math.max(right,i+nums[i]);
                if (right>=nums.length-1){
                    return true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{3,2,1,0,4};
        int[] test2 = new int[]{2,0,6,9,8,4,5,0,8,9,
                1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,
                2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,
                1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,
                7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,
                0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(canJump2(test2));
    }
}
