package contests.contests2021.lc0703.mediumtwo;

import java.math.BigInteger;

class Solution {
    public int countGoodNumbers(long n) {

        if (n == 1) {
            System.out.println("5");
            return 5;
        }

        BigInteger totalNumber = new BigInteger("1");

//        for (int i = 0; i < n; i++) {
//            if (i % 2 == 0) {
//                totalNumber = totalNumber.multiply(BigInteger.valueOf(5));
//            } else {
//                totalNumber = totalNumber.multiply(BigInteger.valueOf(4));
//            }
//        }

        final long rem = 1_000_000_007L;
        int nMod = (int)(n % rem);

        System.out.println(nMod);


//        20 = 2 * 2 * 5;
//        int numOfPowers = nMod/2;


//        int ans = Math.pow(5,numOfPowers) * Math.pow(4,numOfPowers);
//        int ans = (5**219817231 * 4**219817231) %100000007L;


        if (n % 2 == 0) {
            int numOfPowers = nMod/2;
//            totalNumber = totalNumber.multiply(BigInteger.valueOf(20).pow(numOfPowers));
            BigInteger a = totalNumber.multiply(BigInteger.valueOf(2).pow(nMod)).mod(BigInteger.valueOf(1000000007L));
            BigInteger b = BigInteger.valueOf(5).pow(numOfPowers).mod(BigInteger.valueOf(1000000007L));
            totalNumber = a.multiply(b);
        } else {
            int numOfPowers = nMod/2;
            totalNumber = totalNumber.multiply(BigInteger.valueOf(20).pow(numOfPowers));
            totalNumber = totalNumber.multiply(BigInteger.valueOf(5));
        }

        int ans = totalNumber.mod(BigInteger.valueOf(1000000007L)).intValue();


//        System.out.println("final ans is " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.countGoodNumbers(1);
//        sol.countGoodNumbers(4);
//        sol.countGoodNumbers(50);
//        sol.countGoodNumbers(452418);
//        sol.countGoodNumbers(3);  //Expecetd 100
        sol.countGoodNumbers(806166225460392L);
    }
}
