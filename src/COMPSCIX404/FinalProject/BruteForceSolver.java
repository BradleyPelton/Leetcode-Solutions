package COMPSCIX404.FinalProject;


import COMPSCIX404.FinalProject.Utility.BasePuzzleSolver;
import COMPSCIX404.FinalProject.Utility.Point;
import COMPSCIX404.FinalProject.Utility.WordSearchPuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solver class that implements the Brute Force Algorithm.
 *
 * <p>
 *      This inefficient solver will iterate over the character grid,
 *      check if a any words start with the current character at the grid
 *      location, then generate all possible paths from the current character.
 *      To prevent duplicate coordinate use, we have to maintain a list of
 *      visited points.
 * </p>
 */
public class BruteForceSolver extends BasePuzzleSolver {
    public BruteForceSolver(WordSearchPuzzle puzzle) { super(puzzle);}

    public void findWords() {
        for (int currI = 0; currI < puzzle.characterGrid.length; currI++) {
            for (int currJ = 0; currJ < puzzle.characterGrid[0].length; currJ++) {
                char currChar = puzzle.characterGrid[currI][currJ];

                WORD_LOOP:
                for (String word : puzzle.ansWords) {
                    if (word.charAt(0) == currChar) {
                        List<List<Point>> paths = new ArrayList<>();
                        paths.add(new ArrayList<>(List.of(new Point(currI, currJ))));

                        for (int i = 1; i < word.length(); i++) {
                            char nextChar = word.charAt(i);

                            List<List<Point>> nextLevelOfPaths = new ArrayList<>();
                            for (List<Point> path : paths) {
                                Point currCoordinate = path.get(path.size() - 1);

                                for (int[] direction : DIRECTIONS) {
                                    Point newCoordinate = new Point(
                                            currCoordinate.i + direction[0],
                                            currCoordinate.j + direction[1]
                                    );
                                    if (isValidCoordinate(newCoordinate)) {
                                        if (puzzle.characterGrid[newCoordinate.i][newCoordinate.j] == nextChar) {
                                            if (!pathContainsPoint(path, newCoordinate)) {
                                                List<Point> copiedPath = new ArrayList<>(path);
                                                copiedPath.add(new Point(newCoordinate));
                                                nextLevelOfPaths.add(copiedPath);
                                            }
                                        }
                                    }
                                }
                            }
                            paths = nextLevelOfPaths;
                            if (paths.isEmpty()) {
                                continue WORD_LOOP;
                            }
                        }
                        wordsFound.add(word); // word was found
                    }
                }
            }
        }
        // Brute force finds duplicate words
        wordsFound = wordsFound.stream().distinct().collect(Collectors.toList());
    }
}


