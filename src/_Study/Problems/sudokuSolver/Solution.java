package _Study.Problems.sudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 37. Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 *
 * // TODO Optimize -  5%/5% solution eek.
 */
class Solution {
    char[][] ans;
    int[][] boxNumbers;
    List<List<Character>> columns;
    List<List<Character>> rows;
    List<List<Character>> boxes;

    public void solveSudoku(char[][] board) {
        columns = new ArrayList<>();
        rows = new ArrayList<>();
        boxes = new ArrayList<>();
        List<Character> allVals = new ArrayList<>(List.of('1','2','3','4','5','6','7','8','9'));
        for (int i = 0; i < 9; i++) {
            columns.add(new ArrayList<>(allVals));
            rows.add(new ArrayList<>(allVals));
            boxes.add(new ArrayList<>(allVals));
        }

        boxNumbers = new int[9][9];
        int startI = 0;
        int startJ = 0;
        boolean firstHoleFound = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int coordNumber = 0;
                if (i <= 2) {
                } else if (i <= 5) {
                    coordNumber += 3;
                } else { // else i <= 8
                    coordNumber += 6;

                }

                if (j <= 2) {
                } else if (j <= 5) {
                    coordNumber += 1;
                } else {
                    coordNumber += 2;
                }
                boxNumbers[i][j] = coordNumber;



                if (board[i][j] == '.') {
                    if (!firstHoleFound) {
                        startI = i;
                        startJ = j;
                        firstHoleFound = true;
                    }
                } else {
                    Character currChar = board[i][j];
                    int boxNumber = boxNumbers[i][j];
                    boxes.get(boxNumber).remove(currChar);
                    rows.get(i).remove(currChar);
                    columns.get(j).remove(currChar);
                }
            }
        }

        fillBoard(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = ans[i][j];
            }
        }
//        board = ans;
        System.out.println(Arrays.deepToString(board));
    }

    private void fillBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    int boxNumber = boxNumbers[i][j];
                    List<Character> potentialValues = threeSetComplement(
                            columns.get(j),
                            rows.get(i),
                            boxes.get(boxNumber)
                    );
                    for (Character c : potentialValues) {
                        columns.get(j).remove(c);
                        rows.get(i).remove(c);
                        boxes.get(boxNumber).remove(c);
                        board[i][j] = c;

                        fillBoard(board);

                        board[i][j] = '.';
                        columns.get(j).add(c);
                        rows.get(i).add(c);
                        boxes.get(boxNumber).add(c);
                    }
                    return; // cascade back up
                } else {
                    if (i == 8 && j == 8) {
                        ans = copyBoard(board);
                        return;
                    }
                }
            }
        }
    }

//    int complementCounter = 0;
    private List<Character> threeSetComplement(List<Character> setOne, List<Character> setTwo, List<Character> setThree) {
//        complementCounter++;
//        System.out.println(complementCounter);
        List<Character> potentialValues = new ArrayList<>();

        for (Character c : setOne) {
            if (setTwo.contains(c)) {
                if (setThree.contains(c)) {
                    potentialValues.add(c);
                }
            }
        }
        return potentialValues;
    }

    private char[][] copyBoard(char[][] board) {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = Arrays.copyOfRange(board[i], 0, board.length);
        }
        return newBoard;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solveSudoku(
                new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}
        );
    }
}