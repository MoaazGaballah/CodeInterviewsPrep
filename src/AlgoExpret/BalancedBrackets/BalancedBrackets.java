package AlgoExpret.BalancedBrackets;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {

    /*
     * Problem: Write a function that takes in a string made up of brackets
     * ()[]{} and other optional chatacters. The function should return
     * a boolean representing whether the string is balanced with regards
     * to brackets.
     * A String is said to be balanced if it has as many opening brackets
     * of a certain type as it has closing bracket of that type and if no
     * bracket is unmatched, Note that and opening bracket can't match 
     * a corresponding closing bracket that comes before it, and similarly,
     * a closing bracket can't match a corresponding opning bracket that
     * comes after it. Also, brackets can't overlap each other as in [(])
     */

    public static boolean balancedBrackets(String str) {
        // Write your code here.

        // if the string is empty no need for any thing
        if (null == str) {
            return false;
        } else {
            // stack used to store all passed open brackets
            Deque<Character> stack = new ArrayDeque<Character>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // if the character is an open bracket, then push directly
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == ']') { // if the character closing bracket from that type
                    // then the opened one must be at the top of the stack
                    // if not then it's false
                    if (stack.isEmpty() || stack.pop() != '[') { 
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
            }
            // at the end the main stack must be empty
            // so if it is, then it's balanced. Otherwise it's not.
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("(a)"));
        System.out.println(balancedBrackets("{(a},b)"));
        System.out.println(balancedBrackets("{)(a,b}"));
    }
}
