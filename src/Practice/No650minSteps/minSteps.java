package Practice.No650minSteps;

//        最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
//
//        Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
//        Paste（粘贴）：粘贴 上一次 复制的字符。
//        给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
//
//        示例 1：
//        输入：3
//        输出：3
//        解释：
//        最初, 只有一个字符 'A'。
//        第 1 步, 使用 Copy All 操作。
//        第 2 步, 使用 Paste 操作来获得 'AA'。
//        第 3 步, 使用 Paste 操作来获得 'AAA'。
//
//        示例 2：
//        输入：n = 1
//        输出：0


public class minSteps {
    public static int minSteps(int n) {
        int a = n/2;//商
        int b = n%2;//余数
        int res = 1;

        if (n==1 || n == 0){
            return 0;//1,0
        }else if (n ==2){
            return 2;//2
        } else if(n == 3){
            return 3;//3
        }else {
            if (n%2 == 0){
                return 2+minSteps(n/2);//4,6,8,10,16....
            }else {
                return 2+minSteps((n+1)/2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minSteps(0));
        System.out.println(minSteps(1));
        System.out.println(minSteps(2));
        System.out.println(minSteps(3));//3
        System.out.println(minSteps(4));
//        System.out.println(minSteps(5));

    }
}
