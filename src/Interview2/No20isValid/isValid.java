package Interview2.No20isValid;

import java.util.Stack;

public class isValid {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='(' ||
                    s.charAt(i)=='[' ||
                    s.charAt(i)=='{' ){
                stack.push(s.charAt(i));
            }else {
                Character c = stack.peek();
                if ((s.charAt(i)==')' && c=='(')||
                        (s.charAt(i)==']' && c=='[')||
                        (s.charAt(i)=='}' && c=='{')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
