package playground.leetcode3;

import java.util.*;

public class RemoveMethodsFromProject {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] invocation : invocations) {
            HashSet<Integer> c = graph.computeIfAbsent(invocation[0], el -> new HashSet<>());
            c.add(invocation[1]);
        }

        HashSet<Integer> calls = bfs(k, graph);

        for (int[] invocation : invocations) {
            if (!calls.contains(invocation[0]) && calls.contains(invocation[1])) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!calls.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private HashSet<Integer> bfs(int k, HashMap<Integer, HashSet<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.offer(k);
        visited.add(k);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer i : graph.getOrDefault(cur, new HashSet<>())) {
                if (visited.add(i)) {
                    queue.offer(i);
                }
            }
        }
        return visited;
    }

}
