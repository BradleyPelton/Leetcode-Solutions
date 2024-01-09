package contests.contests2022.lc0402.easy;



// finished after 6 minutes

// The binary stuff scared me. Very rare for a computer science topic to be an easy.
// Need to perfect string manipulation. String multiplication in python RIP.



class Solution {
    public int minBitFlips(int start, int goal) {

        String startBinaryString = Integer.toBinaryString(start);
        String goalBinaryString = Integer.toBinaryString(goal);

        if (startBinaryString.length() > goalBinaryString.length()) {
            int lengthDiff = startBinaryString.length() - goalBinaryString.length();

            String zeroString = "";
            for (int i = 0; i < lengthDiff; i++) {
                zeroString += "0";
            }

            goalBinaryString = zeroString + goalBinaryString;
        } else if (startBinaryString.length() < goalBinaryString.length()) {
            int lengthDiff = goalBinaryString.length() - startBinaryString.length();

            String zeroString = "";
            for (int i = 0; i < lengthDiff; i++) {
                zeroString += "0";
            }

            startBinaryString = zeroString + startBinaryString;
        }


        int diffCount = 0;

        for (int i = 0; i < startBinaryString.length() ; i++) {
            char startChar = startBinaryString.charAt(i);
            char goalChar = goalBinaryString.charAt(i);

            if (startChar != goalChar) {
                diffCount++;
            }
        }

        System.out.println("final ans = " + diffCount);
        return diffCount;

    }
}




class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.minBitFlips(10,7);
        sol.minBitFlips(3,4);
    }
}
