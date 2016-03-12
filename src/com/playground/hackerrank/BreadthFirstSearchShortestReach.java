package com.playground.hackerrank;


import com.playground.aads.QuickGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by liviu on 12.03.2016.
 */
public class BreadthFirstSearchShortestReach {

    public static void main(String... args) throws FileNotFoundException {
        HackeRrankUtils hru = new HackeRrankUtils();
        int testCaseCount = hru.scanner.nextInt();
        for (int t = 0; t < testCaseCount; t++) {
            int n = hru.scanner.nextInt();n++;
            int edgesCount = hru.scanner.nextInt();
            QuickGraph qg = new QuickGraph(n);
            for (int i = 0; i < edgesCount; i++) {
                int from = hru.scanner.nextInt();
                int to = hru.scanner.nextInt();
                qg.put(from, to, 1);
            }
            int start = hru.scanner.nextInt();
            solve(hru, qg, start);
            hru.line();
        }
        hru.printBuilder();
    }

    private static void solve(HackeRrankUtils hru, QuickGraph qg, int start) {
        int distances[] = new int[qg.size()];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Integer> cost = new HashMap<>();
        queue.add(start);
        cost.put(start, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
                Integer c = cost.get(current);
                distances[current] = c;
                int newCost = c + 6;
                for (int to : qg.getNodeMap(current).keySet()) {
                    if (distances[to] == -1 && !cost.containsKey(to)) {
                        queue.add(to);
                        cost.put(to, newCost);
                    }
            }
        }

        for (int i = 1; i < distances.length; i++) {
            if (i != start) {
                hru.output.append(distances[i]).append(" ");
            }
        }
    }

    public static class HackeRrankUtils {

        File file = new File("inputs/graph/in.txt");

        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        public HackeRrankUtils() throws FileNotFoundException {
            scanner = new Scanner(file);
        }

        void printBuilder() {
            System.out.print(output.toString());
        }

        void line() {
            output.append(System.lineSeparator());
        }

        String nextLine() {
            return scanner.nextLine();
        }

    }


}
