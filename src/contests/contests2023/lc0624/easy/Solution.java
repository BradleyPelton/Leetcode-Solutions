package contests.contests2023.lc0624.easy;

// Accepted after 7 minutes
// pretty hard easy problem.

class Solution {
    public int countBeautifulPairs(int[] nums) {

        int numberOfGoodPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            String firstNumber = String.valueOf(nums[i]);
            int firstDigit = Integer.parseInt(String.valueOf(firstNumber.charAt(0)));
            for (int j = i + 1; j < nums.length; j++) {
                String secondNumber = String.valueOf(nums[j]);
                int lastDigit = Integer.parseInt(String.valueOf(secondNumber.charAt(secondNumber.length() - 1)));

                if (isCoPrime(firstDigit, lastDigit)) {
                    numberOfGoodPairs++;
                }



            }
        }

        System.out.println("ans " + numberOfGoodPairs);
        return numberOfGoodPairs;

    }

    public boolean isCoPrime(int intA, int intB) {

        int lesserInt = Math.min(intA, intB);
        boolean isCoPrimeValue = true;
        for (int i = 2; i < 10; i++) {
            if (intA % i == 0 && intB % i == 0) {
                return false;
            }
        }
        return true;

    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countBeautifulPairs(new int[]{2,5,1,4});
        sol.countBeautifulPairs(new int[]{11,21,12});

    }
}
