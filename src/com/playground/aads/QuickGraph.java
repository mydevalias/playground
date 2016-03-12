package com.playground.aads;

import java.util.TreeMap;

/**
 * Created by liviu on 12.03.2016.
 */
//TODO spare array; spare matrix
public class QuickGraph {

    final TreeMap<Integer, Integer>[] nodes;

    final boolean directed;

    public QuickGraph(int noOfNodes) {
        nodes = new TreeMap[noOfNodes];//ugly yea
        directed = true;
    }

    public QuickGraph(int noOfNodes, boolean directed) {
        nodes = new TreeMap[noOfNodes];//ugly yea
        this.directed = directed;
    }

    private TreeMap<Integer, Integer> getNode(int n) {
        TreeMap<Integer, Integer> map = nodes[n];
        if (map == null) {
            map = new TreeMap<>();
            nodes[n] = map;
        }
        return map;
    }

    private void addLink(int from, int to, int distance) {
        TreeMap<Integer, Integer> node = getNode(from);
        node.put(to, distance);
    }

    public void put(int from, int to, int distance) {
        addLink(from, to, distance);
        if (directed) {
            addLink(to, from, distance);
        }
    }

    public Integer get(int from, int to) {
        TreeMap<Integer, Integer> node = getNode(from);
        return node.get(to);
    }

    public TreeMap<Integer, Integer> getNodeMap(int current) {
        return getNode(current);
    }

    public int size() {
        return nodes.length;
    }
}