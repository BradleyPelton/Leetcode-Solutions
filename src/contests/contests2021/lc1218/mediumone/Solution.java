package contests.contests2021.lc1218.mediumone;

// Accepted after 12 minutes
// Accepted second attempt. Missed the edge case of starting with space spaces[0]

class Solution {
    public String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();

        int currIndex = 0;

        for (int i = 0; i < spaces.length; i++) {
            int nextSpaceIndex = spaces[i];

            if (nextSpaceIndex == 0) {
                sb.append(" ");
                continue;
            }

            if (currIndex < nextSpaceIndex) {
                String missingSubString = s.substring(currIndex, nextSpaceIndex);
                sb.append(missingSubString);
                sb.append(" ");
                currIndex = nextSpaceIndex;
            }
        }

        sb.append(s.substring(spaces[spaces.length - 1]));


        String ans = sb.toString();
//        System.out.println("final ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15});
        sol.addSpaces("icodeinpython", new int[]{1,5,7,9});
        sol.addSpaces("spacing", new int[]{0,1,2,3,4,5,6});
    }
}