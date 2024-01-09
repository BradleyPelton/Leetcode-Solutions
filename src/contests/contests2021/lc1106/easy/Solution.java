package contests.contests2021.lc1106.easy;

// Absolutely hideous solution
// 21 minutes, accepted first try

// I wasnt the only one who struggled with this problem
// Tricky easy

class Solution {
    public int countVowelSubstrings(String word) {

        int ans = 0;

//        String currSubString = "";
//
//        ArrayList<String> vowelSubs = new ArrayList<>();
//
//        for (int i = 0; i < word.length(); i++) {
//            char currentChar = word.charAt(i);
//            // IF NEXT NOT VOWEL
//            if (currentChar != 'a' && currentChar != 'e' && currentChar != 'i' && currentChar != 'o' && currentChar != 'u') {
//                vowelSubs.add(currSubString);
//                currSubString = "";
//            // ELSE IS VOWEL
//            } else {
//                currSubString = currSubString + currentChar;
//            }
////            System.out.println(currSubString);
//        }
//
//        for (String vowelSub : vowelSubs) {
//            ans +=
//
//        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = i+1; j < word.length(); j++) {
                String subStr = word.substring(i, j+1);
                if (subStr.contains("a")
                        && subStr.contains("e")
                        && subStr.contains("i")
                        && subStr.contains("o")
                        && subStr.contains("u")
                ) {
                    if (subStr.contains("b")
                            || subStr.contains("c")
                            || subStr.contains("d")
                            || subStr.contains("f")
                            || subStr.contains("g")
                            || subStr.contains("h")
                            || subStr.contains("j")
                            || subStr.contains("k")
                            || subStr.contains("l")
                            || subStr.contains("m")
                            || subStr.contains("n")
                            || subStr.contains("p")
                            || subStr.contains("q")
                            || subStr.contains("r")
                            || subStr.contains("s")
                            || subStr.contains("t")
                            || subStr.contains("v")
                            || subStr.contains("w")
                            || subStr.contains("x")
                            || subStr.contains("y")
                            || subStr.contains("z")
                    ) {
                        continue;
                    } else {
//                        System.out.println(subStr);
                        ans += 1;
                    }
                }
            }
        }


        System.out.println("final ans = " + ans);
        return ans;

    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countVowelSubstrings("aeiouu");
        sol.countVowelSubstrings("unicornarihan");
        sol.countVowelSubstrings("cuaieuouac");
        sol.countVowelSubstrings("bbaeixoubb");
    }
}
