package Practice.No167twoSum;

//        给定一个已按照 非递减顺序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
//        函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
//        你可以假设每个输入 只对应唯一的答案,而且你 不可以 重复使用相同的元素。
//
//        示例 1：
//        输入：numbers = [2,7,11,15], target = 9
//        输出：[1,2]
//        解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
//
//        示例 2：
//        输入：numbers = [2,3,4], target = 6
//        输出：[1,3]
//
//        示例 3：
//        输入：numbers = [-1,0], target = -1
//        输出：[1,2]

public class twoSum {
//    执行用时：124 ms, 在所有 Java 提交中击败了13.76%的用户
//    内存消耗：38.8 MB, 在所有 Java 提交中击败了26.13%的用户
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i=0;i<numbers.length-1;i++){
            int temp = target-numbers[i];
            for (int j=i+1;j<numbers.length;j++){
                if (numbers[j]==temp){
                    res[0]=i+1;
                    res[1]=j+1;
                    return res;
                }
            }
        }
        return res;
    }
}