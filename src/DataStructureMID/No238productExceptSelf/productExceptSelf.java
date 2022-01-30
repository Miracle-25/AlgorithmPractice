package DataStructureMID.No238productExceptSelf;

//        给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
//
//        示例:
//        输入: [1,2,3,4]
//        输出: [24,12,8,6]
//
//        提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//        说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
//
//        进阶：
//        你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）


public class productExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];

        for (int i=0;i<nums.length;i++){
            int temp = 1;
            for (int j=0;j<nums.length;j++){
                if (j==i){
                    continue;
                }else if (nums[j]==0){
                    temp=0;
                    break;
                }else {
                    temp = temp*nums[j];
                }
            }
            res[i]=temp;
        }
        return res;
    }
    public static int[] productExceptSelf2(int[] nums){
        int[] res = new int[nums.length];
        int all=1;
        int zero =-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                zero=i;
            }else {
                all=all*nums[i];
            }

        }
        if (zero==-1){
        for (int i=0;i<nums.length;i++){
            res[i] = all/nums[i];
        }
        }else {
            for (int i=0;i<nums.length;i++){
                if (i==zero){
                    res[i]=all;
                }else {
                    res[i]=0;
                }
            }
        }
        return res;
    }

//    执行用时：4 ms, 在所有 Java 提交中击败了5.46%的用户
//    内存消耗：50.1 MB, 在所有 Java 提交中击败了30.99%的用户
    public static int[] productExceptSelf3(int[] nums){
        int[] res = new int[nums.length];
        int[][] temp = new int[nums.length][2];
        int temppre = 1;
        int templast = 1;
        temp[0][0]=1;
        temp[nums.length-1][1]=1;
        for(int i=1;i<nums.length;i++){
            temp[i][0]=nums[i-1]*temppre;
            temppre=temp[i][0];

            temp[nums.length-1-i][1]=nums[nums.length-i]*templast;
            templast=temp[nums.length-1-i][1];
        }
//        for (int i= nums.length-2;i>-1;i--){
//            temp[i][1]=nums[i+1]*templast;
//            templast=temp[i][1];
//        }
        for (int i=0;i< nums.length;i++){
            res[i] = temp[i][0]*temp[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        System.out.println(productExceptSelf3(test));
    }
}
