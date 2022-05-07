package AlgoExpret.DaynamicProgramming.MinNumberOfWaysToMakeChange;

import java.util.Arrays;


/*




    Given an array of positive integers representing coin denominations and a
    single non-negative integer n representing a target amount of
    money, write a function that returns the smallest number of coins needed to
    make change for (to sum up to) that target amount using the given coin
    denominations.

    Note that you have access to an unlimited amount of coins. In other words, if
    the denominations are [1, 5, 10], you have access to an unlimited
    amount of 1s, 5s, and 10s.

    If it's impossible to make change for the target amount, return -1.

    Sample Input:
    n = 7
    denoms  = [1, 5, 10]

    Sample Output:
    3 // 2x1 + 1x5

    */
public class MinNumberOfWaysToMakeChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] minNumberOfWays = new int[n + 1];
        Arrays.fill(minNumberOfWays, Integer.MAX_VALUE);
        minNumberOfWays[0] = 0;
        int toCompare = 0;
        for (int denom : denoms)
            for (int amount = 1; amount < n + 1; amount++)
                if (denom <= amount)
                    if (minNumberOfWays[amount - denom] == Integer.MAX_VALUE)
                        toCompare = Integer.MAX_VALUE;
                    else {
                        toCompare = minNumberOfWays[amount - denom] + 1;
                        minNumberOfWays[amount] = Math.min(minNumberOfWays[amount], toCompare);
                    }
        return minNumberOfWays[n] == Integer.MAX_VALUE ? -1 : minNumberOfWays[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] denome = {2, 4};

        System.out.println(minNumberOfCoinsForChange(n, denome));
    }
}
