package contests.contests2024.lc0316biweekly.easy;

// Accepted after 4 minutes
// Trivial

class Solution {
    public int sumOfEncryptedInt(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            String numAsString = String.valueOf(num);
            int largestDigit = 0;
            for (char c : numAsString.toCharArray()) {
                int digit =  Integer.parseInt(String.valueOf(c));
                largestDigit = Math.max(largestDigit, digit);
            }

            String replacedNum = String.valueOf(largestDigit).repeat(numAsString.length());

            ans += Integer.valueOf(replacedNum);
        }
        System.out.println(ans);
        return ans;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sumOfEncryptedInt(
                new int[]{10,21,31}
        );




    }

}