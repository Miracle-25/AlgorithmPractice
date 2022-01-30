package Interview.StackHeapQueue.evalRPN;

import java.util.Stack;

public class evalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack= new Stack<>();
        int after,before;
        for (int i=0;i< tokens.length;i++){
            switch (tokens[i]){
                case "+":
                    after = Integer.parseInt(stack.pop());
                    before = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(before+after));
                    break;
                case "-":
                    after = Integer.parseInt(stack.pop());
                    before = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(before-after));
                    break;
                case "*":
                    after = Integer.parseInt(stack.pop());
                    before = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(before*after));
                    break;
                case "/":
                    after = Integer.parseInt(stack.pop());
                    before = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(before/after));
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        String[] test = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(test));
    }
}
