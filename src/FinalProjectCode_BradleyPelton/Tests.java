package FinalProjectCode_BradleyPelton;

import FinalProjectCode_BradleyPelton.Utility.WordSearchPuzzle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Tests {
    public static void main(String[] args) {
        final WordSearchPuzzle puzzleOne = new WordSearchPuzzle(
                new String[] { // SOURCE: https://api.razzlepuzzles.com/wordsearch
                        "EZOOIWT",
                        "OPLRFAX",
                        "RRELWNE",
                        "SPENELA",
                        "IXYKPCR",
                        "TNORABB",
                        "STURSMA"
                },
                new String[] {
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
                new String[] {  // SOURCE: https://api.razzlepuzzles.com/wordsearch
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

        final WordSearchPuzzle puzzleThree = new WordSearchPuzzle( // Manually created
                new char[][]{{'R','E','U','L'},{'N','D','Z','B'},{'E','E','R','G'}},
                new String[]{"RED","BLUE","GREEN"}
        );
        final WordSearchPuzzle puzzleFour = new WordSearchPuzzle( // Manually created
                new char[][] {{'Z','N','I','R'},{'T','H','E','E'},{'Z','Y','M','S'}},
                new String[]{"THE", "THEY", "THEM", "THEN", "THESE", "THERE", "THEIR"}
        );


        List<WordSearchPuzzle> puzzleList = List.of(
                puzzleOne,
                puzzleTwo,
                puzzleThree,
                puzzleFour
        );

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
