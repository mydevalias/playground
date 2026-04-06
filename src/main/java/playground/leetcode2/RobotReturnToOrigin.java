package playground.leetcode2;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int i = 0;
        int j = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                i--;
            }
            if (c == 'D') {
                i++;
            }
            if (c == 'L') {
                j--;
            }
            if (c == 'R') {
                j++;
            }
        }
        return i == 0 && j == 0;
    }

}
