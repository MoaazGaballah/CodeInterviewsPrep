package AlgoExpret.DaynamicProgramming.MaxSubsetSumNoAdjacent;

public class MaxSubsetSumNoAdjacent {

    /*


    Write a function that takes in an array of positive integers and returns the
    maximum sum of non-adjacent elements in the array.

    If the input array is empty, the function should return 0.

    Sample Input:
    array  = [75, 105, 120, 75, 90, 135]

    Sample Output:
    330

    */

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array.length == 0) return 0;
        else if (array.length == 1) return array[0];

        int[] db = new int[array.length];

        db[0] = array[0];
        db[1] = Math.max(db[0], array[1]);

        for (int i = 2; i < db.length; i++) {
            db[i] = Math.max(array[i] + db[i - 2], db[i - 1]);
        }
        return db[db.length - 1];
    }

    public static void main(String[] args) {
        int[] array = {75, 105, 120, 75, 90, 135};
        System.out.println(maxSubsetSumNoAdjacent(array));
    }
}
