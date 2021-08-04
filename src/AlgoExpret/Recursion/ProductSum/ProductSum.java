package AlgoExpret.Recursion.ProductSum;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    /*
     * Problem: Write a function that takes in a "special" array and returns its
     * product sum.
     *
     * A "special" array is a non-empty array that contains either integers or other
     * "special" arrays. The product sum of "special" array is the sum of its elements,
     * where "special" arrays inside it are summed themselves and then multiplied by
     * their level of depth.
     *
     * The depth of a "special" array is how far nested it is. For instance, the depth
     * of [] is 1; the depth of the inner array in [[]] is 2; the depth of the innermost
     * array in [[[]]] is 3.
     *
     * Therefore, the product sum of [x, y] is x + y; the product sum of [x, [y, z]]
     * is x + 2 * (y + z); the product sum of [x, [y, [z]]] is x + 2 * (y + 3z).
     */


    // This method returns true if the string is number
    // otherwise returns false
    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

//    static int multiplier = 1;
//    static int sum = 0;

//    public static int productSum1(List<Object> array) {
//        // Write your code here.
//
//        int i = 0;
//        int sum = 0;
//
//
//
//
//        if (i < array.size() && ! isNumeric(String.valueOf(array.get(i)))) {
//            multiplier++;
////            return multiplier * productSum((List<Object>) array.get(0));
//            List<Object> temp = (List<Object>) array.get(i);
//            sum += multiplier * productSum1(temp);
//        }
//        while (i < array.size() && isNumeric(String.valueOf(array.get(i))) ) {
//            sum += Integer.valueOf((Integer) array.get(i));
//            i++;
//        }
//
//        if(i < array.size()) return productSum1(array.subList(i, array.size()));
////        multiplier++;
////        return sum + productSum(array.subList(i, array.size()));
//        return sum;
//    }

    // This method give us the chance to have the multiplier for every call for
    // the method in its recursive tree
    public static int productSumWithMultiplier(List<Object> array, int multiplier){

        // This is index of main array, helps us to iterate through the array
        int arrayIndex = 0;

        // This is total sum will be returned
        int sum = 0;

        // loop through the main array
        while(arrayIndex < array.size()){

            // If the current element of the main array is number
            // then add it to main sum (we could multiply it by 1)
            if(isNumeric(String.valueOf(array.get(arrayIndex)))){
                sum += (int) array.get(arrayIndex);
            }
            else {

                // If the element is a list, then call the method again and
                // multiply the sum by our multiplier
                sum += (multiplier + 1) * productSumWithMultiplier((List<Object>) array.get(arrayIndex), multiplier + 1 );
            }

            // Increase the index of main array
            arrayIndex++;
        }

        return sum;
    }

    public static int productSum(List<Object> array){

        return productSumWithMultiplier(array, 1);
    }

    public static void initalizeArray(List<Object> array) {
        array.add(5);
        array.add(2);
        array.add(new ArrayList<Object>() {{
            add(7);
            add(-1);
        }});
        array.add(3);
        array.add(new ArrayList<Object>() {{
            add(6);
            add(new ArrayList<Object>() {{
                add(-13);
                add(8);
            }});
            add(4);
        }});
    }

    public static void main(String[] args) {
        ProductSum ps = new ProductSum();

        List<Object> array = new ArrayList<>();

        initalizeArray(array);

        System.out.println(ps.productSum(array));
    }
}
