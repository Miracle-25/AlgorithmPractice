package Practice.No189rotate;

//        给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
//        进阶：
//        尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
//        你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
//
//        示例 1:
//        输入: nums = [1,2,3,4,5,6,7], k = 3
//        输出: [5,6,7,1,2,3,4]
//        解释:
//        向右旋转 1 步: [7,1,2,3,4,5,6]
//        向右旋转 2 步: [6,7,1,2,3,4,5]
//        向右旋转 3 步: [5,6,7,1,2,3,4]
//
//        示例2:
//        输入：nums = [-1,-100,3,99], k = 2
//        输出：[3,99,-1,-100]
//        解释:
//        向右旋转 1 步: [99,-1,-100,3]
//        向右旋转 2 步: [3,99,-1,-100]

public class rotate {
    public void rotate1(int[] nums, int k) {
        k=k % nums.length;
        for (int i=0;i<k;i++){
            move(nums);
        }
    }
    public void move(int[] nums){
        int temp = nums[nums.length-1];
        for (int i=1;i< nums.length;i++){
            nums[nums.length-i] = nums[nums.length-i-1];
        }
        nums[0]=temp;
    }

//    执行用时：1 ms, 在所有 Java 提交中击败了62.40%的用户
//    内存消耗：55.2 MB, 在所有 Java 提交中击败了72.71%的用户
    public void rotate2(int[] nums, int k){
        k=k % nums.length;
        int[] res = new int[nums.length];
        for (int i=0,j=0;i<nums.length;i++){
            if (k+i< nums.length){
            res[k+i] = nums[i];
            }else {
                res[j]=nums[i];
                j++;
            }
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}
