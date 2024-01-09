package contests.contests2022.lc0219.easy;

// embarrassing
// finished after 14 miunutes
// STumbled with a simple problem to brute force
// Tried to get cute instead of brute force.

// Fear of auto boxing

class Solution {
    public int countEven(int num) {

        //sum of all digits less than or equal num
        // such that the digit sum is even

        // sum of all digits == sum of evens + sum of odds

        // sum of evens = sum of all digits  - sum of odds

        int ans = 0;
        int currDigitSum = 0;
        for (int i = 1; i <= num; i++) {
            String valAsString = String.valueOf(i);
            int digitSum = 0;
            for (char digit : valAsString.toCharArray()) {
                digitSum += Integer.valueOf(digit);
            }
            if(digitSum % 2 ==0) {
                ans++;
            }
        }

        System.out.println("final, ans = " + ans);
        return ans;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countEven(4);
        sol.countEven(30);







    }
}
