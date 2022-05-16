package AlgoExpret.DaynamicProgramming.LongestCommonSequence;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSequence {


    /*


      Write a function that takes in two strings and returns their longest common
      subsequence.


      A subsequence of a string is a set of characters that aren't necessarily
      adjacent in the string but that are in the same order as they appear in the
      string. For instance, the characters ["a", "c", "d"] form a
      subsequence of the string "abcd", and so do the characters
      ["b", "d"]. Note that a single character in a string and the
      string itself are both valid subsequences of the string.
      You can assume that there will only be one longest common subsequence.

      Sample Input:
      str1  = "ZXVVYZW"
      str2  = "XKYKZPW"

      Sample Output:
      ["X", "Y", "Z", "W"]

    */

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        int [][] lengths = new int [str2.length() + 1][str1.length() + 1];

        for(int i = 1; i < str2.length() + 1; i++)
            for(int j = 1; j < str1.length() + 1; j++)
                if(str2.charAt(i - 1) == str1.charAt(j - 1))
                    lengths[i][j] = lengths[i - 1][j - 1] + 1;
                else
                    lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
        return buildSequence(lengths, str1);
    }

    public static List<Character> buildSequence(int [][] lengths, String str){
        List<Character> sequence = new ArrayList<>();
        int i = lengths.length - 1;
        int j = lengths[0].length - 1;

        while(i != 0 && j != 0){
            if(lengths[i][j] == lengths[i - 1][j])
                i--;
            else if(lengths[i][j] == lengths[i][j - 1])
                j--;
            else{
                sequence.add(0, str.charAt(j - 1));
                i--;
                j--;
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        String str1  = "ZXVVYZW";
        String str2  = "XKYKZPW";

        List<Character> result = longestCommonSubsequence(str1, str2);

        result.forEach(System.out::print);
    }
}
