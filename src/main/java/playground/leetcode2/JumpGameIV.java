package playground.leetcode2;

import java.util.*;

public class JumpGameIV {

    record Path(int pos, int steps) {
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> cache = positions(arr);
        Set<Integer> visited = new HashSet<>();
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(0, 0));
        visited.add(0);
        int min = arr.length;

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            int steps = path.steps;
            search(arr, path.pos - 1, steps, queue, visited);
            search(arr, path.pos + 1, steps, queue, visited);
            for (var others : cache.getOrDefault(arr[path.pos], List.of())) {
                search(arr, others, steps, queue, visited);
            }

            cache.remove(arr[path.pos]);
            if (path.pos == arr.length - 1) {
                min = Math.min(steps, min);
            }
        }
        return min;
    }

    private static Map<Integer, List<Integer>> positions(int[] arr) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            cache.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }
        return cache;
    }


    private void search(int[] arr, int next, int steps, Queue<Path> queue, Set<Integer> visited) {
        if (next >= 0 && next < arr.length && !visited.contains(next)) {
            visited.add(next);
            queue.add(new Path(next, steps + 1));
        }
    }
}
