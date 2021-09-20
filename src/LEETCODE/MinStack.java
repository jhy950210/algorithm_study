package src.LEETCODE;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {

        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println("1 = " + minStack.getMin()); // return -1024
        minStack.pop();
        System.out.println("1 = " + minStack.getMin()); // return -1024
        minStack.pop();
        System.out.println("1 = " + minStack.getMin()); // return 512

    }
}


