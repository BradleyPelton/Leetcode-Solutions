package contests.contests2024.lc0720.mediumone;

// Accepted after 30 minutes
// Took me 23 minutes to figure out the trick.


// I thought this was a simulation proble, but it was a simple deduction problem.

// Bad bad bad

class Solution {
    public boolean doesAliceWin(String s) {
        boolean ans = doesAliceWin(s, true);
        System.out.println(ans);
        return ans;
    }

    private boolean doesAliceWin(String s, boolean isAliceTurn) {
        if (s.isEmpty()) {
            if (isAliceTurn) {
                return false;
            } else {
                return true;
            }
        }

        int numberOfVowels = 0;
        int firstVowel = Integer.MIN_VALUE;
        int lastVowel = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a'
                    || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u'
            ) {
                numberOfVowels++;

                if (firstVowel == Integer.MIN_VALUE) {
                    firstVowel = i;
                }
                lastVowel = i;
            }
        }

        if (numberOfVowels == 0) {
            if (isAliceTurn) {
                return false; // Alice can't make a move
            } else {
                return true; // Bob chops the entire string
            }
        }


        if (numberOfVowels % 2 == 0) {
            if (isAliceTurn) { // even number of vowels

                // After chop, there is now an odd number of vowels
                return true;



            } else { // else bob turn
                return false; // Bob chops the entire string
            }
        } else { // numberOfVowels % 1 == 1
            if (isAliceTurn) {
                return true; // Alice chops the entire string
            } else {

                // After chop, there is an even number of
                return false;



            }
        }
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.doesAliceWin("leetcoder");
        sol.doesAliceWin("bbcd");



    }
}
