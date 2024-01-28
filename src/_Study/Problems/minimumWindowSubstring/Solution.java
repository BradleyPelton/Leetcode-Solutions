package _Study.Problems.minimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        return "";
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minWindow(
                "ADOBECODEBANC",
                "ABC"
        );
        sol.minWindow(
                "a",
                "a"
        );
        sol.minWindow(
                "a",
                "aa"
        );
    }
}