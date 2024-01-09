package contests.contests2023.lc0121.easy;

// Trivial 3 minutes
// Had to remember what a significant figure was

class Solution {
    public int alternateDigitSum(int n) {

        String numAsString = String.valueOf(n);
        int specialSum = 0;

        boolean isPositive = true;
        for(char c : numAsString.toCharArray()) {
            int val = Integer.parseInt(String.valueOf(c));
            if (isPositive) {
                isPositive = false;
            } else {
                val *= -1;
                isPositive = true;
            }
            specialSum += val;
        }

        System.out.println("ans = " + specialSum);
        return specialSum;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.alternateDigitSum(521);
        sol.alternateDigitSum(111);
        sol.alternateDigitSum(886996);
    }
}
