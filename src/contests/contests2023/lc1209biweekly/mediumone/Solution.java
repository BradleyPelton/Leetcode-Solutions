package contests.contests2023.lc1209biweekly.mediumone;


// Accepted after 10 miuntes
// I tried construction the solution instead of the number of flips.
// It can be proven that a choice can be made at any index to skip the next.

class Solution {
    public int removeAlmostEqualCharacters(String word) {
        
        int numberOfFlips = 0;
        for (int i = 1; i < word.length(); i++) {
            int previousCharVal = word.charAt(i - 1);
            int currentCharVal = word.charAt(i);

            if (Math.abs(previousCharVal - currentCharVal) <= 1) {
                numberOfFlips++;
                i++;
//                if (i + 1 < word.length()) {
//                    int nextChar = word.charAt(i + 1);
//                    int replacementChar = currentCharVal + 13;
//                    if (Math.abs(replacementChar - replacementChar) <= 1) {
//                    }
//                }
            }
//            previousCharVal = currentCharVal;
        }
        System.out.println(numberOfFlips);
        return numberOfFlips;
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeAlmostEqualCharacters("aaaaa");
        sol.removeAlmostEqualCharacters("abddez");
        sol.removeAlmostEqualCharacters("zyxyxyz");



    }
}
