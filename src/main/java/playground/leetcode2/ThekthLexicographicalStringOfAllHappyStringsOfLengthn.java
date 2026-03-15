package playground.leetcode2;

public class ThekthLexicographicalStringOfAllHappyStringsOfLengthn {

    String res;
    char cs[] = new char[]{'a', 'b', 'c'};
    int n, k;

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        backGen(0, new StringBuilder());
        return res;
    }

    private int backGen(int found, StringBuilder sb) {
        if (res != null) {
            return found;
        }
        if (sb.length() == n) {
            found++;
            if (found == k) {
                res = sb.toString();
            }
            return found;
        }
        for (char c : cs) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                continue;
            }
            found = backGen(found, sb.append(c));
            sb.deleteCharAt(sb.length() - 1);
        }
        return found;
    }


}
