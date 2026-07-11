package playground.leetcode2;

import java.util.*;

public class CountTheNumberOfCompleteComponents {

    private int[] connected;
    private Map<Integer, BitSet> graph;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new HashMap<>();
        for (int[] e : edges) {
            BitSet from = graph.computeIfAbsent(e[0], k -> new BitSet(n));
            from.set(e[1]);
            BitSet to = graph.computeIfAbsent(e[1], k -> new BitSet(n));
            to.set(e[0]);
        }


        connected = new int[n];
        Arrays.fill(connected, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, i);
        }

        Set<Integer> connectedSet = new HashSet<>();
        for (int value : connected) {
            connectedSet.add(value);
        }

        return connectedSet.size();

    }

    private void dfs(int pos, int id) {
        if (connected[pos] > -1) {
            return;
        }
        connected[pos] = id;
        BitSet bitSet = graph.get(pos);
        if(bitSet==null){
            return;
        }
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            dfs(i, id);
        }
    }

}
