package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(h) + Integer.bitCount(j) == turnedOn) {
                    res.add(h + ":" + (j >= 10 ? j : "0" + j));
                }
            }
        }
        return res;
    }

}
