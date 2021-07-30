package AlgoExpret.Stack.LargestRectangleUnderSkyline;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LargestRectangle {

    /*
     * Problem: write a function that takes in an array of positive integers
     * representing the heights of adjacent buildings and returns the area of
     * the largest rectangle that can be created by any number of adjacent
     * building, including just one building. Note that all building have the
     * same width of 1 unit.
     *
     * For example, given buildings = [2, 1, 2], the area of the largest
     * rectangle that can be created is 3, using all three buildings. Since the
     * minimum height of the three buildings is 1, you can create a rectangle
     * that has a height of 1 and a width of 3 (the number of buildings). You
     * could also create rectangles of area 2 by using only the first building
     * or the last building, but these clearly wouldn't be the largest rectangles.
     * Similarly, you could create rectangles of area 2 by using the first and
     * second building or the second and third building.
     *
     * To clarify, the width of a created rectangle is the number of building used
     * to create the rectangle, and its height is the height of the smallest
     * building used to create it.
     *
     * Note that if no rectangles can be created, your function should return 0.
     */

    public int largestRectangleUnderSkyline1(ArrayList<Integer> buildings) {
        // Write your code here.

        // maxArea will be updated with maximum area
        int maxArea = 0;

        for (int indexOfBuildingHeight = 0; indexOfBuildingHeight < buildings.size(); indexOfBuildingHeight++) {

            // leftIndexTemp : used as a temp index for not affecting the main index
            // leftTempArea  : used to calculate the whole area of left side
            int leftIndexTemp = indexOfBuildingHeight, leftTempArea = 0;

            // go left unless the next left building is shorter that the main one
            while (leftIndexTemp - 1 >= 0 && buildings.get(leftIndexTemp - 1) >= buildings.get(indexOfBuildingHeight)) {

                // decrease the left index as we go through the buildings
                leftIndexTemp--;
            }

            // calculate the whole building's left area
            leftTempArea = buildings.get(indexOfBuildingHeight) * (indexOfBuildingHeight - leftIndexTemp +1);;

            // rightIndexTemp : used as a temp index for not affecting the main index
            // rightTempArea  : used to calculate the whole area of right side
            int rightLimit = 0, rightIndexTemp = indexOfBuildingHeight, rightTempArea = 0;

            // go right unless the next right building is shorter that the main one
            while (rightIndexTemp + 1 < buildings.size() && buildings.get(rightIndexTemp + 1) >= buildings.get(indexOfBuildingHeight)) {

                // increase the right index as we go through the buildings
                rightIndexTemp++;
            }

            // calculate the whole building's right area
            rightTempArea = buildings.get(indexOfBuildingHeight) * (rightIndexTemp - indexOfBuildingHeight);

            // update maxArea with either with total area of right + left or with old maxArea's value
            maxArea = Math.max(maxArea, leftTempArea + rightTempArea);
        }
        return maxArea;
    }

    public int largestRectangleUnderSkyline2(ArrayList<Integer> buildings) {
        // Write your code here.

        // this area will be returned
        int maxArea = 0;

        // stack will be used to store the indices of buildings ArrayList
        Deque<Integer> stack = new ArrayDeque<>();

        // to empty the stack at 0 height
        buildings.add(0);

        for (int i = 0; i < buildings.size(); i++) {

            // This height will be compared to stack.peek()
            int height = buildings.get(i);

            // if the element at stack bigger than or equal to height
            // of current building, then pop off the stack until be smaller than it
            while(!stack.isEmpty() && buildings.get(stack.peek()) >= height) {

                // index popped from stack, and we popped it here to use next element
                // in stack (by calling stack.peek() )
                int popped = stack.pop();

                // - if stack is NOT empty then width will be all the way just before the current index (i)
                //   til the next element in the stack which we called by stack.peek()
                // - else if stack is empty and i is not the last index then width will be 0 (equals to i)
                // - else width will be equal to i
//                int width = !stack.isEmpty() ? i - 1 - stack.peek() :i % (buildings.size() -1) == 0 ? buildings.size() - 1 : i;

                // - if stack is NOT empty then width will be all the way just before the current index (i)
                //   til the next element in the stack which we called by stack.peek()
                // - else width will be equal to i
                int width = !stack.isEmpty() ? i - 1 - stack.peek() : i;

                // This is the height of element just before i
                int heightBeforeI = buildings.get(popped);

                // calculating the max from current maxArea and area of new rectangle we just calculated
                // its height (heightBeforeI) and width
                maxArea = Math.max(maxArea, width * heightBeforeI);
            }

            // if the building at ArrayList bigger than or equal to height
            // at the index lies in stack.peek, then push it to stack
            stack.push(i);
        }
        return maxArea;
    }

    public static void initalizeHeights(ArrayList<Integer> buildings) {

        // expected output : 9
//        buildings.add(1);
//        buildings.add(3);
//        buildings.add(3);
//        buildings.add(2);
//        buildings.add(4);
//        buildings.add(1);
//        buildings.add(5);
//        buildings.add(3);
//        buildings.add(2);

        // expected output : 12
        buildings.add(4);
        buildings.add(4);
        buildings.add(4);
        buildings.add(2);
        buildings.add(2);
        buildings.add(1);
    }

    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();

        ArrayList<Integer> buildingsHeights = new ArrayList<>();

        initalizeHeights(buildingsHeights);

        // iterative solution
//        System.out.println(lr.largestRectangleUnderSkyline1(buildingsHeights));

        // stack used solution
        System.out.println(lr.largestRectangleUnderSkyline2(buildingsHeights));
    }
}
