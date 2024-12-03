package contests.contests2024.lc1026.hardone;

class Solution {
    public int subsequencePairCount(int[] nums) {


        final long rem = 1_000_000_007L;
        return 42;

    }

    public static long gcdByEuclidsAlgorithm(long n1, long n2) {
        // the complexity of Euclid’s algorithm is O(Log min(n1, n2))
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}



class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();




    }
}