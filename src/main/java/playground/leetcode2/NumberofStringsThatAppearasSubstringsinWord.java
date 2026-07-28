package playground.leetcode2;

public class NumberofStringsThatAppearasSubstringsinWord {

    public int numOfStrings(String[] patterns, String word) {
        int ret = 0;
        for (String s : patterns) {
            if (word.contains(s)) {
                ret++;
            }
        }
        return ret;
    }

}
