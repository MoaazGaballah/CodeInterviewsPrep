package AlgoExpret.SortStack;

import java.util.ArrayList;

public class SortStack {

    /*
     * Problem: Write a funtion that takes in an array of integers representing
     * a stack, recursively sorts the stack in place (i.e., doesn't create
     * a brand new array), and returns it.
     * The array must be treated as a stack, with the end of the array as the
     * top if the stack. Therefore, you're only allowed to
     * - Pop elements from the top of the stack by removing elements from the
     *   end if the array using built-in .pop() method in your programming 
     *   language of choise.
     * - Push elements to the top of the stack by appending elements to the end
     *   of the array using the built-in .append() method in your programming
     *   language of your choise.
     * - Peek at the element on top of the stack by accessing the last element
     *   in the array.
     * You're not allowed to perform any other operations on the input array,
     * including accessing elements(except for the last element) moving elements,
     * etc.. You're also not allowed to use any other data structures, and your
     * solution must be recursive.
     */

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
