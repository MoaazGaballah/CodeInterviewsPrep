package AlgoExpret.Recursion.InterweavingStrings;

public class InterweavingStrings {

    /*
     * Write a function that takes in three strings and returns a boolean representing
     * whether the third string can be formed by interweaving the first two strings.
     *
     * To interweave strings means to merge them by alternating their letters without
     * any specific pattern. For instance, the strings "abc" and "123" can be interwoven
     * as "a1b2c3", as "abc123" and as "ab1c23"(this list nonexhaustive).
     *
     * Letters within a string must maintain their relative ordering in the interwoven
     * string.
     *
     * Sample Input
     * one = "abc"
     * two = "def"
     * three = "abcdef"
     *
     * Sample Output
     * true
     */

    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.

        if (three.length() != one.length() + two.length())
            return false;

        // first solution
//        return areInterWoven1(one, two, three, 0, 0);

        // second solution
        return areInterWoven2(one, two, three, 0,0, new Boolean[one.length() + 1][two.length() + 1]);
    }

    public static boolean areInterWoven2(String one, String two, String three, int i, int j, Boolean [] [] cache){
        if (cache[i][j] != null)
            return cache[i][j];

        int k = i + j;
        if (k == three.length())
            return true;
        if (i < one.length() && one.charAt(i) == three.charAt(k)){
            cache [i][j] = areInterWoven2(one, two, three, i + 1, j, cache);
            if (cache[i][j])
                return true;
        }
        if (j < two.length() && two.charAt(j) == three.charAt(k)){
            cache[i][j] = areInterWoven2(one, two, three, i, j + 1, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return cache[i][j];
    }

    public static boolean areInterWoven1(String one, String two, String three, int i, int j){

        int k = i + j;
        if (k == three.length())
            return true;
        if (i < one.length() && one.charAt(i) == three.charAt(k))
            if (areInterWoven1(one, two, three, i +1, j))
                return true;
        if (j < two.length() && two.charAt(j) == three.charAt(k))
            return areInterWoven1(one, two, three, i, j + 1);
        return false;
    }

    public static void main(String[] args) {

        String one = "algoexpert";
        String two = "your-dream-job";
        String three = "your-algodream-expertjob";

        System.out.println(interweavingStrings(one, two, three));

    }
}
