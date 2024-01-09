package contests.contests2021.lc1023.easy;

// Accepted after 14 minutes

// Long but trivial. Only 570 accepted solutions after 15 minutes


class Solution {
    public int countValidWords(String sentence) {

        String[] tokens = sentence.split(" ");

        int numValidWords = 0;

        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            }

            if (token.contains("0")
                    || token.contains("1")
                    || token.contains("2")
                    || token.contains("3")
                    || token.contains("4")
                    || token.contains("5")
                    || token.contains("6")
                    || token.contains("7")
                    || token.contains("8")
                    || token.contains("9")
            ) {
                continue;
            }

            long numOfBangs  = token.chars().filter(ch -> ch == '!').count();
            if (numOfBangs > 1) {
                continue;
            } else if (numOfBangs == 1) {
                int bangIndex = token.indexOf("!");
                if (bangIndex != token.length() - 1) {
                    continue;
                }
            }

            long numOfPeriods  = token.chars().filter(ch -> ch == '.').count();
            if (numOfPeriods > 1) {
                continue;
            } else if (numOfPeriods == 1) {
                int periodIndex = token.indexOf(".");
                if (periodIndex != token.length() - 1) {
                    continue;
                }
            }

            long numOfCommas  = token.chars().filter(ch -> ch == ',').count();
            if (numOfCommas > 1) {
                continue;
            } else if (numOfCommas == 1) {
                int commaIndex = token.indexOf(",");
                if (commaIndex != token.length() - 1) {
                    continue;
                }
            }


            long numOfHyphens  = token.chars().filter(ch -> ch == '-').count();
            if (numOfHyphens > 1) {
                continue;
            } else if (numOfHyphens == 1) {
                int tokenIndex = token.indexOf("-");
                if (tokenIndex == 0 || tokenIndex == token.length() -1){
                    continue;
                } else {
                    char leftChar = token.charAt(tokenIndex - 1);
                    char rightChar = token.charAt(tokenIndex + 1);

                    if (!(Character.isLetter(leftChar) && Character.isLetter(rightChar))) {
                        continue;
                    }
                }
            }

//            System.out.println("token is valid, token = " + token);
            numValidWords++;
        }

        System.out.println("final ans = " + numValidWords);
        return numValidWords;
    }
}
class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.countValidWords("cat and  dog");
        sol.countValidWords("!this  1-s b8d!");
        sol.countValidWords("alice and  bob are playing stone-game10");
        sol.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.");




    }
}