package contests.contests2024.lc0713.easy;

// Accepted after 4 mintutes
// ACcepted first try

// long easy problem

class Solution {
    public String getSmallestString(String s) {

        String smallestString = s;

        for (int left = 0; left < s.length() - 1; left++) {
            int leftDigit = Integer.parseInt(String.valueOf(s.charAt(left)));
            int rightDigit = Integer.parseInt(String.valueOf(s.charAt(left + 1)));
            if (leftDigit % 2 == rightDigit % 2) {
                StringBuilder localBuilder = new StringBuilder(s);
                localBuilder.setCharAt(left, s.charAt(left + 1));
                localBuilder.setCharAt(left + 1, s.charAt(left));

                String localString = localBuilder.toString();
                if (smallestString.compareTo(localString) > 0) {
                    smallestString = localString;
                }
            }
        }


//        System.out.println(smallestString);
        return smallestString;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.getSmallestString("45320");
        sol.getSmallestString("001");




    }
}
