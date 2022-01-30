package Practice.No414thirdMax;

//        给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
//
//        示例 1：
//        输入：[3, 2, 1]
//        输出：1
//        解释：第三大的数是 1 。
//
//        示例 2：
//        输入：[1, 2]
//        输出：2
//        解释：第三大的数不存在, 所以返回最大的数 2 。
//
//        示例 3：
//        输入：[2, 2, 3, 1]
//        输出：1
//        解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//        此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。


import java.util.ArrayList;
import java.util.List;

public class thirdMax {
//    执行用时：235 ms, 在所有 Java 提交中击败了5.22%的用户
//    内存消耗：38.1 MB, 在所有 Java 提交中击败了82.49%的用户
    public static int thirdMax1(int[] nums) {
        List temp = new ArrayList();
        for (int i=0;i<nums.length;i++){
            if (!temp.contains(nums[i])){
            temp.add(nums[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        int num = 0;
        if (temp.size()<3){
            for (int i=0;i<temp.size();i++){
                res = Math.max(res, (Integer) temp.get(i));
            }
            return res;
        }else {
            for (int x=0;x<3;x++){
                res = Integer.MIN_VALUE;
            for (int i=0;i<temp.size();i++){
                if ((Integer)temp.get(i)>=res){
                    res = (Integer)temp.get(i);
                    num = i;
                }
            }
            temp.remove(num);
            }
        }
        return res;
    }

    public static int thirdMax2(int[] nums){
        int res = Integer.MIN_VALUE;

        if (nums.length<3){
            for (int i=0;i<nums.length;i++){
            res = Math.max(res,nums[i]);
            }
        }else {
            int j = 0;
            int[] temp = nums;
            for (int y=0;y<3;y++) {
                j=0;
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i] >= res) {
                        res = temp[i];
                        j = i;
                    }
                }
                temp = change2(temp, j);
            }
            res = temp[j];
        }

        return res;
    }
    public static int[] change2(int[] nums,int j){
        if (j>0){
            int[] res = new int[nums.length-1];
            for (int i=0,x=0;i<res.length;i++,x++){
                if (i!=j){
                    res[i] = nums[x];
                }else {
                    x++;
                }
            }
            return res;
        }else {
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax2(test));
    }
}
