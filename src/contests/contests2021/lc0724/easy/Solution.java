package contests.contests2021.lc0724.easy;

// Accepted after 10 minutes
// Accepted first try

// Took me an extra 5 minutes to understand the question

class Solution {
    public int getLucky(String s, int k) {

        int totalSum = 0;

        String firstConvert = "";

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 96;
            String valString = String.valueOf(val);
            firstConvert += valString;
        }

        String kString = firstConvert;
        for (int i = 0; i < k; i++) {
            int kSum = 0;
            for (int j = 0; j < kString.length(); j++) {
                int jVal = Integer.parseInt(Character.toString(kString.charAt(j)));
                kSum += jVal;
            }
            kString = String.valueOf(kSum);
        }

        totalSum = Integer.parseInt(kString);

        System.out.println("final ans " + totalSum);
        return totalSum;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.getLucky("iiii", 1);
        sol.getLucky("leetcode", 2);
        sol.getLucky("zbax", 2);
    }
}