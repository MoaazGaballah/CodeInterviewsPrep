package AlgoExpret.Recursion.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /*
     * Problem: Write a function that takes in an array of unique integers and
     * returns an array of all permutations of those integers in no particular
     * order.
     *
     * If the input array is empty, the function should return an empty array.
     */


    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.

        List<List<Integer>> permutations = new ArrayList<List<Integer>>();

//        getPermutasNfactorialNsquared(array, new ArrayList<Integer>(), permutations);

        getPermutationsNfactorialN(0, array, permutations);

        return permutations;
    }

    public static void getPermutasNfactorialNsquared(List<Integer> array, List<Integer> currentPermutations, List<List<Integer>> permutations){
        if(array.size() == 0 && currentPermutations.size() > 0){
            permutations.add(currentPermutations);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutations = new ArrayList<>(currentPermutations);
                newPermutations.add(array.get(i));
                getPermutasNfactorialNsquared(newArray, newPermutations, permutations);
            }
        }
    }

    public static List<List<Integer>> getPermutationsNfactorialN(int i, List<Integer> array, List<List<Integer>> permutations){
        if (i == array.size() - 1) permutations.add(array);
        else
            for (int j = i; j < array.size(); j++) {
                swap(i, j, array);
                getPermutationsNfactorialN(i + 1, array, permutations);
                swap(i, j, array);
            }
        return  permutations;
    }

    public static void swap(int i, int j, List<Integer> array){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void initializeArray (List<Integer> array){
        array.add(1);
        array.add(2);
        array.add(3);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        initializeArray(array);

        System.out.println(getPermutations(array));
    }
}
