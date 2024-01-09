package contests.contests2023.lc0722.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Accepted after 10 minutes
// Struggled with escaped the separator variable. Regex basics

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> ansList = new ArrayList<>();
        for (String word : words) {
            String[] splitWords = word.split(Pattern.quote(String.valueOf(separator)));
            for (String splitWord : splitWords) {
                if (splitWord.length() > 0) {
                    ansList.add(splitWord);
                }
            }
        }
//        System.out.println(ansList);
        return ansList;

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.splitWordsBySeparator(
                List.of("one.two.three","four.five","six"),
                '.'
        );
        sol.splitWordsBySeparator(
                List.of("$easy$","$problem$"),
                '$'
        );
        sol.splitWordsBySeparator(
                List.of("|||"),
                '|'
        );








    }
}
