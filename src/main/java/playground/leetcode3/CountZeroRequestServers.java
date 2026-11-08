package playground.leetcode3;

import java.util.*;

public class CountZeroRequestServers {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int[][] sorted = sortedQueries(queries);

        Map<Integer, Integer> serverCount = new HashMap<>();
        int left = 0;
        int right = 0;

        int res[] = new int[queries.length];
        for (var q : sorted) {
            int end = q[0];
            int start = end - x;

            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];
                serverCount.put(server, serverCount.getOrDefault(server, 0) + 1);
                right++;
            }
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];
                int count = serverCount.get(server) - 1;
                if (count == 0) {
                    serverCount.remove(server);
                } else {
                    serverCount.put(server, count);
                }
                left++;
            }

            res[q[1]] = n - serverCount.size();

        }

        return res;
    }

    private static int[][] sortedQueries(int[] queries) {
        int[][] sorted = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sorted[i][0] = queries[i]; // value
            sorted[i][1] = i;          // original position
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        return sorted;
    }

    private static int[] slow(int n, int[][] logs, int x, int[] queries) {
        Map<Integer, List<Integer>> timestampsToServer = new HashMap<>();
        for (var log : logs) {
            List<Integer> cur = timestampsToServer.computeIfAbsent(log[1], k -> new ArrayList<>());
            cur.add(log[0]);
        }
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Set<Integer> activeServers = new HashSet<>();
            for (int t = queries[i] - x; t <= queries[i]; t++) {
                List<Integer> integers = timestampsToServer.get(t);
                if (integers != null) {
                    activeServers.addAll(integers);
                }
            }
            res[i] = n - activeServers.size();
        }
        return res;
    }

}
