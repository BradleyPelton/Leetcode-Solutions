package COMPSCIX404.FinalProject.Utility;

public class WordSearchPuzzle {
    public char[][] characterGrid;
    public String[] ansWords;

    public WordSearchPuzzle(char[][] letters, String[] words) {
        characterGrid = letters;
        ansWords = words;
    }

    public WordSearchPuzzle(String[] letters, String[] words) {
        characterGrid = new char[letters.length][];
        for (int i = 0; i < letters.length; i++) {
            characterGrid[i] = letters[i].toCharArray();
        }
        ansWords = words;
    }
}
