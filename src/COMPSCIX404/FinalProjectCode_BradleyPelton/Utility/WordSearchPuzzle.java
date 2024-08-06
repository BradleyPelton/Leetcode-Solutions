package COMPSCIX404.FinalProjectCode_BradleyPelton.Utility;

/**
 * Simple class to hold the details of a specific puzzle.
 * This class holds the grid of characteres as well as the
 * expected words that should be found in the puzzle.
 */
public class WordSearchPuzzle {
    public char[][] characterGrid;
    public String[] ansWords;

    public WordSearchPuzzle(char[][] letters, String[] words) {
        characterGrid = letters;
        ansWords = words;
    }

    /**
     * Simple constructor to convert String[] letters to char[][]
     */
    public WordSearchPuzzle(String[] letters, String[] words) {
        characterGrid = new char[letters.length][];
        for (int i = 0; i < letters.length; i++) {
            characterGrid[i] = letters[i].toCharArray();
        }
        ansWords = words;
    }
}
