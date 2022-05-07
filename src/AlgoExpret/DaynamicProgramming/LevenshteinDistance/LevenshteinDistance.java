package AlgoExpret.DaynamicProgramming.LevenshteinDistance;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LevenshteinDistance {

    /*


    Write a function that takes in two strings and returns the minimum number of
    edit operations that need to be performed on the first string to obtain the
    second string.

    There are three edit operations: insertion of a character, deletion of a
    character, and substitution of a character for another.

    Sample Input:
    str1 = "abc"
    str2 = "yabd"

    Sample Output:
    2 // insert "y"; substitute "c" for "d"

    */

    public static int levenshteinDistance1(String str1, String str2) {
        // Write your code here.
        int[][] db = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++)
                db[i][j] = j;
            db[i][0] = i;
        }

        for (int i = 1; i < db.length; i++)
            for (int j = 1; j < db[i].length; j++)
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    db[i][j] = db[i - 1][j - 1];
                else
                    db[i][j] = Math.min(Math.min(db[i - 1][j - 1], db[i - 1][j]), db[i][j - 1]) + 1;

        return db[str1.length()][str2.length()];
    }

    //     o time (M*N) o space (Min (M, N))
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        String small = str1.length() < str2.length() ? str1 : str2;
        String big = str1.length() >= str2.length() ? str1 : str2;
        int[] evenEdits = new int[small.length() + 1];
        int[] oddEdits = new int[small.length() + 1];

        for (int j = 0; j < small.length() + 1; j++)
            evenEdits[j] = j;

        int[] currentEdits;
        int[] previousEdits = new int[small.length() + 1];
        for (int i = 1; i < big.length() + 1; i++) {
            if (i % 2 == 0) {
                currentEdits = evenEdits;
                previousEdits = oddEdits;
            } else {
                currentEdits = oddEdits;
                currentEdits = evenEdits;
            }
            currentEdits[0] = i;
            for (int j = 1; j < small.length() + 1; j++)
                if (big.charAt(i - 1) == small.charAt(j - 1))
                    currentEdits[j] = previousEdits[j - 1];
                else
                    currentEdits[j] = 1 + Math.min(Math.min(previousEdits[j - 1], previousEdits[j]), currentEdits[j - 1]);
        }

        return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";

        System.out.println(levenshteinDistance(str1, str2));
    }
}
