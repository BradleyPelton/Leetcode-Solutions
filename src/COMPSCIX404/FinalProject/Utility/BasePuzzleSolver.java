package COMPSCIX404.FinalProject.Utility;

import COMPSCIX404.FinalProject.Utility.Point;
import COMPSCIX404.FinalProject.Utility.TrieStructure;
import COMPSCIX404.FinalProject.Utility.WordSearchPuzzle;

import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collector;

public abstract class BasePuzzleSolver {
//    protected final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    protected final int[][] DIRS = {
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
    public Set<String> wordsFound = new TreeSet<>();
    protected TrieStructure trie;

    public BasePuzzleSolver(WordSearchPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    public abstract void findWords();

    protected boolean isValidCoordinate(Point point) {
        return isValidCoordinate(point.i, point.j);
    }

    boolean isValidCoordinate(int i, int j) {
        return i >= 0
                && i < puzzle.characterGrid.length
                && j >= 0
                && j < puzzle.characterGrid[0].length;
    }

    boolean areCoordinatesAdjacent(Point p1, Point p2) {
        return Math.abs(p2.i - p1.i) <= 1
                && Math.abs(p2.j - p1.j) <= 1
                && (p1.i != p2.i || p1.j != p2.j);
    }

    protected String stackToString(Stack<Character> charStack) {
        return charStack.stream().collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }

    protected boolean pathContainsPoint(List<Point> path, Point point) {
        for (Point pathPoint : path) {
            if ((pathPoint.i == point.i) && (pathPoint.j == point.j)) {
                return true;
            }
        }
        return false;
    }
}
