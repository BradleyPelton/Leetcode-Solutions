package contests.contests2024.lc0601.mediumtwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Accepted first attempt
// Accepted after 33 minutes
// Cool problem. I was afraid my solution was a little slow. Creating a lot of Lists.

class Solution {
    public String clearStars(String s) {

        StringBuilder deleteBuilder = new StringBuilder(s);


        Map<Character, List<Integer>> indicesMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '*') {
                deleteBuilder.setCharAt(i, '?');
                for (char key = 'a'; key <= 'z'; key++) {
                    if (indicesMap.containsKey(key)) {
                        List<Integer> currIndices = indicesMap.get(key);
                        int indexToRemove = currIndices.get(currIndices.size() - 1);
                        deleteBuilder.setCharAt(indexToRemove, '?');
                        currIndices.remove(currIndices.size() - 1);
                        if (currIndices.isEmpty()) {
                            indicesMap.remove(key);
                        } else {
                            indicesMap.put(currChar, currIndices);
                        }
                        break;
                    }
                }
            } else {
                indicesMap.computeIfAbsent(currChar, a -> new ArrayList<>()).add(i);
            }
        }

        StringBuilder ansBuilder = new StringBuilder();
        for (char c : deleteBuilder.toString().toCharArray()) {
            if (c != '?') {
                ansBuilder.append(c);
            }
        }
        String ans = ansBuilder.toString();
        //System.out.println(ans);
        return ans;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.clearStars("aaba*");
        sol.clearStars("abc");





    }
}
