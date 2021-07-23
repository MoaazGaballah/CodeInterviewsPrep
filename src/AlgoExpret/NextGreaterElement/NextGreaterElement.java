package AlgoExpret.NextGreaterElement;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {

    /*
     * Problem: Write a function that takes in an array of integers and returns
     * a new array containing, at each index, the next element in the input array
     * that's greater than the elemnet at the index in the input array.
     * 
     * In other words, your function should return a new array where outputArray[i]
     * is the next element in the input array that's greater than inputArray[i].
     * If there's no such next greater element for a particular index, the value 
     * at that index in the input array should be -1. For example, given 
     * array = [1, 2], your function should return [2, -1].
     * 
     * Additionally, your function should treat the input array as a circular
     * array. A circular array wraps around itself as if it were connected
     * end-to-end. So the next index after the last index in a circular array is
     * the first index. This means that, for our problem, given 
     * array = [0, 0, 5, 0, 0, 3, 0, 0], the next greater element after 3 is 5,
     * since the array is circula
     */

    public int[] nextGreaterElement(int[] array) {
        // Write your code here.

        // new array that will be returned 
        int[] outputArray = new int[array.length];

        // initialize new array with -1 as a default values
        Arrays.fill(outputArray, -1);
        
        // length of the inputArray
        int len = array.length;

        // stack will be used for sorting previous indeies
        // that will be compared
        Deque<Integer> stack = new ArrayDeque<>();

        //  loop till comming to last index twice
        for (int i = 0; i < len * 2; i++){

            // if the stck is empty or the value at some index
            // in the inputArray is greater that the previous one
            while (!stack.isEmpty() && array[i % len] > array[stack.peek()]) {

                // assign greater value to previous index in the outputArray
                outputArray[stack.peek()] = array[i % len];

                // pop off the prevoius index from the stack
                stack.pop();
            }

            // if the stack is empty
            stack.push(i % len);
        }
        return outputArray;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();

        int arr[] = { 2, 5, -3, -4, 6, 7, 2};

        int[] array = nge.nextGreaterElement(arr);

        // Print the nge[] array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
