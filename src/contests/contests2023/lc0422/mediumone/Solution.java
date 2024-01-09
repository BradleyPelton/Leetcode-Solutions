package contests.contests2023.lc0422.mediumone;

// Accepted after 2 minutes
// Another beyond trivial questions
// Two questions sovled in 4 minutes. wow


class Solution {
    public int sumOfMultiples(int n) {

        int totalSum = 0;
        for (int i = 0; i < n+1; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                totalSum += i;
            }
        }

        System.out.println("totalSum = " + totalSum);
        return totalSum;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sumOfMultiples(7);
        sol.sumOfMultiples(10);
        sol.sumOfMultiples(9);
    }
}