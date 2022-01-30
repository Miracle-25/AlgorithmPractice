package Practice.No371getSum;

//        给你两个整数 a 和 b ,不使用 运算符 + 和 - ,计算并返回两整数之和.
//
//        示例 1：
//        输入：a = 1, b = 2
//        输出：3
//
//        示例 2：
//        输入：a = 2, b = 3
//        输出：5

public class getSum {

    public static int getSum(int a, int b) {
        while (b!=0) {
            int carry = (a & b) << 1;//&:按位与，<< 左移，不分正负，低位补0
            a = a ^ b;//异或运算，相同为0，不同为1
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

}
