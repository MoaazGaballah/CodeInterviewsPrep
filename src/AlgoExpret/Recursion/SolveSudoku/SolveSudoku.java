package AlgoExpret.Recursion.SolveSudoku;

import java.util.ArrayList;

public class SolveSudoku {

    /*
     * You are given a two-dimensional array that represents a 9x9 partially filled Sudoku
     * board. Write a function that returns the solved Sudoku board.
     *
     * Sudoku is a famous number-placement puzzle in which you need to fill a 9x9 grid with
     * integers in the range of 1-9. Each 9x9 Sudoku board is split into 9 3x3 subgrids, as
     * seen in the illustration below, and starts out partially filled.

       - - 3 | - 2 - | 6 - -
       9 - - | 3 - 5 | - - 1
       - - 1 | 8 - 6 | 4 - -
       - - - - - - - - - - -
       - - 8 | 1 - 2 | 9 - -
       7 - - | - - - | - - 8
       - - 6 | 7 - 8 | 2 - -
       - - - - - - - - - - -
       - - 2 | 6 - 9 | 5 - -
       8 - - | 2 - 3 | - - 9
       - - 5 | - 1 - | 3 - -

     * The objective is to fill the grid such that each row, column, and 3x3 subgrid contains
     * the numbers 1-9 exactly once. In other words, no row may contain the same digit more
     * than once, no column may contain the same digit more than once, and none of the 9 3x3
     * subgirds may contain the same digit more than once.
     *
     * Your input for this problem will always be a partially filled 9x9 two-dimensional array
     * that represents a solvable Sudoku puzzle. Every element in the array will be an integer
     * in the range of 0-9, where a 0 represents an empty square that must be your algorithm.
     *
     * Note that you may modify the input array and that there will always be exactly one
     * solution to each input Sudoku board.
     *
     * Sample Input
     *
       board =
          [
            [7, 8, 0, 4, 0, 0, 1, 2, 0],
            [6, 0, 0, 0, 7, 5, 0, 0, 9],
            [0, 0, 0, 6, 0, 1, 0, 7, 8],
            [0, 0, 7, 0, 4, 0, 2, 6, 0],
            [0, 0, 1, 0, 5, 0, 9, 3, 0],
            [9, 0, 4, 0, 6, 0, 0, 0, 5],
            [0, 7, 0, 3, 0, 0, 0, 1, 2],
            [1, 2, 0, 0, 0, 7, 4, 0, 0],
            [0, 4, 9, 2, 0, 6, 0, 0, 7],
          ]

     * Sample Output

       board =
          [
           [7, 8, 5, 4, 3, 9, 1, 2, 6],
           [6, 1, 2, 8, 7, 5, 3, 4, 9],
           [4, 9, 3, 6, 2, 1, 5, 7, 8],
           [8, 5, 7, 9, 4, 3, 2, 6, 1],
           [2, 6, 1, 7, 5, 8, 9, 3, 4],
           [9, 3, 4, 1, 6, 2, 7, 8, 5],
           [5, 7, 8, 3, 9, 4, 6, 1, 2],
           [1, 2, 6, 5, 8, 7, 4, 9, 3],
           [3, 4, 9, 2, 1, 6, 8, 5, 7],
          ]

     *
     */

    public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        // Write your code here.

        solvePartialSudoku(0, 0, board);

        return board;
    }

    public static boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {

        int currentRow = row;
        int currentCol = col;

        if (currentCol == board.get(currentRow).size()) {

            currentRow += 1;
            currentCol = 0;

            if (currentRow == board.size()) return true;
        }

        if (board.get(currentRow).get(currentCol) == 0)
            return tryDigitAtPosisition(currentRow, currentCol, board);

        return solvePartialSudoku(currentRow, currentCol + 1, board);
    }

    public static boolean tryDigitAtPosisition(int row, int col, ArrayList<ArrayList<Integer>> board) {

        for (int digit = 1; digit < 10; digit++)
            if (isValidPosition(digit, row, col, board)) {
                board.get(row).set(col, digit);

                if (solvePartialSudoku(row, col + 1, board)) return true;
            }

        board.get(row).set(col, 0);
        return false;
    }

    public static boolean isValidPosition(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {

        boolean rowIsValid = !board.get(row).contains(value);
        boolean colIsValid = colIsValid(value, col, board);

        if (!rowIsValid || !colIsValid) return false;

        return subGridIsValid(value, row / 3, col / 3, board);
    }

    public static boolean colIsValid(int value, int col, ArrayList<ArrayList<Integer>> board) {
        for (int r = 0; r < board.size(); r++)
            if (board.get(r).get(col) == value) return false;


        return true;
    }

    public static boolean subGridIsValid(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++) {
                int rowToCheck = row * 3 + r;
                int colToCheck = col * 3 + c;
                int existingValue = board.get(rowToCheck).get(colToCheck);

                if (value == existingValue)
                    return false;
            }
        return true;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> board = new ArrayList<>(new ArrayList<>());

        board.add(0, new ArrayList<>());

        board.get(0).add(0, 7);
        board.get(0).add(1, 8);
        board.get(0).add(2, 0);
        board.get(0).add(3, 4);
        board.get(0).add(4, 0);
        board.get(0).add(5, 0);
        board.get(0).add(6, 1);
        board.get(0).add(7, 2);
        board.get(0).add(8, 0);

        board.add(1, new ArrayList<>());

        board.get(1).add(0, 6);
        board.get(1).add(1, 0);
        board.get(1).add(2, 0);
        board.get(1).add(3, 0);
        board.get(1).add(4, 7);
        board.get(1).add(5, 5);
        board.get(1).add(6, 0);
        board.get(1).add(7, 0);
        board.get(1).add(8, 9);

        board.add(2, new ArrayList<>());

        board.get(2).add(0, 0);
        board.get(2).add(1, 0);
        board.get(2).add(2, 0);
        board.get(2).add(3, 6);
        board.get(2).add(4, 0);
        board.get(2).add(5, 1);
        board.get(2).add(6, 0);
        board.get(2).add(7, 7);
        board.get(2).add(8, 8);

        board.add(3, new ArrayList<>());

        board.get(3).add(0, 0);
        board.get(3).add(1, 0);
        board.get(3).add(2, 7);
        board.get(3).add(3, 0);
        board.get(3).add(4, 4);
        board.get(3).add(5, 0);
        board.get(3).add(6, 2);
        board.get(3).add(7, 6);
        board.get(3).add(8, 0);

        board.add(4, new ArrayList<>());

        board.get(4).add(0, 0);
        board.get(4).add(1, 0);
        board.get(4).add(2, 1);
        board.get(4).add(3, 0);
        board.get(4).add(4, 5);
        board.get(4).add(5, 0);
        board.get(4).add(6, 9);
        board.get(4).add(7, 3);
        board.get(4).add(8, 0);

        board.add(5, new ArrayList<>());

        board.get(5).add(0, 9);
        board.get(5).add(1, 0);
        board.get(5).add(2, 4);
        board.get(5).add(3, 0);
        board.get(5).add(4, 6);
        board.get(5).add(5, 0);
        board.get(5).add(6, 0);
        board.get(5).add(7, 0);
        board.get(5).add(8, 5);

        board.add(6, new ArrayList<>());

        board.get(6).add(0, 0);
        board.get(6).add(1, 7);
        board.get(6).add(2, 0);
        board.get(6).add(3, 3);
        board.get(6).add(4, 0);
        board.get(6).add(5, 0);
        board.get(6).add(6, 0);
        board.get(6).add(7, 1);
        board.get(6).add(8, 2);

        board.add(7, new ArrayList<>());

        board.get(7).add(0, 1);
        board.get(7).add(1, 2);
        board.get(7).add(2, 0);
        board.get(7).add(3, 0);
        board.get(7).add(4, 0);
        board.get(7).add(5, 7);
        board.get(7).add(6, 4);
        board.get(7).add(7, 0);
        board.get(7).add(8, 0);

        board.add(8, new ArrayList<>());

        board.get(8).add(0, 0);
        board.get(8).add(1, 4);
        board.get(8).add(2, 9);
        board.get(8).add(3, 2);
        board.get(8).add(4, 0);
        board.get(8).add(5, 6);
        board.get(8).add(6, 0);
        board.get(8).add(7, 0);
        board.get(8).add(8, 7);

        System.out.println(solveSudoku(board));
    }
}
