package contests.contests2023.lc0401.easy;

// Accepted after 8 minutes
// Realtively hard easy problem
// I brute forced the hell out of this
// Not a fan of binary digit problems

class Solution {
    public int findTheLongestBalancedSubstring(String s) {


        int maxSubStringLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String subString = s.substring(i ,j);
                if (subString.length() > maxSubStringLength) {
                    if (isBalancedString(subString)) {
                        maxSubStringLength = subString.length();
                    }
                }
            }
        }
        System.out.println("ans = " + maxSubStringLength);
        return maxSubStringLength;
    }

    public boolean isBalancedString(String s) {
        int lastIndexOfZero = s.lastIndexOf('0');
        int firstIndexOfOne = s.indexOf('1');
        if (firstIndexOfOne < lastIndexOfZero) {
            return false;
        }

        int numberOfZero =  (int) s.chars().filter(ch -> ch == '0').count();
        int numberOfOne =  (int) s.chars().filter(ch -> ch == '1').count();
        return numberOfZero == numberOfOne;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isBalancedString("000111");
        sol.findTheLongestBalancedSubstring("01000111");
        sol.findTheLongestBalancedSubstring("00111");
        sol.findTheLongestBalancedSubstring("111");
    }
}
