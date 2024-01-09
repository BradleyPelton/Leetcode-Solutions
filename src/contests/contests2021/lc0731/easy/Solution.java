package contests.contests2021.lc0731.easy;

// accepted 5 minutes

// Trivial. Premature optimization cost me 2 minutes

class Solution {
    public boolean isThree(int n) {

        int numDivisors = 1;

        for (int i = 1; i < ((n+1)/2+1); i++) {
            if (n % i == 0) {
                numDivisors++;
            }

            if (numDivisors > 3) {
                System.out.println("more than 3 divisors, returning false");
                return false;
            }
        }

        if (numDivisors != 3) {
            System.out.println("divisors not equal to 3 num=" + numDivisors);
            return false;
        } else {
            System.out.println("trueeeee");
            return true;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isThree(2);
        sol.isThree(4);
    }
}