package AlgoExpret.DaynamicProgramming.NumberOfWaysToMakeChange;

public class NumberOfWaysToMakeChange {

    /*



    Given an array of distinct positive integers representing coin denominations and a
    single non-negative integer n  representing a target amount of money, write
    a function that returns the number of ways to make change for that target amount
    using the given coin denominations.

    Note that an unlimited amount of coins is at your disposal.

    Sample Input:
    n = 6
    denoms  = [1, 5]

    Sample Output:
    2 // 1x1 + 1x5 and 6x1

    */

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int [] numberOfWays = new int[n + 1];
        numberOfWays[0] = 1;

        for(int denom : denoms)
            for (int amount = 1; amount < n + 1; amount++)
                if (denom <= amount)
                    numberOfWays[amount] += numberOfWays[amount - denom];
        return numberOfWays[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] denome = {1, 5, 10, 25};
        System.out.println(numberOfWaysToMakeChange(n, denome));
    }
}
