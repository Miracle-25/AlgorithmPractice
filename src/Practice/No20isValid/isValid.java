package Practice.No20isValid;

//        给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//        有效字符串需满足：
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//
//        示例 1：
//        输入：s = "()"
//        输出：true
//
//        示例2：
//        输入：s = "()[]{}"
//        输出：true
//
//        示例3：
//        输入：s = "(]"
//        输出：false
//
//        示例4：
//        输入：s = "([)]"
//        输出：false
//
//        示例5：
//        输入：s = "{[]}"
//        输出：true

import java.util.Stack;

public class isValid {
//    执行用时：2 ms, 在所有 Java 提交中击败了57.41%的用户
//    内存消耗：36.2 MB, 在所有 Java 提交中击败了91.85%的用户
    public static boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                temp.push(s.charAt(i));
            }else {
                char c=temp.peek();
                if (s.charAt(i)==')'){
                    if (c=='('){
                        temp.pop();
                    }else {
                        return false;
                    }
                }
                if (s.charAt(i)==']'){
                    if (c=='['){
                        temp.pop();
                    }else {
                        return false;
                    }
                }if (s.charAt(i)=='}'){
                    if (c=='{'){
                        temp.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return temp.size()==0?true:false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));

    }
}
