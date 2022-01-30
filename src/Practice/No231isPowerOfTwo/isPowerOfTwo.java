package Practice.No231isPowerOfTwo;

//        给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//        如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
//
//        示例 1：
//        输入：n = 1
//        输出：true
//        解释：20 = 1
//
//        示例 2：
//        输入：n = 16
//        输出：true
//        解释：24 = 16
//
//        示例 3：
//        输入：n = 3
//        输出：false
//
//        示例 4：
//        输入：n = 4
//        输出：true
//
//        示例 5：
//        输入：n = 5
//        输出：false

public class isPowerOfTwo {
//    执行用时：1 ms, 在所有 Java 提交中击败了96.05%的用户
//    内存消耗：35.5 MB, 在所有 Java 提交中击败了32.73%的用户
    public static boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }else if (n%2==1){
            return false;
        }else {
            return isPowerOfTwo(n>>1);
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(256));
    }
}
