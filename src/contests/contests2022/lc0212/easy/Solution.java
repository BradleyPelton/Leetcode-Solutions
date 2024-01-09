package contests.contests2022.lc0212.easy;

// Accepted after 2 minutes
// Trivial

class Solution {
    public int countOperations(int num1, int num2) {

        int numOfOperations = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
                numOfOperations++;
            } else {
                num2 -= num1;
                numOfOperations++;
            }
        }

        System.out.println("final ans = " + numOfOperations);
        return numOfOperations;

    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countOperations(2, 3);
        sol.countOperations(10, 10);
    }
}