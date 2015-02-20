package com.playground.aads;

/**
 * also called union find...
 * <p/>
 * https://community.topcoder.com/tc?module=Static&d1=tutorials&d2=disjointDataStructure
 *
 * will use this for Kruskal algorithm
 * <p/>
 * User: liviu
 * Date: 3/2/14
 * Time: 8:46 PM
 */
public class DisjointSetForests {

    private int[] ids;
    private int[] sizes;

    public DisjointSetForests(int n) {
        if (n < 0) throw new IllegalArgumentException();
        ids = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }


    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (sizes[i] < sizes[j]) {
            ids[i] = j;
            sizes[j] += sizes[i];
        } else {
            ids[j] = i;
            sizes[i] += sizes[j];
        }
    }

}
