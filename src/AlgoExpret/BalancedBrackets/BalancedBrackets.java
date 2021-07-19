package AlgoExpret.BalancedBrackets;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        if (null == str) {
            return false;
        } else {
            Deque<Character> stack = new ArrayDeque<Character>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == ']') {
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
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("(a)"));
        System.out.println(balancedBrackets("{(a},b)"));
        System.out.println(balancedBrackets("{)(a,b}"));
    }
}
