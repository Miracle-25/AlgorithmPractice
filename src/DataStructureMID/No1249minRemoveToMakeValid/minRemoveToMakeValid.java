package DataStructureMID.No1249minRemoveToMakeValid;

//        给你一个由 '('、')' 和小写字母组成的字符串 s。
//        你需要从字符串中删除最少数目的 '(' 或者 ')'（可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
//        请返回任意一个合法字符串。
//        有效「括号字符串」应当符合以下任意一条要求：
//        空字符串或只包含小写字母的字符串
//        可以被写作AB（A连接B）的字符串，其中A和B都是有效「括号字符串」
//        可以被写作(A)的字符串，其中A是一个有效的「括号字符串」
//
//        示例 1：
//        输入：s = "lee(t(c)o)de)"
//        输出："lee(t(c)o)de"
//        解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
//
//        示例 2：
//        输入：s = "a)b(c)d"
//        输出："ab(c)d"
//
//        示例 3：
//        输入：s = "))(("
//        输出：""
//        解释：空字符串也是有效的
//
//        示例 4：
//        输入：s = "(a(b(c)d)"
//        输出："a(b(c)d)"

import java.util.Stack;

public class minRemoveToMakeValid {
    public static String minRemoveToMakeValid(String s) {
        int temp = 0;
        String res = "";
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else if (!stack.isEmpty() && s.charAt(i)==')'){
                stack.pop();
            }
        }

        for (int i=0;i<s.length();i++){

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("())()((("));
    }
}
