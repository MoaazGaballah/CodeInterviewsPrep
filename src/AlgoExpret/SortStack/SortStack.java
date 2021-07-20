package AlgoExpret.SortStack;

import java.util.ArrayList;

public class SortStack {

    // peek returns the top element of stack
    public Integer peek(ArrayList<Integer> stack){
        return stack.get(stack.size() - 1);
    }

    // pop returns the poped off element of the stack 
    public Integer pop(ArrayList<Integer> stack){

        // first get the last element of the ArrayList 
        int poped = stack.get(stack.size() - 1);
        
        // then remove it
        stack.remove(stack.size() - 1);

        return poped;
    }

    // push element to stack
    public void push(ArrayList<Integer> stack, Integer element){
        stack.add(element);
    }

    // insertSorted method, inserts element in a sorted way
    public void insertSorted(ArrayList<Integer> stack, int value){

        // push element to the stack either if the stack is empty
        // or the top element is smaller the value will be pushed
        if (stack.isEmpty() || value > peek(stack)) {
            push(stack, value);
            return;
        }

        // if the top element is greater than the value will be pushed
        // then pop off the top element(the greater one) 
        int top = pop(stack);

        // do the same previous steps for all elements in the stack
        insertSorted(stack, value);

        // push the top element again back to the stack
        push(stack, top);
    }
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.

        // if the stack is empty, do nothing
        if (!stack.isEmpty()) {

            // pop off the top element of the stack
            int top = this.pop(stack);

            // do the previous step(poping off all elements of the stack) 
            // for all stack elements
            sortStack(stack);

            // insert all poped elements again, but in sorted way
            insertSorted(stack, top);

        }
        return stack;
    }

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(-5);
        stack.add(2);
        stack.add(-2);
        stack.add(4);
        stack.add(3);
        stack.add(1);

        SortStack ss = new SortStack();

        System.out.println(ss.sortStack(stack));
    }
}
