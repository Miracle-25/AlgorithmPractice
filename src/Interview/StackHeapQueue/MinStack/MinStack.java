package Interview.StackHeapQueue.MinStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private List<Integer> list;
    public MinStack() {
        stack = new Stack();
        list = new ArrayList<>();
    }

    public void push(int val) {
        stack.push(val);
        list.add(val);
    }

    public void pop() {
        list.remove(stack.peek());
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i:list){
            min = Math.min(min,i);
        }
        return min;
    }
}
