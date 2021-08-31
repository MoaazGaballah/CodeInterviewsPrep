package AlgoExpret.Recursion.PhoneNumberMnemonics;

import java.util.*;

public class PhoneNumberMnemonics {

    /*
     * If you open the keypad of your mobile phone, it'll likely look like this:
     */

//    1=1	    2=ABC	3=DEF
//    4=GHI	    5=JKL	6=MNO
//    7=PQRS	8=TUV	9=WXYZ
//               0=0

    /*
     * Almost every digit is assosiated with some letters in the alphabet; this
     * allows certain phone numbers to spell out actual words. For example, the
     * phone number 8464747328 can be written as timisgreat; similarly, the
     * phone number 2686463 can be written as antoine or as ant6463.
     *
     * It's important to note that a phone number doesn't represent a single
     * sequence of letters, but rather multiple combinations of letters.
     * For instance, the digit 2 can be represent three different
     * letters(a, b, and c).
     *
     * A mnemonic is defined as a pattern of letters, idea, or associations
     * that assist in remembering something. Companies oftentimes use
     * a mnemonic for their phone number to make it easier to remember.
     *
     * Given a stringified phone number of any non-zero length, write a function
     * that returns all mnemonics for this phone number, in any order.
     *
     * For this problem, a valid mnemonic may only contain letters and
     * digit 0 and 1. In other words, if a digit is able to be represented
     * by a letter, then it must be. Digits 0 and 1 are the only two digits that
     * don't have letter representations on the keypad.
     *
     * Note that you should rely on the keypad illustrated  above for digit-letter
     * associations.
     */

    public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();

    static {
        DIGIT_LETTERS.put('0', new String[]{"0"});
        DIGIT_LETTERS.put('1', new String[]{"1"});
        DIGIT_LETTERS.put('2', new String[]{"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[]{"d", "e", "f",});
        DIGIT_LETTERS.put('4', new String[]{"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String[]{"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String[]{"m", "n", "o"});
        DIGIT_LETTERS.put('7', new String[]{"p", "q", "r", "s"});
        DIGIT_LETTERS.put('8', new String[]{"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String[]{"w", "x", "y", "z"});
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.

        // initialize full zero mnemonic
        String[] currentMnemonic = new String[phoneNumber.length()];
        Arrays.fill(currentMnemonic, "0");

        // initialize return list (list of valid mnemonics)
        ArrayList<String> mnemonicsFound = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);

        return mnemonicsFound;
    }

    public static void phoneNumberMnemonicsHelper(
            int idx, String phoneNumber, String[] currentMnemonic, ArrayList<String> mnemonicsFound) {
        // valid complete mnemonic, so we will store it to the final return list
        if (idx == phoneNumber.length()) mnemonicsFound.add(String.join("", currentMnemonic));
        else {

            // getting digit from phone number
            char digit = phoneNumber.charAt(idx);

            // getting the value of the previous digit from out map
            String [] letters = DIGIT_LETTERS.get(digit);

            // taking the first, second, third and maybe forth (for 7 and 9) value letters for that number
            for (String letter : letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
            }
        }
    }

    public static void main(String[] args) {
        String str = "1905";

        System.out.println(phoneNumberMnemonics(str));
    }
}
