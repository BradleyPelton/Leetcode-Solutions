package contests.contests2021.lc0724biweekly.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// Accepted after 6 minutes
// Accepted first attempt

// trivial

class Solution {
    public boolean areOccurrencesEqual(String s) {

        HashMap<Character, Integer> occMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (occMap.containsKey(c)) {
                occMap.put(c, occMap.get(c)+1);
            }
            else {
                occMap.put(c, 1);
            }
        }

        Collection<Integer> occs = occMap.values();
        List<Integer> uniqueOccs = occs.stream().distinct().collect(Collectors.toList());

        System.out.println("unique occs number = " + uniqueOccs.size());


        return uniqueOccs.size() == 1 || uniqueOccs.size() == 0;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.areOccurrencesEqual("abacbc");
        sol.areOccurrencesEqual("aaabb");
    }
}