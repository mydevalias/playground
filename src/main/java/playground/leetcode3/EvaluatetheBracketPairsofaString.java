package playground.leetcode3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluatetheBracketPairsofaString {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> pls = getStringMap(knowledge);

        StringBuilder ret = new StringBuilder();
        StringBuilder current = new StringBuilder();
        boolean open = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open = true;
                current.setLength(0);
            } else if (c == ')') {
                open = false;
                ret.append(pls.getOrDefault(current.toString(), "?"));
            } else if (open) {
                current.append(c);
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }

    private static Map<String, String> getStringMap(List<List<String>> knowledge) {
        Map<String, String> pls = new HashMap<>();
        for (List<String> pl : knowledge) {
            pls.put(pl.get(0), pl.get(1));
        }
        return pls;
    }

    public String slowEvaluate(String s, List<List<String>> knowledge) {
        for (var pl : knowledge) {
            var name = pl.get(0);
            var val = pl.get(1);
            s = s.replaceAll("\\(" + name + "\\)", val);
        }
        return s.replaceAll("\\([^)]*\\)", "?");
    }

}
