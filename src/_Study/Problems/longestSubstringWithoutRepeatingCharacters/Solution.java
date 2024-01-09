package _Study.Problems.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;


/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * <p>
 *     Brute Force:
 *     Time Complexity: Big(n**3)
 *     Space Complexity: Big(n)
 * </p>
 *
 * <p>
 *     Sliding Window Approach:
 *     Time Complexity: Big O(n)
 *     Space Complexity: Big O(m) - maintaining a hashset of characters and a sliding window
 *
 * </p>
 *
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastOccMap = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastOccMap.getOrDefault(c, Integer.MIN_VALUE) >= left) {
                left = lastOccMap.get(c) + 1;
            }
            lastOccMap.put(c, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
        return maxLength;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.lengthOfLongestSubstring("abcabcbb");
        sol.lengthOfLongestSubstring("bbbbb");
        sol.lengthOfLongestSubstring("pwwkew");
        sol.lengthOfLongestSubstring("abba");
    }
}

