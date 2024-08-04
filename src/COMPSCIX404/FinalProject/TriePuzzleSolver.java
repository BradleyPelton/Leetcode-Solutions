package COMPSCIX404.FinalProject;


import COMPSCIX404.FinalProject.Utility.BasePuzzleSolver;
import COMPSCIX404.FinalProject.Utility.Point;
import COMPSCIX404.FinalProject.Utility.TrieNode;
import COMPSCIX404.FinalProject.Utility.TrieStructure;
import COMPSCIX404.FinalProject.Utility.WordSearchPuzzle;

import java.util.Stack;

public class TriePuzzleSolver extends BasePuzzleSolver {
    public TriePuzzleSolver(WordSearchPuzzle puzzle) { super(puzzle);}

    public void findWords() {
        trie = TrieStructure.buildTrie(puzzle.ansWords);

        for (int currI = 0; currI < puzzle.characterGrid.length; currI++) {
            for (int currJ = 0; currJ < puzzle.characterGrid[0].length; currJ++) {
                char currChar = puzzle.characterGrid[currI][currJ];
                if (trie.root.containsKey(currChar)) {
                    Point currCoordinate = new Point(currI, currJ);
                    Stack<Character> charStack = new Stack<>();
                    charStack.add(currChar);

                    puzzle.characterGrid[currI][currJ] = '?';
                    search(currCoordinate, trie.root.get(currChar), charStack);
                    puzzle.characterGrid[currI][currJ] = currChar;

                }
            }
        }
    }

    private void search(Point currCoordinate, TrieNode currNode, Stack<Character> previousCharacters) {
        if (currNode.endsWord) {
            String foundWord = stackToString(previousCharacters);
            wordsFound.add(foundWord);
            trie.removeWord(foundWord); // Optimization :: Remove the word
        }

        for (int[] direction : DIRS) {
            currCoordinate.moveDirection(direction);
            if (isValidCoordinate(currCoordinate)) {
                char currChar = puzzle.characterGrid[currCoordinate.i][currCoordinate.j];
                if (currNode.containsKey(currChar)) {
                    // BEFORE
                    previousCharacters.add(currChar);
                    puzzle.characterGrid[currCoordinate.i][currCoordinate.j] = '?';

                    // ACTION
                    search(currCoordinate, currNode.get(currChar), previousCharacters);

                    // AFTER
                    puzzle.characterGrid[currCoordinate.i][currCoordinate.j] = currChar;
                    previousCharacters.pop();

                }
            }
            currCoordinate.undoMoveDirection(direction);
        }
    }
}


