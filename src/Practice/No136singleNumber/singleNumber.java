package Practice.No136singleNumber;

//        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//        说明：
//        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//        示例 1:
//        输入: [2,2,1]
//        输出: 1
//
//        示例2:
//        输入: [4,1,2,1,2]
//        输出: 4

import java.util.*;

public class singleNumber {
//    执行用时：498 ms, 在所有 Java 提交中击败了5.79%的用户
//    内存消耗：38.8 MB, 在所有 Java 提交中击败了15.48%的用户
    public static int singleNumber1(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i:nums){
            if (temp==null){
                temp.add(i);
            }else {
                if (temp.contains(i)){
                    temp.remove(new Integer(i));
                }else {
                    temp.add(i);
                }
            }
        }
        return temp.get(0);
    }

//    执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：38 MB, 在所有 Java 提交中击败了99.06%的用户
    public static int singleNumber2(int[] nums){
        int res = 0;
        for (int i:nums){
            res = res^i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,2,1};
        System.out.println(singleNumber1(test));
    }
}
