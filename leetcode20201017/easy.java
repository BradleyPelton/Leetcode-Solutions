class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {


        int maxDistance = -1;
        for(int i=0; i<s.length(); i++){
            int lastOcc = s.lastIndexOf(s.charAt(i));
            int thisLongestSub = -1;

            if (lastOcc == i){
                continue;
            } else if( lastOcc == i+1){
                thisLongestSub = 0;
            } else {
                thisLongestSub = lastOcc - i - 1;
            }

            if (thisLongestSub > maxDistance){
                maxDistance = thisLongestSub;
            }
        }

//        System.out.println(maxDistance);

        return maxDistance;
    }
}
