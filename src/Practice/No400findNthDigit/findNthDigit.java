package Practice.No400findNthDigit;

//        给你一个整数 n ，请你在无限的整数序列[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第n 位数字。
//
//        示例 1：
//        输入：n = 3
//        输出：3
//
//        示例 2：
//        输入：n = 11
//        输出：0
//        解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。

public class findNthDigit {
//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：35.2 MB, 在所有 Java 提交中击败了48.19%的用户
    public static int findNthDigit(int n) {
        if (n<=9){
            return n;
        }
        int num=1;
        int more = 0;
        for (int i=num;n>more;i++){
            int tempNum = (int) (9*i*Math.pow(10,i-1));
            if (n-tempNum>0){
                n=n-tempNum;//剩余的n的个数
                more = (int) Math.pow(10,i);//起始数
                num++;//位数
            }else {
                break;
            }

        }
        int number = (n-1)/num;
        int location = n%num;

//        if (more==10){
//            more=9;
//        }
        String str = String.valueOf(number+more);
        return location==0?str.charAt(str.length()-1)-48:str.charAt(location-1)-48;

    }

    public static void main(String[] args) {

        System.out.println(findNthDigit(1000));
    }
}
