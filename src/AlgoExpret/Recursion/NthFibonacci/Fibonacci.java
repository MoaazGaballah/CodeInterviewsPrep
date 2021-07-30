package AlgoExpret.Recursion.NthFibonacci;

public class Fibonacci {

    /*
     * Problem: The Fibonacci sequence is defined as follows: the first number
     * of the sequence is 0, the second number is 1, and the nth number is the
     * sum of the (n-1)th and (n-2)th numbers. Write a function that takes in an
     * n and returns the nth Fibonacci number.
     *
     * Important note: the Fibonacci sequence is often defined with its first two
     * numbers as F0 = 0 and F1 = 1. For the purpose of this question, the first
     * Fibonacci number is F0, therefore, getNthFib(1) is equal to F1, etc..
     */

    public static int getNthFib(int n) {
        // Write your code here.

        // series is : 0 1 1 2 3 5 8 ...
        // so first index (base case) equals to 0
        if(n == 1) return 0;

        // and so second case (also base case) equals to 1
        else if(n == 2) return 1;

        // series equation: n = (n -1) + (n - 2)
        else return getNthFib(n-2) + getNthFib(n-1);
    }

    public static void main(String[] args) {

        // get fibonacci series result for this number
        int fiboNumber = 6;

        System.out.println(getNthFib(fiboNumber));
    }
}
