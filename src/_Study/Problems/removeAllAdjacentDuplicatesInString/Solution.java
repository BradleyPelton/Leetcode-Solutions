package _Study.Problems.removeAllAdjacentDuplicatesInString;

import java.util.Stack;
import java.util.stream.Collectors;


/**
 * 1047. Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * Using a Stack drastically decreases complexity
 */
class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!charStack.isEmpty()) {
                char lastChar = charStack.peek();
                if (lastChar == c) {
                    charStack.pop();
                } else {
                    charStack.add(c);
                }
            } else {
                charStack.add(c);
            }
        }

        String ans = charStack.stream().map(i -> String.valueOf(i)).collect(Collectors.joining());
        System.out.println(ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeDuplicates("abbaca");
        sol.removeDuplicates("azxxzy");
    }
}
