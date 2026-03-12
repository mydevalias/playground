package playground.leetcode2;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public boolean checkOnesSegment(String s) {
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1' && s.charAt(i-1)=='1'){
                return true;
            }
        }
        return false;
    }

}
