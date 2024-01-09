package _Study.Problems.validParentheses;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * <p>
 *     Iterative Approach:
 *     Time Complexity: O(n) (each character is checked one by one)
 *     Space Complexity: O(n) (worst case the entire String is in the Stack object)
 * </p>
 */
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> charStack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                charStack.add(c);
            } else {
                if (charStack.isEmpty()) { return false; } // bad character
                char previousChar = charStack.pop();
                if (c == '}' && previousChar != '{') { return false; } // bad character
                else if (c == ']' && previousChar != '[') { return false; } // bad character
                else if (c == ')' && previousChar != '(') { return false; } // bad character
            }
        }
        if (!charStack.isEmpty()) { return false; } // leftover chars
        return true; // finished successfully
    }
}
