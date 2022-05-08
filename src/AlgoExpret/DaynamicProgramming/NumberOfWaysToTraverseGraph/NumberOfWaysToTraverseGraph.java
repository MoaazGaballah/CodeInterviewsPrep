package AlgoExpret.DaynamicProgramming.NumberOfWaysToTraverseGraph;

import java.util.Arrays;

public class NumberOfWaysToTraverseGraph {

    /*



    You're given two positive integers representing the width and height of a
    grid-shaped, rectangular graph. Write a function that returns the number of
    ways to reach the bottom right corner of the graph when starting at the top
    left corner. Each move you take must either go down or right. In other words,
    you can never move up or left in the graph.


    For example, given the graph illustrated below, with width = 2 and height = 2,
    there are three ways to reach the bottom right corner when starting at the top
    left corner:
     _ _
    |_|_|
    |_|_|
    |_|_|

    Down, Down, Right
    Right, Down, Down
    Down, Right, Down


    Note: you may assume that width * height >= 2 . In other words, the graph will
    never be a 1x1 grid.


    Sample Input:
    width = 4
    height = 3

    Sample Output:
    10

    */

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.
        int [][] db = new int [height][width];
        Arrays.fill(db[0], 1);
        for(int i = 0; i < height; i++)
            db[i][0] = 1;
        for(int i = 1; i < height; i++)
            for(int j = 1; j < width; j++)
                db[i][j] = db[i - 1][j] + db[i][j - 1];

        return db[height - 1][width - 1];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(3, 4));
    }
}
