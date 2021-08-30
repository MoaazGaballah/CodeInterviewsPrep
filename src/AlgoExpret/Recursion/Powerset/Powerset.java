package AlgoExpret.Recursion.Powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {
    /*
     * Problem: Write a function that takes in an array of unique integers and
     * returns its powerset.
     * The powerset P(X) of a set X is the set of all subsets of x. For example,
     * the powerset of [1,2] is [[], [1], [2], [1, 2]].
     * Note that the sets in the powerset do not need to be in any particular
     * order.
     */
    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.

        // o(n*2^n) time | o(n*2^n) space

        return powerset(array, array.size() - 1);

        // o(n*2^n) time | o(n*2^n) space

        // initialize subsets array
//        List<List<Integer>> subsets = new ArrayList();
//        subsets.add(new ArrayList<>());
//
//
//        for (int ele : array) {
//            int len = subsets.size();
//            for (int i = 0; i < len; i++) {
//                List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
//                currentSubset.add(ele);
//                subsets.add(currentSubset);
//            }
//        }
//        return subsets;
    }

    public static List<List<Integer>> powerset(List<Integer> array, int idx) {
        if (idx < 0) {
            List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int ele = array.get(idx);
        List<List<Integer>> subsets = powerset(array, idx - 1);
        int len = subsets.size();
        for (int i = 0; i < len; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(ele);
            subsets.add(currentSubset);
        }
        return subsets;
    }

    public static void initializeArray(List<Integer> array) {
        array.add(1);
        array.add(2);
        array.add(3);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        initializeArray(array);

        System.out.println(powerset(array));
    }
}
