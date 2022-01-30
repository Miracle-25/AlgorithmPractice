package Interview.StackHeapQueue.calculate;

import java.util.Stack;

public class calculate {
    public static int calculate(String s) {
        s = s.replaceAll(" ","");
        Stack<Character> stack = new Stack<>();
        int after,before;
        for (int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if (c=='*' || c=='/'){
                after=stack.pop();
                before=s.charAt(i+1)-48;
                i=i+1;
                if (c==42){
                    stack.push((char) (before*after));
                }else {
                    System.out.println(after);
                    System.out.println(before);
                    System.out.println(after/before);
                    stack.push((char) (after/before));
                }
            }else {
                if (c>=48 && c<=57){
                    stack.push((char) (c-48));
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        int mid;
        while (stack.size()!=1){
            before = stack.pop();
            mid = stack.pop();
            after = stack.pop();
            if (mid=='+'){
                after = after+before;
            }else if(mid=='-'){
                after = after-before;
            }
            stack.push((char) after);
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
//        System.out.println(3/2);
        String s = " 3+5 / 2 ";
        s = s.replaceAll(" ","");
        System.out.println(s);
    }
}
