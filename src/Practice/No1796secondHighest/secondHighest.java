package Practice.No1796secondHighest;

public class secondHighest {

//    给你一个混合字符串s，请你返回 s中 第二大 的数字，如果不存在第二大的数字，请你返回 -1。
//    混合字符串 由小写英文字母和数字组成。
//
//    示例 1：
//    输入：s = "dfa12321afd"
//    输出：2
//    解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
//
//    示例 2：
//    输入：s = "abc1111"
//    输出：-1
//    解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。

//    执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.8 MB, 在所有 Java 提交中击败了88.45%的用户
    public static int secondHighest(String s) {
    int res = 0;
    int[] temp = new int[2];
    for (int i=0;i<s.length();i++){
        if (s.charAt(i)<=57 && s.charAt(i)>=48 ){
            if (temp[0]!=(int)s.charAt(i)) {
                temp[1] = Math.max(temp[1], (int) s.charAt(i));
                if (temp[1] > temp[0]) {
                    int j = temp[1];
                    temp[1] = temp[0];
                    temp[0] = j;
                }
            }
        }
    }
    if (temp[1]>=48){
        res = temp[1]-48;
    }else {
        res = -1;
    }
    return res;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest("dfa707afd"));
    }
}
