package AlgoExpret.LargestRectangleUnderSkyline;

import java.util.ArrayList;

public class LargestRectangle {

    /*
     * Problem: write a function that takes in an array of positive integers
     * representing the heights of adjacent buildings and returns the area of
     * the largest rectangle that can be created by any number of adjacent
     * building, including just one building. Note that all building have the
     * same width of 1 unit.
     *
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
        return -1;
    }

    public static void initalizeHeights(ArrayList<Integer> buildings) {
        buildings.add(1);
        buildings.add(3);
        buildings.add(3);
        buildings.add(2);
        buildings.add(4);
        buildings.add(1);
        buildings.add(5);
        buildings.add(3);
        buildings.add(2);
    }

    public static void main(String[] args) {
        LargestRectangle lr = new LargestRectangle();

        ArrayList<Integer> buildingsHeights = new ArrayList<>();

        initalizeHeights(buildingsHeights);

        System.out.println(lr.largestRectangleUnderSkyline1(buildingsHeights));

        System.out.println(lr.largestRectangleUnderSkyline2(buildingsHeights));
    }
}
