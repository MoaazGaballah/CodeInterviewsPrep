package AlgoExpret.Recursion.GenerateDivTags;

import java.util.ArrayList;

public class GenerateDivTags {


    /*
     * Write a function that takes in a positive integer numberOfTags and returns
     * a list of all the valid strings that you can generate with that number of
     * matched tags.
     *
     * A string is valid and contains matched <div></div> tags if for every opening
     * tag <div>, there's a closing tag </div> that comes after that opening tag and
     * that isn't used as a closing tag for another opening tag. Each output string
     * should contain exactly numberOfTags opening tags and numberOfTags closing tags.
     *
     * For example, given numberOfTags = 2, the valid strings to return would be:

         ["<div></div><div></div>",
          "<div><div></div></div>"]

     * Note that the output strings don't need to be ain any particular order.
     *
     * Sample Input
     *
       numberOfTags = 3

     * Sample Output
     *

         [
            "<div><div><div></div></div></div>",
            "<div><div></div><div></div></div>",
            "<div><div></div></div><div></div>",
            "<div></div><div><div></div></div>",
            "<div></div><div></div><div></div>",
          ]
     *
     */

    public static ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.

        ArrayList<String> result = new ArrayList<>();

        generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", result);

        return result;
    }

    public static void generateDivTagsFromPrefix(
            int openingTagsNeeded, int closingTagsNeeded, String prefix, ArrayList<String> result){
        if (openingTagsNeeded > 0){
            String newPrefix = prefix + "<div>";
            generateDivTagsFromPrefix(openingTagsNeeded - 1, closingTagsNeeded,newPrefix, result);
        }
        if (openingTagsNeeded < closingTagsNeeded){
            String newPrefix = prefix + "</div>";
            generateDivTagsFromPrefix(openingTagsNeeded, closingTagsNeeded - 1, newPrefix, result);
        }

        if (closingTagsNeeded == 0) result.add(prefix);
    }

    public static void main(String[] args) {
        System.out.println(generateDivTags(3));
    }
}
