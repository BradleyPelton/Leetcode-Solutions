package COMPSCIX404.FinalProject;

import COMPSCIX404.FinalProject.Utility.TrieStructure;
import COMPSCIX404.FinalProject.Utility.WordSearchPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;


class Tests {
    public static void main(String[] args) {
        final WordSearchPuzzle puzzleOne = new WordSearchPuzzle(
                new String[]{
                        "EZOOIWT",
                        "OPLRFAX",
                        "RRELWNE",
                        "SPENELA",
                        "IXYKPCR",
                        "TNORABB",
                        "STURSMA"
                },
                new String[]{
                        "BARON",
                        "BRAE",
                        "CELL",
                        "FLEX",
                        "MAKER",
                        "OOZE",
                        "PERI",
                        "ROE",
                        "RUTS",
                        "SITS",
                        "TAWNY",
                        "TOKEN",
                }
        );

        final WordSearchPuzzle puzzleTwo = new WordSearchPuzzle(
                new String[]{
                        "KPHGREDIWWS",
                        "NAYIHNSPDRU",
                        "WETFSIEOIMB",
                        "OROTKLGLSLD",
                        "DPNBCERAPIU",
                        "KSSAAFERERE",
                        "RLUFTHGILED",
                        "ASDRSPATDPG",
                        "MSGBWDTYWMK",
                        "DEFINGERSIH",
                        "SNHAPZTUHCS"
                },
                new String[]{
                        "CHUTZPAH",
                        "DELIGHTFUL",
                        "DISPEL",
                        "FELINE",
                        "FINGERS",
                        "GIFT",
                        "IMPERIL",
                        "MARKDOWN",
                        "NESS",
                        "POLARITY",
                        "SEGREGATE",
                        "STACKS",
                        "SUBDUED",
                        "TONS",
                        "WIDER"
                }
        );

        final WordSearchPuzzle puzzleThree = new WordSearchPuzzle( // TODO - DELETE ME
                new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","eat",}
        );
        final WordSearchPuzzle puzzleFour = new WordSearchPuzzle( // TODO - DELETE ME
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oate","oath","eat"}
        );

        List<WordSearchPuzzle> puzzleList = List.of(
//                puzzleOne,
//                puzzleTwo,
//                puzzleThree,
//                puzzleFour
        );

        TrieStructure.buildTrie("C:\\Users\\bradl\\Desktop\\berkeleyCourses\\DataStructuresAndAlgorithms\\finalProject\\allWords.md");



        int NUMBER_OF_TIMES_TO_RUN = 10_000;

        for (int i = 1; i <= puzzleList.size(); i++) {
            WordSearchPuzzle puzzle = puzzleList.get(i - 1);

            // BRUTE FORCE

            long bruteForceDurationSum = 0;
            for (int j = 0; j < NUMBER_OF_TIMES_TO_RUN; j++) {
                long startTime = System.nanoTime();
                BruteForceSolver bruteForce = new BruteForceSolver(puzzle);
                bruteForce.findWords();
                long endTime = System.nanoTime();
                bruteForceDurationSum += (endTime - startTime);
                if (!stringArrayEqualsList(puzzle.ansWords, bruteForce.wordsFound)) {
                    throw new IllegalStateException("brute force failed");
                }
            }

            double bruteForceAverageDuration = (double)bruteForceDurationSum / NUMBER_OF_TIMES_TO_RUN;
            System.out.println("Brute force puzzle=" + i + " bruteForceAverageDuration = " + bruteForceAverageDuration);


            // TRIE OPTIMIZED
            long trieDurationSum = 0;
            for (int j = 0; j < NUMBER_OF_TIMES_TO_RUN; j++) {
                long startTime = System.nanoTime();
                TriePuzzleSolver nonLinearTrieSolver = new TriePuzzleSolver(puzzle);
                nonLinearTrieSolver.findWords();
                long endTime = System.nanoTime();
                trieDurationSum += (endTime - startTime);
                if (!stringArrayEqualsList(puzzle.ansWords, nonLinearTrieSolver.wordsFound)) {
                    throw new IllegalStateException("Trie solver failed");
                }
            }

            double trieAverageDuration = (double)trieDurationSum / NUMBER_OF_TIMES_TO_RUN;
            System.out.println("Trie puzzle=" + i + " trieAverageDuration              = " + trieAverageDuration);

        }
    }

    private static boolean stringArrayEqualsList(String[] stringArr, Set<String> stringList) {
        List<String> setAsList = new ArrayList<>();
        setAsList.addAll(stringList);
        return stringArrayEqualsList(stringArr, setAsList);
    }

    private static boolean stringArrayEqualsList(String[] stringArr, List<String> stringList) {
        if (stringArr.length != stringList.size()) {
            return false;
        }
        Arrays.sort(stringArr);
        Collections.sort(stringList);

        for (int i = 0; i < stringList.size(); i++) {
            if (!stringArr[i].equals(stringList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
