package contests.contests2023.lc0128.mediumone;

// Fundamental misunderstanding of a lot of things here
// Lossy conversion
// Big integer taking up WAYYY too much memory
// Addition of modular arithmetic (a + b) mod m = ((a mod m) + (b mod m)) mod m

class Solution {
    public int monkeyMove(int n) {
//        BigInteger pow = BigInteger.valueOf(2).pow(n);
//        BigInteger subtract = pow.subtract(BigInteger.valueOf(2));
//        BigInteger mod = subtract.mod(BigInteger.valueOf(1000000007));
//        return mod.intValue();

//        return BigInteger.valueOf(2)
//                .modPow(BigInteger.valueOf(n), BigInteger.valueOf(1000000007))
//                .subtract(BigInteger.valueOf(2))
//                .intValue();

        return (int) (((modPow(2, n) % 1000000007) + 1000000005) % 1000000007);

//        int m = BigInteger.valueOf(2)
//                .modPow(BigInteger.valueOf(n), BigInteger.valueOf(1000000007)).intValue();
//        int ans = ;
//        return m;
    }

    long modPow(long x, long y) {
        // Well known "modPow" function for fast power mod a number.
        if (y == 0)
            return 1;
        long p = modPow(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % 1000000007;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.monkeyMove(3)); // 6
        System.out.println(sol.monkeyMove(4)); // 14
        System.out.println(sol.monkeyMove(55)); // expected 766_762_394
        System.out.println(sol.monkeyMove(500000003)); // expected 1_000_000_006
    }
}