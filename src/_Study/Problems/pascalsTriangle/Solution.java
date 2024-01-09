package _Study.Problems.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * <p>
 *     Dynamic Programming Approach:
 *     Time Complexity: Big O(n**2) - n rows that require n/k operations
 *     Space Complexity Big(1) - no extra space used besides the input and answer
 * </p>
 *
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalRows = new ArrayList<>();
        pascalRows.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = pascalRows.get(i - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int currentRowIndex = 1; currentRowIndex < previousRow.size(); currentRowIndex++) {
                newRow.add(previousRow.get(currentRowIndex - 1) + previousRow.get(currentRowIndex));
            }
            newRow.add(1);
            pascalRows.add(newRow);
        }

        //System.out.println(pascalRows);
        return pascalRows;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generate(5);
        sol.generate(1);
    }
}