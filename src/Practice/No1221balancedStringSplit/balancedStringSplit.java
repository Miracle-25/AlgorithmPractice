package Practice.No1221balancedStringSplit;

//        在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
//        给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
//        注意：分割得到的每个字符串都必须是平衡字符串。
//        返回可以通过分割得到的平衡字符串的 最大数量 。
//
//        示例 1：
//        输入：s = "RLRRLLRLRL"
//        输出：4
//        解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
//
//        示例 2：
//        输入：s = "RLLLLRRRLR"
//        输出：3
//        解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
//
//        示例 3：
//        输入：s = "LLLLRRRR"
//        输出：1
//        解释：s 只能保持原样 "LLLLRRRR".
//
//        示例 4：
//        输入：s = "RLRRRLLRLL"
//        输出：2
//        解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。


import java.util.Stack;

public class balancedStringSplit {
//    执行用时：3 ms, 在所有 Java 提交中击败了9.39%的用户
//    内存消耗：36.1 MB, 在所有 Java 提交中击败了66.53%的用户
    public static int balancedStringSplit1(String s) {
        int res = 0;
        Stack<Character> record = new Stack<Character>();
        record.push('a');
        record.push(s.charAt(0));
        for (int i = 1;i<s.length();i++){
            if (record.peek() == 'a'){
                res++;
                record.push(s.charAt(i));
                continue;
            }
            if (record.peek() == s.charAt(i) && record.peek()!='a'){
                record.push(s.charAt(i));
            }else if(record.peek() != s.charAt(i) && record.peek()!='a') {
                record.pop();
            }
        }
        return res+1;
    }

//    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗：36.2 MB, 在所有 Java 提交中击败了54.97%的用户
    public static int balancedStringSplit2(String s){
        int res = 0;
        int temp=1;
        char ch=s.charAt(0);
        for (int i=1;i<s.length();i++){
            if (s.charAt(i) == ch){
                temp++;
            }else {
                temp--;
            }
            if (temp==0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit1("RLRRRLLRLL"));
        System.out.println(balancedStringSplit2("RLRRRLLRLL"));
    }
}
