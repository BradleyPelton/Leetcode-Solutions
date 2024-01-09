package _Study.Problems.shortestCommonSupersequence;

import java.lang.instrument.Instrumentation;


/**
 * https://leetcode.com/problems/shortest-common-supersequence/description/
 * 1092. Shortest Common Supersequence
 *
 * Good problem. A twist on Longest Common SUB sequence.
 *
 *
 *
 */
class Solution {
    int[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i + 1][j],
                            dp[i][j + 1]
                    );
                }
            }
        }

        int longestCommonSubsequence = dp[0][0];
        int shortestSuperSequenceLength = str1.length() + str2.length() - longestCommonSubsequence;
        StringBuilder ansBuilder = new StringBuilder(shortestSuperSequenceLength);

        int index1 = 0;
        int index2 = 0;
        int ansIndex = 0;
        while (ansIndex < shortestSuperSequenceLength) {
            if (index1 == str1.length()) {
                ansBuilder.append(str2.substring(index2));
                break;
            } else if (index2 == str2.length()) {
                ansBuilder.append(str1.substring(index1));
                break;
            }
            if (str1.charAt(index1) == str2.charAt(index2)) {
                ansBuilder.append(str1.charAt(index1));
                index1++;
                index2++;
            } else {
                if (dp[index1 + 1][index2] < dp[index1][index2 + 1]) {
                    ansBuilder.append(str2.charAt(index2));
                    index2++;
                } else {
                    ansBuilder.append(str1.charAt(index1));
                    index1++;
                }
            }
            ansIndex++;
        }


        String ans = ansBuilder.toString();
        System.out.println(ans);
        return ans;
    }

//    String[][] dp;
//    public String shortestCommonSupersequence(String str1, String str2) { // Top Down - Memory Limit Exceeded.
//        dp = new String[str1.length()][str2.length()]; //  1_000_000 strings is a lot of memory
//        String ans = shortestCommonSupersequence(str1, str2, 0, 0);
//        System.out.println(ans);
//        return ans;
//    }
//
//    private String shortestCommonSupersequence(String s1, String s2, int index1, int index2) {
//        if (index1 == s1.length()) {
//            return s2.substring(index2);
//        } else if (index2 == s2.length()) {
//            return s1.substring(index1);
//        }
//
//        if (dp[index1][index2] != null) {
//            return dp[index1][index2];
//        }
//
//        String ansString;
//        if (s1.charAt(index1) == s2.charAt(index2)) {
//            ansString = s1.charAt(index1) + shortestCommonSupersequence(s1, s2, index1 + 1, index2 + 1);
//        } else {
//            String popLeft = s1.charAt(index1) + shortestCommonSupersequence(s1, s2, index1 + 1, index2);
//            String popRight = s2.charAt(index2) + shortestCommonSupersequence(s1, s2, index1, index2 + 1);
//
//            if (popLeft.length() < popRight.length()) {
//                ansString = popLeft;
//            } else {
//                ansString = popRight;
//            }
//        }
//        dp[index1][index2] = ansString;
//        return ansString;
//    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.shortestCommonSupersequence(
                "abac",
                "cab"
        );
        sol.shortestCommonSupersequence(
                "aaaaaaaa",
                "aaaaaaaa"
        );
        sol.shortestCommonSupersequence(
                "abc",
                "xyz"
        );



        sol.shortestCommonSupersequence(
                "atdznrqfwlfbcqkezrltzyeqvqemikzgghxkzenhtapwrmrovwtpzzsyiwongllqmvptwammerobtgmkpowndejvbuwbporfyroknrjoekdgqqlgzxiisweeegxajqlradgcciavbpgqjzwtdetmtallzyukdztoxysggrqkliixnagwzmassthjecvfzmyonglocmvjnxkcwqqvgrzpsswnigjthtkuawirecfuzrbifgwolpnhcapzxwmfhvpfmqapdxgmddsdlhteugqoyepbztspgojbrmpjmwmhnldunskpvwprzrudbmtwdvgyghgprqcdgqjjbyfsujnnssfqvjhnvcotynidziswpzhkdszbblustoxwtlhkowpatbypvkmajumsxqqunlxxvfezayrolwezfzfyzmmneepwshpemynwzyunsxgjflnqmfghsvwpknqhclhrlmnrljwabwpxomwhuhffpfinhnairblcayygghzqmotwrywqayvvgohmujneqlzurxcpnwdipldofyvfdurbsoxdurlofkqnrjomszjimrxbqzyazakkizojwkuzcacnbdifesoiesmkbyffcxhqgqyhwyubtsrqarqagogrnaxuzyggknksrfdrmnoxrctntngdxxechxrsbyhtlbmzgmcqopyixdomhnmvnsafphpkdgndcscbwyhueytaeodlhlzczmpqqmnilliydwtxtpedbncvsqauopbvygqdtcwehffagxmyoalogetacehnbfxlqhklvxfzmrjqofaesvuzfczeuqegwpcmahhpzodsmpvrvkzxxtsdsxwixiraphjlqawxinlwfspdlscdswtgjpoiixbvmpzilxrnpdvigpccnngxmlzoentslzyjjpkxemyiemoluhqifyonbnizcjrlmuylezdkkztcphlmwhnkdguhelqzjgvjtrzofmtpuhifoqnokonhqtzxmimp",
                "xjtuwbmvsdeogmnzorndhmjoqnqjnhmfueifqwleggctttilmfokpgotfykyzdhfafiervrsyuiseumzmymtvsdsowmovagekhevyqhifwevpepgmyhnagjtsciaecswebcuvxoavfgejqrxuvnhvkmolclecqsnsrjmxyokbkesaugbydfsupuqanetgunlqmundxvduqmzidatemaqmzzzfjpgmhyoktbdgpgbmjkhmfjtsxjqbfspedhzrxavhngtnuykpapwluameeqlutkyzyeffmqdsjyklmrxtioawcrvmsthbebdqqrpphncthosljfaeidboyekxezqtzlizqcvvxehrcskstshupglzgmbretpyehtavxegmbtznhpbczdjlzibnouxlxkeiedzoohoxhnhzqqaxdwetyudhyqvdhrggrszqeqkqqnunxqyyagyoptfkolieayokryidtctemtesuhbzczzvhlbbhnufjjocporuzuevofbuevuxhgexmckifntngaohfwqdakyobcooubdvypxjjxeugzdmapyamuwqtnqspsznyszhwqdqjxsmhdlkwkvlkdbjngvdmhvbllqqlcemkqxxdlldcfthjdqkyjrrjqqqpnmmelrwhtyugieuppqqtwychtpjmloxsckhzyitomjzypisxzztdwxhddvtvpleqdwamfnhhkszsfgfcdvakyqmmusdvihobdktesudmgmuaoovskvcapucntotdqxkrovzrtrrfvoczkfexwxujizcfiqflpbuuoyfuoovypstrtrxjuuecpjimbutnvqtiqvesaxrvzyxcwslttrgknbdcvvtkfqfzwudspeposxrfkkeqmdvlpazzjnywxjyaquirqpinaennweuobqvxnomuejansapnsrqivcateqngychblywxtdwntancarldwnloqyywrxrganyehkglbdeyshpodpmdchbcc"
        );
    }
}