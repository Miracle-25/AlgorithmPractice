package Practice.No350intersect;

//        给定两个数组，编写一个函数来计算它们的交集。
//
//        示例 1：
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2,2]
//
//        示例 2:
//        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出：[4,9]

import java.util.ArrayList;
import java.util.List;

public class intersect {
//    执行用时：12 ms, 在所有 Java 提交中击败了5.25%的用户
//    内存消耗：38.6 MB, 在所有 Java 提交中击败了50.66%的用户
    public static int[] intersect1(int[] nums1, int[] nums2) {
        int temp=0;
        boolean[] judge1 = new boolean[nums1.length];
        boolean[] judge2 = new boolean[nums2.length];
        List<Integer> res = new ArrayList<>();

        for (int i=0;i<nums1.length;i++){
            temp = nums1[i];
            for (int j=0;j<nums2.length;j++){
                if (temp == nums2[j] && !judge2[j] && !judge1[i]){
                    res.add(temp);
                    judge2[j]=true;
                    judge1[i]=true;
                }
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        int temp=0;
        boolean[] judge = new boolean[Math.min(nums1.length,nums2.length)];
        List<Integer> res = new ArrayList<>();

        for (int i=0;i<nums1.length;i++){
            temp = nums1[i];
            for (int j=0;j<nums2.length;j++){
                if (temp == nums2[j] && !judge[nums1.length>nums2.length?j:i]){
                    res.add(temp);
                    judge[nums1.length> nums2.length?j:i]=true;
                }
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] test1=new int[]{3,1,2};
        int[] test2=new int[]{1,1};

        System.out.println(intersect2(test1,test2));
    }
}
