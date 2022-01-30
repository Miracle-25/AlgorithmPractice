package Practice.No169majorityElement;

//        给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//        示例1：
//
//        输入：[3,2,3]
//        输出：3
//
//        示例2：
//        输入：[2,2,1,1,1,2,2]
//        输出：2
//
//        进阶：
//        尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

public class majorityElement {
//    执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
//    内存消耗：44.2 MB, 在所有 Java 提交中击败了61.79%的用户
    public int majorityElement(int[] nums) {
        int temp=0;
        int res=nums[0];
        for (int i:nums){
            if (res==i){
                temp++;
            }else {
                if (temp==0){
                    res=i;
                    temp++;
                }else {
                temp--;
                }
            }
        }
        return res;
    }
}
