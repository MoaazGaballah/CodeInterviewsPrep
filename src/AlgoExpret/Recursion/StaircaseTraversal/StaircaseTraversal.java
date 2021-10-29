package AlgoExpret.Recursion.StaircaseTraversal;

import java.util.ArrayList;
import java.util.HashMap;

public class StaircaseTraversal {

    /*
     * Problem: You are given two positive integers representing the height of
     * a staircase and the maximum number of steps that you can advance up the
     * staircase at a time. Write a function that returns the number of ways in
     * which you can climb the staircase.
     *
     * For example, if you were given a staircase of height = 3 and maxSteps = 2
     * you could climb the staircase in 3 ways. You could take 1 step, you could
     * also take 1 step, then 2 steps, and you could take 2 steps, then 1 step.
     *
     * Note that maxSteps <= height will always be true
     */

    public static int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.

        // first solution
//        return firstSolution(height, maxSteps);

        // second solution
//        HashMap<Integer, Integer> memorize = new HashMap<>();

        // base case
//        memorize.put(0,1);
//        memorize.put(1, 1);
//
//        return secondSolution(height, maxSteps, memorize);

        // third solution
//        return thirdSolution(height, maxSteps);

        // forth solution
        return forthSolution(height, maxSteps);
    }

    public static int forthSolution(int height, int maxSteps){

        int currentNumberOfWays = 0;
        ArrayList<Integer> numberOfways = new ArrayList<>();
        numberOfways.add(1);

        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startOfWindow = currentHeight - maxSteps - 1;
            int endOfWindow = currentHeight - 1;

            if (startOfWindow >= 0)
                currentNumberOfWays -= numberOfways.get(startOfWindow);

            currentNumberOfWays += numberOfways.get(endOfWindow);

            numberOfways.add(currentNumberOfWays);
        }
        return numberOfways.get(height);
    }

    public static int thirdSolution(int height, int maxSteps){

        int [] numberOfWays = new int[height + 1];

        numberOfWays[0] = 1;
        numberOfWays[1] = 1;

        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int step = 1;

            while (step <= maxSteps && step <= currentHeight){
                numberOfWays[currentHeight] = numberOfWays[currentHeight] + numberOfWays[currentHeight - step];
                step++;
            }
        }
        return numberOfWays[height];
    }

    public static int secondSolution(int height, int maxSteps, HashMap<Integer, Integer> memorize){

        if (memorize.containsKey(height))
            return memorize.get(height);

        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += firstSolution(height - step, maxSteps);
        }

        memorize.put(height, numberOfWays);

        return numberOfWays;
    }

    public static int firstSolution(int height, int maxSteps){
        if (height <= 1)
            return 1;

        int numberOfWays = 0;
        for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
            numberOfWays += firstSolution(height - step, maxSteps);
        }

        return numberOfWays;
    }

    public static void main(String[] args) {

        int height = 4;
        int maxSteps = 2;

        System.out.println(staircaseTraversal(height, maxSteps));
    }
}
