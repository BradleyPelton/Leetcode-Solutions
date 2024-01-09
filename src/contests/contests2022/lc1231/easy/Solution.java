package contests.contests2022.lc1231.easy;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countDigits(int num) {

        String numAsString = String.valueOf(num);
        Map<Character, Integer> occMap = new HashMap<>();

        for(char c : numAsString.toCharArray()) {
            if (occMap.containsKey(c)) {
                occMap.put(c, occMap.get(c) + 1);
            } else {
                occMap.put(c, 1);
            }
        }

        int numberOfUniqueDivisors = 0;
        for (char c : occMap.keySet()) {
            int valueAsInt = Character.getNumericValue(c);
            if (num % valueAsInt == 0) {
                numberOfUniqueDivisors += occMap.get(c);
            }
        }

        System.out.println("final ans = " + numberOfUniqueDivisors);
        return numberOfUniqueDivisors;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countDigits(7);
        sol.countDigits(121);
        sol.countDigits(1248);
    }
}
