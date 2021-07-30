package AlgoExpret.Recursion.NthFibonacci;

public class Fibonacci {

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
