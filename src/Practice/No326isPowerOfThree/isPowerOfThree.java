package Practice.No326isPowerOfThree;

//        给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
//        整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
//
//        示例 1：
//        输入：n = 27
//        输出：true
//
//        示例 2：
//        输入：n = 0
//        输出：false
//
//        示例 3：
//        输入：n = 9
//        输出：true
//
//        示例 4：
//        输入：n = 45
//        输出：false

public class isPowerOfThree {
//    执行用时：15 ms, 在所有 Java 提交中击败了93.08%的用户
//    内存消耗：38.3 MB, 在所有 Java 提交中击败了26.47%的用户
    public static boolean isPowerOfThree1(int n) {
        int temp = 1;
        while (n<Integer.MAX_VALUE){
            if (temp == n){
                return true;
            }else if (temp>n){
                return false;
            }else {
                temp = temp*3;
            }
        }
        return false;
    }

//    执行用时：15 ms, 在所有 Java 提交中击败了93.08%的用户
//    内存消耗：37.9 MB, 在所有 Java 提交中击败了94.38%的用户
    public static boolean isPowerOfThree2(int n) {
        while (n<Integer.MAX_VALUE){
            if (n==1){
                return true;
            }else if (n<3){
                return false;
            }else {
                if (n%3!=0){
                    break;
                }
                n=n/3;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(27));
        System.out.println(isPowerOfThree2(0));
        System.out.println(isPowerOfThree2(9));
        System.out.println(isPowerOfThree2(45));
    }
}
