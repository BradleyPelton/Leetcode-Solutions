package contests.contests2022.lc0416.easy;

// Frustrating easy problem
// Two wrong answers. I was careless, but this question had a long description.

class Solution {
    public String digitSum(String s, int k) {

        String currString = s;

        while(currString.length() > k) {
            StringBuilder allGroupsBuilder = new StringBuilder();
            int currGroupSize = 0;
            int currGroupSum = 0;

            for (int i = 0; i < currString.length(); i++) {
                currGroupSum += Integer.valueOf(String.valueOf(currString.charAt(i)));
                currGroupSize++;

                if (i == currString.length() - 1) {
                    allGroupsBuilder.append(String.valueOf(currGroupSum));
                } else if (currGroupSize == k) {
                    allGroupsBuilder.append(String.valueOf(currGroupSum));
                    currGroupSize = 0;
                    currGroupSum = 0;
                }
            }
            currString = allGroupsBuilder.toString();
        }

//        System.out.println("final ans = " + currString);
        return currString;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.digitSum("11111222223", 3);
        sol.digitSum("00000000", 3);
        sol.digitSum("1234", 2);  // expected 37

    }
}
