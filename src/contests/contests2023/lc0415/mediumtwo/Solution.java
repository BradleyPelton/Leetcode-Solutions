package contests.contests2023.lc0415.mediumtwo;

// Accepted second attempt
// Accepted after 20 minutes
// First attempt was wrong when I tried to trivialize

class Solution {
    public int addMinimum(String word) {

//        word = word.replace("abc", ""); // remove all trivial cases

        int numberOfInsertions = 0;

        String currString = "";
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);

            if (currLetter == 'a') {
                if (currString.equals("")) {
                    currString = "a";
                } else if (currString.equals("a")) {
                    numberOfInsertions++; // b after
                    numberOfInsertions++; // c after
                    currString = "a";
                } else if (currString.equals("ab")) {
                    numberOfInsertions++; // c after
                    currString = "a";
                }
            } else if (currLetter == 'b') {
                if (currString.equals("")) {
                    numberOfInsertions++; // a before
                    currString = "ab";
                } else if (currString.equals("a")) {
                    currString = "ab";
                } else if (currString.equals("ab")) {
                    numberOfInsertions++; // c after
                    numberOfInsertions++; // a before
                    currString = "ab";
                }
            } else if (currLetter == 'c') {
                if (currString.equals("")) {
                    numberOfInsertions++; // a before
                    numberOfInsertions++; // b before
                    currString = "";
                } else if (currString.equals("a")) {
                    numberOfInsertions++; // b between
                    currString = "";
                } else if (currString.equals("ab")) {
                    currString = "";
                }
            }
        }

        // finish string
        if (currString.equals("")) {
        } else if (currString.equals("a")) {
            numberOfInsertions++; // b after
            numberOfInsertions++; // c after
        } else if (currString.equals("ab")) {
            numberOfInsertions++; // c after
        }




        System.out.println("ans = " + numberOfInsertions);
        return numberOfInsertions;


    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.addMinimum("b");
        sol.addMinimum("aaa");
        sol.addMinimum("abc");
        sol.addMinimum("aaabcb"); // expected 6
    }
}