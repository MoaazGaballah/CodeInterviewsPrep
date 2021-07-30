package AlgoExpret.Stack.SuntsetViews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Deque;

public class SunsetViews {
    /*
     * Problem: Given an array of buildings and a direction that all of 
     * the buildings that can see the sunset.
     * 
     * A building can see the sunset if it's strictly taller than all 
     * od the buildings that come after in the direction that it faces.
     * 
     * The input array named buildings contains positive, non-zero
     * integers representing the heights of the buildings. A building
     * at index i thus has a height denoted by building[i]. All of the 
     * buildings face the same direction, and this direction is either
     * "EAST" or "WEST". In relation to the input array, you can interpret
     * these directions as right for east and left for wast.
     * 
     * Important note: the indices in the output array should be sorted 
     * in ascending order.
     */
    
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        
        // this list used for conversion form ArrayDeque<Integer> to ArrayList<Integer>
        ArrayList<Integer> returnList = new ArrayList<>();

        // this list contains the buildings that see the sunset
        Deque<Integer> buildingWithSunSet = new ArrayDeque<Integer>();

        // right direction
        if (direction.equals("WEST")) {
            // this sequnce used for traverse buildings array easily
            // inside listIterator() length used to place the cursor to the last index
            ListIterator<Integer> sequence = Arrays.asList(Arrays.stream( buildings ).boxed().toArray( Integer[]::new ))
                                                            .listIterator(buildings.length);
            // travese the sequnce (array)
            while (sequence.hasPrevious()) {
                // get the element from the last
                Integer buildingHeight = sequence.previous();
                // while stack is not empty and
                // the top element's height is lower than or equal the current element pop it.
                while (!buildingWithSunSet.isEmpty()
                        && (Integer.compare(buildingHeight, buildings[buildingWithSunSet.peek()]) >= 0))
                        buildingWithSunSet.pop();
                // This building see the sunset
                buildingWithSunSet.push(sequence.previousIndex()+1);
            }
        } else if(direction.equals("EAST")){
            // this sequnce used for traverse buildings array easily
            // inside listIterator() default value is 0
            ListIterator<Integer> sequence = Arrays.asList(Arrays.stream(buildings).boxed().toArray(Integer[]::new))
                                                            .listIterator();
            // travese the sequnce (array)
            while (sequence.hasNext()) {
                // get the element from the first
                Integer buildingHeight = sequence.next();
                // while stack is not empty and
                // the top element's height is lower than or equal the current element pop it.
                while (!buildingWithSunSet.isEmpty()
                        && (Integer.compare(buildingHeight, buildings[buildingWithSunSet.peek()]) >= 0))
                    buildingWithSunSet.pop();
                // This building see the sunset
                buildingWithSunSet.push(sequence.nextIndex() - 1);
            }
        }
        // add all elements from buildingsWithSunSet ArrayDeque to the ArrayList will return (returnList)
        returnList.addAll(Arrays.asList(buildingWithSunSet.toArray(new Integer[buildingWithSunSet.size()])));
        // sort the returned ArrayList
        Collections.sort(returnList);
        return returnList;
    }

    public static void main(String[] args) {
        SunsetViews buildingWithSunset = new SunsetViews();

        List<Integer> buildingHeights = Arrays.asList(3, 5, 4, 4, 3, 1, 3, 2);

        List<Integer> sunsetViewList = buildingWithSunset
                .sunsetViews(buildingHeights.stream().mapToInt(i -> i).toArray(), "EAST");

        System.out.println(sunsetViewList);
    }

}
