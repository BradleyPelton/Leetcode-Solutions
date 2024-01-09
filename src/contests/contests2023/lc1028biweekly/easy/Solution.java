package contests.contests2023.lc1028biweekly.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Accepted after 9 minutes
// Long easy problem.

class Solution {
    public int sumCounts(List<Integer> nums) {
        
        int distinctSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> currentDistinct = new HashSet<>();
            currentDistinct.add(nums.get(i));
            distinctSum += sumFromSet(currentDistinct);
            for (int j = i + 1; j < nums.size(); j++) {
                currentDistinct.add(nums.get(j));
                distinctSum += sumFromSet(currentDistinct);
            }
        }
        System.out.println("ans = " + distinctSum);
        return distinctSum;

    }

    private int sumFromSet(Set<Integer> set) {
        int sum = 0;
        for (int e : set) {
            sum++;
        }
        return (int) Math.pow(sum, 2);
    }
}



class Tests{
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sumCounts(List.of(1,2,1));
        sol.sumCounts(List.of(1,1));




    }
}
