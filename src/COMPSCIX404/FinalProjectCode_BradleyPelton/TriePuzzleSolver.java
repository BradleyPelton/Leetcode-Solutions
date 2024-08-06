package COMPSCIX404.FinalProjectCode_BradleyPelton;


import COMPSCIX404.FinalProjectCode_BradleyPelton.Utility.BasePuzzleSolver;
import COMPSCIX404.FinalProjectCode_BradleyPelton.Utility.Point;
import COMPSCIX404.FinalProjectCode_BradleyPelton.Utility.TrieNode;
import COMPSCIX404.FinalProjectCode_BradleyPelton.Utility.TrieStructure;
import COMPSCIX404.FinalProjectCode_BradleyPelton.Utility.WordSearchPuzzle;

import java.util.Stack;


/**
 * Solver class that implements the Trie + Backtracking Algorithm.
 *
 * <p>
 *     This efficient algorithm finds all words in the Word Search
 *     puzzle by using a Trie data structure to hold all of the
 *     expected words, and then uses backtracking to search the
 *     character grid.
 * </p>
 */
public class TriePuzzleSolver extends BasePuzzleSolver {
    public TriePuzzleSolver(WordSearchPuzzle puzzle) { super(puzzle);}

    public void findWords() {
        trie = TrieStructure.buildTrie(puzzle.ansWords);
        Stack<Character> charStack = new Stack<>(); // Optimization: Keep a charStack instead of storing strings in Trie

        for (int currI = 0; currI < puzzle.characterGrid.length; currI++) {
            for (int currJ = 0; currJ < puzzle.characterGrid[0].length; currJ++) {
                char currChar = puzzle.characterGrid[currI][currJ];
                if (trie.root.containsKey(currChar)) {
                    Point currCoordinate = new Point(currI, currJ);

                    // BEFORE
                    charStack.add(currChar);
                    puzzle.characterGrid[currI][currJ] = '?';

                    // ACTION
                    search(currCoordinate, trie.root.get(currChar), charStack);

                    // AFTER: BACKTRACK
                    puzzle.characterGrid[currI][currJ] = currChar;
                    charStack.pop();
                }
            }
        }
    }

    private void search(Point currCoordinate, TrieNode currNode, Stack<Character> previousCharacters) {
        if (currNode.endsWord) {
            String foundWord = stackToString(previousCharacters); // Stack<Character> -> String
            wordsFound.add(foundWord);
            trie.removeWord(foundWord); // Optimization :: Remove the word from the Trie
            // DON'T STOP! Keep looking!
        }

        for (int[] direction : DIRECTIONS) {
            currCoordinate.moveDirection(direction);
            if (isValidCoordinate(currCoordinate)) {
                char currChar = puzzle.characterGrid[currCoordinate.i][currCoordinate.j];
                if (currNode.containsKey(currChar)) {
                    // BEFORE
                    previousCharacters.add(currChar);
                    puzzle.characterGrid[currCoordinate.i][currCoordinate.j] = '?';

                    // ACTION
                    search(currCoordinate, currNode.get(currChar), previousCharacters);

                    // AFTER: BACKTRACK
                    puzzle.characterGrid[currCoordinate.i][currCoordinate.j] = currChar;
                    previousCharacters.pop();
                }
            }
            currCoordinate.undoMoveDirection(direction); // BACKTRACK
        }
    }
}


