package contests.contests2024.lc0601.easy;

// Accepted first attempt
// Cloudfare error. submitted after returning at 9 minute mark

class Solution {
    public int minimumChairs(String s) {

        int extraChairs = 0;
        int totalChairsNeeded = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                if (extraChairs == 0) {
                    totalChairsNeeded++;
                } else {
                    extraChairs--;
                }
            } else {
                extraChairs++;
            }
        }

        System.out.println(totalChairsNeeded);
        return totalChairsNeeded;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumChairs("EEEEEEE");
        sol.minimumChairs("ELELEEL");
        sol.minimumChairs("ELEELEELLL");
        sol.minimumChairs("EEEEEEE");




    }
}