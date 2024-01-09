package _Study.Problems.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String originalString : strs) {
            String sortedString = sortStringCharacters(originalString);
            if (anagrams.containsKey(sortedString)) {
                anagrams.get(sortedString).add(originalString);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(originalString);
                anagrams.put(sortedString, temp);
            }
        }
        List<List<String>> ans = new ArrayList<>(anagrams.values());
        //System.out.println(ans);
        return ans;
    }

    private String sortStringCharacters(String origString) {
        char[] chars = origString.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        sol.groupAnagrams(new String[]{""});
        sol.groupAnagrams(new String[]{"a"});
    }
}