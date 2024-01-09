package contests.contests2023.lc0107.mediumtwo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public boolean isItPossible(String word1, String word2) {

        Set<Character> distinctCharsWord1 = new TreeSet<>();
        Set<Character> distinctCharsWord2 = new TreeSet<>();

        Set<Character> onlyOneOccWord1 = new HashSet<>();
        Set<Character> onlyOneOccWord2 = new HashSet<>();

        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);

            if (distinctCharsWord1.contains(c)) {
                if (onlyOneOccWord1.contains(c)) {
                    onlyOneOccWord1.remove(c);
                }
            } else {
                distinctCharsWord1.add(c);
                onlyOneOccWord1.add(c);
            }
        }

        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);

            if (distinctCharsWord2.contains(c)) {
                if (onlyOneOccWord2.contains(c)) {
                    onlyOneOccWord2.remove(c);
                }
            } else {
                distinctCharsWord2.add(c);
                onlyOneOccWord2.add(c);
            }
        }

        int numberOfDistinctWords1 = distinctCharsWord1.size();
        int numberOfDistinctWords2 = distinctCharsWord2.size();
        int numberOfOneOccsWord1 = onlyOneOccWord1.size();
        int numberOfOneOccsWord2 = onlyOneOccWord2.size();
        if (numberOfDistinctWords1 == numberOfDistinctWords2) {
            System.out.println("trivial all equal, true");
            return true;
        } else if (Math.abs(numberOfDistinctWords1 - numberOfDistinctWords2) > 1) {
            System.out.println("more than 1 diff, false");
            return false;
        } else {
            if (numberOfDistinctWords1 > numberOfDistinctWords2) {
                if (numberOfOneOccsWord1 > numberOfOneOccsWord2) {
                    System.out.println("swap possible, true");
                    return true;
                } else if (numberOfOneOccsWord1 == numberOfOneOccsWord2) {
                    //
                } else {
                    // numberOfOneOccsWords1 < numberOfOneOccWord2
                }
            }
        }


        return false;

    }
}

class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.isItPossible("ac", "b");
        sol.isItPossible("abcc", "aab");
        sol.isItPossible("abcde", "fghij");

    }
}
