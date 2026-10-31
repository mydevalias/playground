package playground.leetcode3;

public class CreateGridWithExactlyOnePath {

    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        res[0] = new StringBuilder().repeat('.', n).toString();
        String l = new StringBuilder().repeat('#', n - 1).append('.').toString();
        for (int i = 1; i < m; i++) {
            res[i] = l;
        }
        return res;
    }

}
