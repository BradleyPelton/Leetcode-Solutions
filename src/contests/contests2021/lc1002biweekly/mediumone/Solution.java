package contests.contests2021.lc1002biweekly.mediumone;

// Accepted first try
// Accepeted after 20 minutes

// Probably could have brute forced the problem. double for loop fir length=100\
// I also fumblede around debugging for 10 minutes because I misread the question. string have to be concatenated in a specific order

class Solution {
    public int numOfPairs(String[] nums, String target) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            String originalPart = nums[i];
            String otherPart = "";

            // TODO -  handle edge case of both starts with and ends with
            if (target.startsWith(originalPart)) {
                otherPart = target.substring(originalPart.length());
            }
//            else if (target.endsWith(originalPart)) {
//                otherPart = target.substring(0, target.length() - originalPart.length());
//            }

            int otherPartCount = 0;
            if (!"".equals(otherPart)) {
                for (int j = 0; j < nums.length; j++) {
                    if (j != i && nums[j].equals(otherPart)) {
                        otherPartCount++;
                    }
                }
                ans += otherPartCount;
            }
//            System.out.println("original part = " + originalPart + " other part is = " + otherPart + " otherPartCount = " + otherPartCount);
        }


        System.out.println("final ans = " + ans);
        return ans;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numOfPairs(new String[]{"777","7","77","77"}, "7777");
        sol.numOfPairs(new String[]{"123","4","12","34"}, "1234");
        sol.numOfPairs(new String[]{"1","1","1"}, "11");
    }
}