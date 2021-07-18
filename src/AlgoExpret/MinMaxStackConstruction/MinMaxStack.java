package AlgoExpret.MinMaxStackConstruction;

import java.util.Stack;

public class MinMaxStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private Stack<Integer> maxSt;

    public MinMaxStack() {
        st = new Stack<>();
        minSt = new Stack<>();
        maxSt = new Stack<>();
    }

    public int peek() {
        // Write your code here.
        return st.peek();
    }

    public int pop() {
        // Write your code here.
        minSt.pop();
        maxSt.pop();

        return st.pop();
    }

    public void push(Integer number) {
        // Write your code here.
        Integer min = number;
        Integer max = number;

        if (!minSt.isEmpty() && min > minSt.peek()) {
            min = minSt.peek();
        }

        if (!maxSt.isEmpty() && max < maxSt.peek()) {
            max = maxSt.peek();
        }

        st.push(number);
        minSt.push(min);
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
