package Practice.No232MyQueue;

import java.util.Stack;


//        执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//        内存消耗：36.4 MB, 在所有 Java 提交中击败了13.95%的用户
public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.empty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }

}
