package contests.contests2022.lc0108.mediumtwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// First attempt incorrect answer

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {


        Map<Character, HashSet<Integer>> charToWordIndexMap = new HashMap<>();
        for (int i = 0; i < targetWords.length; i++) {
            String word = targetWords[i];
            for(char c : word.toCharArray()) {
                if (charToWordIndexMap.containsKey(c)) {
                    charToWordIndexMap.get(c).add(i);
                } else {
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(i);
                    charToWordIndexMap.put(c, temp);
                }
            }
        }

        HashSet<String> ansSet = new HashSet<>();
        outerword:
        for (String word : startWords) {
            HashSet<Integer> potentials = charToWordIndexMap.get(word.charAt(0));
            for (char c : word.toCharArray()) {
                if (charToWordIndexMap.containsKey(c)) {
                    HashSet<Integer> intersection = new HashSet<Integer>(potentials);
                    HashSet<Integer> others = charToWordIndexMap.get(c);
                    intersection.retainAll(others);

                    potentials = intersection;
                } else {
                    continue outerword;
                }
            }

            // potentials contains all strings that contains all the letters of word

            for (int potentialIndex : potentials) {
                String potentialWord = targetWords[potentialIndex];

                int wordLength = word.length();
                int potentialWordLength = potentialWord.length();

//                if (wordLength == potentialWordLength) {
//                    int differences = 0;
//                    for (int i = 0; i < word.length(); i++) {
//                        if (word.charAt(i) != potentialWord.charAt(i)) {
//                            differences++;
//                        }
//                    }
//
//                    if (differences == 2) {
//                        System.out.println("swap answer found, word = " + word + " potWord = " + potentialWord);
//                        ans++;
//                    }
//                } else {

                if (wordLength == potentialWordLength - 1) {
//                    System.out.println("append answer found, word = " + word + " potWord = " + potentialWord);
                    ansSet.add(potentialWord);

//                    int differences = 0;
//                    for (int i = 0; i < word.length(); i++) {
//                        if (word.charAt(i) != potentialWord.charAt(i)) {
//                            differences++;
//                        }
//                    }
//
//                    if (differences == 0) {
//                        System.out.println("append answer found, word = " + word + " potWord = " + potentialWord);
//                    }

                }
            }
        }

        int ans = ansSet.size();
        System.out.println("final ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.wordCount(
                new String[]{"ant","act","tack"},
                new String[]{"tack","act","acti"}
        );

        sol.wordCount(
                new String[]{"ab","a"},
                new String[]{"abc","abcd"}
        );


        // expected 5
//        ["lhum","bim","cyjhm","h","a","ljxd","run","zrl","dmf","y"]
//        ["da","lzkr","uzc","jdxlz","yt","emdf"]
        sol.wordCount(
                new String[]{"lhum","bim","cyjhm","h","a","ljxd","run","zrl","dmf","y"},
                new String[]{"da","lzkr","uzc","jdxlz","yt","emdf"}
        );

        // expected 2
//        ["g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"]
//        ["r","am","jg","umhjo","fov","lujy","b","uz","y"]
        sol.wordCount(
                new String[]{"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"},
                new String[]{"r","am","jg","umhjo","fov","lujy","b","uz","y"}
        );
    }
}