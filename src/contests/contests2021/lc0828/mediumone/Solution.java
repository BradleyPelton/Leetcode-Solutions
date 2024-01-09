package contests.contests2021.lc0828.mediumone;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;


// Accepted after 20 minutes

// Accepted after 3 attempts

// nothing is more of a reminder that Java can be painful than working with BigIntegers
// stupid type system

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        BigInteger[] bigIntArr = new BigInteger[nums.length];

        for (int i = 0; i < nums.length; i++) {
            bigIntArr[i] = new BigInteger(nums[i]);
        }

        var bigList = Arrays.stream(bigIntArr).sorted().collect(Collectors.toList());

        String ansStr = bigList.get(bigList.size() - k).toString();
        System.out.println(ansStr);
        return String.valueOf(ansStr);

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.kthLargestNumber(new String[]{"3","6","7","10"}, 4);
        sol.kthLargestNumber(new String[]{"2","21","12","1"}, 3);
        sol.kthLargestNumber(new String[]{"0","0"}, 2);

        // expected
        sol.kthLargestNumber(new String[]{"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"}, 11);

//        ["623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"]
//        11

        // expected 3
        sol.kthLargestNumber(new String[]{"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"},
                9
        );
    }
}