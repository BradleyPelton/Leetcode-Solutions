package COMPSCIX404.FinalProject.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collector;

/**
 * Abstract base class for all Puzzle solver instances.
 * The shared logic between the classes is stored here.
 * There are extra utility methods here as well.
 */
public abstract class BasePuzzleSolver {
    // protected final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // FOUR_DIRECTIONS
    protected final int[][] DIRECTIONS = { // EIGHT_DIRECTIONS
            {1,0},
            {1,1},
            {1,-1},
            {0,1},
            {0, -1},
            {-1, 1},
            {-1, -1},
            {-1 , 0}
    };
    public WordSearchPuzzle puzzle;
    public List<String> wordsFound = new ArrayList<>();
    protected TrieStructure trie;

    public BasePuzzleSolver(WordSearchPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    /**
     * Each subclass must implement that this method to find the words in the given
     * puzzle.
     */
    public abstract void findWords();

    /**
     * @return return true if the coordinates are inside the boundaries
     */
    protected boolean isValidCoordinate(Point point) {
        return isValidCoordinate(point.i, point.j);
    }

    /**
     * @return return true if the coordinates are inside the boundaries
     */
    boolean isValidCoordinate(int i, int j) {
        return i >= 0
                && i < puzzle.characterGrid.length
                && j >= 0
                && j < puzzle.characterGrid[0].length;
    }

    /**
     * Utility function to convert a stack to a string
     */
    protected String stackToString(Stack<Character> charStack) {
        return charStack.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }

    /**
     * @return true if the List of points contains the point argument
     */
    protected boolean pathContainsPoint(List<Point> path, Point point) {
        for (Point pathPoint : path) {
            if ((pathPoint.i == point.i) && (pathPoint.j == point.j)) {
                return true;
            }
        }
        return false;
    }
}
