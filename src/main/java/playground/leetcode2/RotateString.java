package playground.leetcode2;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        for(int i=0;i<s.length();i++){
            if(s.equals(goal)){
                return true;
            }
            s = rotateS(s);
        }

        return false;
    }

    private String rotateS(String s) {
        return s.substring(1) + s.charAt(0);
    }

}
