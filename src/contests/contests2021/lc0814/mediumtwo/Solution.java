package contests.contests2021.lc0814.mediumtwo;

class Solution {
    public int minNonZeroProduct(int p) {

        // Thus (2**p - 3)/2 number of pairs

        final long rem = 1_000_000_007L;

//        long ans = (int) Math.pow(2,p) - 1;
        long END_VAL = modPow(2,p) - 1;
        long pairVal = modPow(2, p) - 2;
        long numberOfPairs = (modPow(2,p) - 1)/2;
        int ans = (int)((END_VAL * (modPow(pairVal, numberOfPairs))) % rem);
        System.out.println("final ans is " + ans);
        return ans;

//        ans *= Math.pow(2,p) - 2;

//        2(Math.pow(2,p-1) - 1);

//        BigInteger totalNumberOfPairs = BigInteger.valueOf(2).pow(p);
//        BigInteger a =  totalNumberOfPairs.subtract(BigInteger.valueOf(3));
//        BigInteger b = a.divide(BigInteger.valueOf(2));
//        BigInteger c = b.mod(BigInteger.valueOf(1000000007L));
//
//        BigInteger


//            BigInteger b = BigInteger.valueOf(5).pow(numOfPowers).mod(BigInteger.valueOf(1000000007L));
//            totalNumber = a.multiply(b);

//        int ans = totalNumber.mod(BigInteger.valueOf(1000000007L)).intValue();


//        2**p - 3  numbers between (1,2**p-1)
        // Thus ((2**p - 1) - 2 - 3)/2 number of pairs
        // Thus



//
//        int nMod = (int)(n % rem);
//
//        System.out.println(nMod);
//
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

        sol.minNonZeroProduct(1);  // 1
        sol.minNonZeroProduct(2);  // 6
        sol.minNonZeroProduct(3);  // 1512
        sol.minNonZeroProduct(4);
        sol.minNonZeroProduct(5); //EXPECTED 202795991
    }
}