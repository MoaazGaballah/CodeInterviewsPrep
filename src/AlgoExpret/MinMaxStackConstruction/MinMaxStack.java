package AlgoExpret.MinMaxStackConstruction;

import java.util.Stack;

public class MinMaxStack {

    /*
     * Problem: write a MinMaxStack class for a Min Max Stack. the class
     * should support:
     * - Pushing and poping values on and off the stack.
     * - Peeking at the value at the top of the stack.
     * - Getting both the minimum and the maximum values in the stack
     *   at any given point in time.
     * All class methods, when considerd independently, should run in
     * constant time and with constant space.
     */

    // main stack
    private Stack<Integer> st;
    // stack that has the minimum element at every level at main stack
    private Stack<Integer> minSt;
    // stack that has the maximum element at every level at main stack
    private Stack<Integer> maxSt;

    // initializing all stacks
    public MinMaxStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        maxSt = new Stack<>();
    }

    // just show the top element of the stack
    public int peek() {
        // Write your code here.
        return st.peek();
    }

    // pop one element from each stack and return the poped element from main one
    // we pop one elements from other stacks to keep tracking the status of the top
    // element in the main stack
    public int pop() {
        // Write your code here.
        minSt.pop();
        maxSt.pop();

        return st.pop();
    }


    public void push(Integer number) {
        // Write your code here.
        
        // min is used to compare it with the minimum element in our stack
        // (which kept in minSt stack)
        Integer min = number;

        // max is used to compare it with the maximum element in our stack
        // (which kept in maxSt stack) 
        Integer max = number;

        if (!minSt.isEmpty() && min > minSt.peek()) {
            // update min with the minimum element
            min = minSt.peek();
        }

        if (!maxSt.isEmpty() && max < maxSt.peek()) {
            // update max with the maximum element
            max = maxSt.peek();
        }

        // push new element to our main stack 
        st.push(number);
        
        // update minSt with the minimum element
        minSt.push(min);
        
        // update maxSt with the maximum element
        maxSt.push(max);
    }

    public int getMin() {
        // Write your code here.
        return minSt.peek();
    }

    public int getMax() {
        // Write your code here.
        return maxSt.peek();
    }

    public static void main(String[] args) {
        MinMaxStack s = new MinMaxStack();
        s.push(13);
        s.push(17);
        s.push(15);
        s.push(1);
        s.getMax();
        s.push(20);
        s.getMin();
        s.push(10);
        s.pop();
        s.push(12);
        s.push(11);
        s.getMin();
        s.pop();
        s.getMin();
        s.push(9);
        s.push(8);
        s.pop();
        s.push(7);
        s.push(6);
        s.peek();

    }
}
