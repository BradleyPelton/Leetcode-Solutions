package contests.contests2022.lc0402.mediumtwo;

// First attempt time limit exceeded

class Solution {
    public long numberOfWays(String s) {

        long zeroCount = s.chars().filter(ch -> ch == '0').count();
        long oneCount = s.length() - zeroCount;

        long numberOfZeroesLeft = zeroCount;
        long numberOfOnesLeft = oneCount;
        long[] numberOfZeroesAfterCurrentIndex = new long[s.length()];
        long[] numberOfOnesAfterCurrentIndex =  new long[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '0') {
                numberOfZeroesLeft--;
            } else {
                numberOfOnesLeft--;
            }
            numberOfZeroesAfterCurrentIndex[i] = numberOfZeroesLeft;
            numberOfOnesAfterCurrentIndex[i] = numberOfOnesLeft;
        }


        long finalAns = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '0') {
                long oneZeroCount = numberOfOneZeroes(i, s.substring(i), numberOfZeroesAfterCurrentIndex);
                finalAns += oneZeroCount;
            } else {
                long zeroOneCount = numberOfZeroOnes(i, s.substring(i), numberOfOnesAfterCurrentIndex);
                finalAns += zeroOneCount;
            }
        }

        System.out.println("final ans = " + finalAns);
        return finalAns;
    }

    private long numberOfZeroOnes(int currIndex, String substring, long[] numberOfOnesAfterCurrentIndex) {
        long zeroOneCount = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '0') {
                int realIndex = currIndex + i;
                long numberOfOnesLeft = numberOfOnesAfterCurrentIndex[realIndex];
                zeroOneCount += numberOfOnesLeft;
            }
        }
        return zeroOneCount;
    }

    private long numberOfOneZeroes(int currIndex, String substring, long[] numberOfZeroesAfterCurrentIndex) {
        long oneZeroCount = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '1') {
                int realIndex = currIndex + i;
                long numberOfZeroesLeft = numberOfZeroesAfterCurrentIndex[realIndex];
                oneZeroCount += numberOfZeroesLeft;
            }
        }
        return oneZeroCount;
    }
}


class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.numberOfWays("001101");
        sol.numberOfWays("11100");
    }
}
