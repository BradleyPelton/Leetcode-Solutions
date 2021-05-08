package contests2020q4.leetcode20201017;

import java.util.ArrayList;
import java.util.Arrays;

class RENAMED {
    public String findLexSmallestString(String s, int a, int b) {

        ArrayList<String> allCombos = new ArrayList<>();

        String sleb = "123456";

        allCombos.add(s);
        for(int i=0; i< 51; i++){
            for(int j=0; j<51; j++){
                s = addAll(s, a);
                allCombos.add(s);

            }
            s = rotate(s,b);
        }

//        System.out.println(Arrays.deepToString(allCombos.toArray()));

        String[] combosArray = allCombos.toArray(new String[allCombos.size()]);
//        System.out.println(Arrays.toString(combosArray));

        Arrays.sort(combosArray);
        String ans = combosArray[0];
        System.out.println("final answer is " + ans);

        return ans;

    }

    public String rotate(String aString, int b){
        int aStringLength = aString.length();
        String newString = aString.substring(b, aStringLength) + aString.substring(0, b);


        return newString;
    }

    public String addAll(String aString, int a){
        String afterString = "";
        for(int i=0; i<aString.length(); i++){
            if(i%2 == 1){
                int tempInt = Integer.parseInt(aString.substring(i, i+1));
                tempInt += a;
                tempInt = tempInt % 10;

                String tempString = String.valueOf(tempInt);
                afterString += tempString;
//                System.out.println("tempString is equal to " + tempString);
            } else{
                afterString += aString.substring(i, i+1);
            }
        }
        return afterString;
    }
}