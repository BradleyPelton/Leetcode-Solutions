package contests.contests2024.lc0203.hard;



// Unbelievable.
// I just resubmitted my solution for mediumone and it was accepted first try
// Accepted after 2 minutes.

// First hard problem in a contest ever?
// All 4 questions answered.



class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int numberOfOperations = 0;
        String currWord = word;
        while (!currWord.isEmpty()) {
            numberOfOperations++;
            if (currWord.length() < k) { // out of characters
                return (int) Math.ceil((word.length() + 0.0) / k);
            }
            currWord = currWord.substring(k);
            if (word.startsWith(currWord)) {
                return numberOfOperations;
            }
        }
        throw new IllegalStateException("finished without returning");
    }
}
