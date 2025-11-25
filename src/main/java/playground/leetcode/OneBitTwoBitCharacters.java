package playground.leetcode;

public class OneBitTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        boolean last = false;
        while (i < bits.length) {
            if (bits[i] == 1) {
                last = true;
                i++;
            } else {
                last = false;
            }
            i++;
        }
        return !last;
    }

}
