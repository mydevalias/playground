package playground.leetcode.iplementrouter;

import java.util.*;

public class Router {

    private static long sequenceCounter = 0;
    final int memoryLimit;

    final TreeSet<Packet> packets;
    final Map<Integer, TreeMap<Integer, Integer>> destData;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new TreeSet<>();
        this.destData = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);

        if (packets.contains(p)) {
            return false;
        }

        if (packets.size() >= memoryLimit) {
            forwardPacket();
        }

        boolean added = packets.add(p);
        if (added) {
            destData.computeIfAbsent(destination, k -> new TreeMap<>())
                    .merge(timestamp, 1, Integer::sum);
        }
        return added;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        }
        var p = findNext();
        removeFromDestData(p.destination, p.timestamp);
        return new int[]{p.source, p.destination, p.timestamp};
    }

    private Packet findNext() {
        var p = packets.pollFirst();
        if (!packets.isEmpty() && p.timestamp == packets.first().timestamp) {
            Set<Packet> toAdd = new HashSet<>();
            Packet ret = p;
            toAdd.add(p);
            while (!packets.isEmpty() && p.timestamp == packets.first().timestamp) {
                p = packets.pollFirst();
                toAdd.add(p);
                if (ret.sequence > p.sequence) {
                    ret = p;
                }
            }
            toAdd.remove(ret);
            p = ret;
            packets.addAll(toAdd);
        }
        return p;
    }

    private void removeFromDestData(int destination, int timestamp) {
        TreeMap<Integer, Integer> destMap = destData.get(destination);
        if (destMap != null) {
            Integer count = destMap.get(timestamp);
            if (count != null) {
                if (count == 1) {
                    destMap.remove(timestamp);
                    if (destMap.isEmpty()) {
                        destData.remove(destination);
                    }
                } else {
                    destMap.put(timestamp, count - 1);
                }
            }
        }
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> timestampCounts = destData.get(destination);
        if (timestampCounts == null || timestampCounts.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Integer packetCount : timestampCounts.subMap(startTime, true, endTime, true).values()) {
            count += packetCount;
        }
        return count;
    }


    static class Packet implements Comparable<Packet> {
        private final int source;
        private final int destination;
        private final int timestamp;
        private final long sequence;

        // Constructor
        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
            this.sequence = sequenceCounter++;
        }


        @Override
        public int compareTo(Packet other) {
            if (this.timestamp != other.timestamp) {
                return this.timestamp - other.timestamp;
            }

            if (this.source != other.source) {
                return this.source - other.source;
            }

            return this.destination - other.destination;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Packet packet = (Packet) obj;
            return source == packet.source &&
                    destination == packet.destination &&
                    timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return 31 * (31 * timestamp + source) + destination;
        }
    }
}