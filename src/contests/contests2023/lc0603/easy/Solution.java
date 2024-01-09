package contests.contests2023.lc0603.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted after 10 minutes
// Length easy problem. "marked as medium"

class Solution {
    public int minimizedStringLength(String s) {

        StringBuilder sb = new StringBuilder(s);

        Map<Character, List<Integer>> occMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i);
            if (occMap.containsKey(nextChar)) {
                List<Integer> curr = occMap.get(nextChar);
                curr.add(i);
                occMap.put(nextChar, curr);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                occMap.put(nextChar, temp);
            }
        }

        for (char currChar : occMap.keySet()) {
            List<Integer> allIndices = occMap.get(currChar);

            if (allIndices.size() == 1) {
                continue;
            } else {
                for (int i = 0; i < allIndices.size(); i++) {

                    if (i == 1) {
                        continue;
                    }
                    int currIndex = allIndices.get(i);
                    sb.setCharAt(currIndex, '&');
                }
            }
        }

        String ansWithAmpersands = sb.toString();
        String ans = ansWithAmpersands.replace("&", "");
        System.out.println("ans.length = " + ans.length());
        return ans.length();

    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimizedStringLength("aaabc");
        sol.minimizedStringLength("cbbd");
        sol.minimizedStringLength("dddaaa");
    }
}
