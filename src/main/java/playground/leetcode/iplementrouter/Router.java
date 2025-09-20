package playground.leetcode.iplementrouter;

import java.util.*;

public class Router {

    private static long sequenceCounter = 0;
    final int memoryLimit;

    final TreeSet<Packet> packets;
    final Map<Integer, TreeSet<Integer>> destData;

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
            var r = getPacket();
            packets.remove(r);
        }

        return packets.add(p);
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        }
        var p = getPacket();
        return new int[]{p.source, p.destination, p.timestamp};
    }

    private Packet getPacket() {
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

    public int getCount(int destination, int startTime, int endTime) {
        int c = 0;
        for (Packet value : packets) {
            if (destination != value.destination) {
                continue;
            }
            if (value.timestamp > endTime) {
                break;
            }
            if (value.timestamp >= startTime) {
                c++;
            }
        }
        return c;
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


        // Comparable implementation - primary sort by timestamp, then source, then destination
        @Override
        public int compareTo(Packet other) {
            int timestampComparison = Integer.compare(this.timestamp, other.timestamp);
            if (timestampComparison != 0) {
                return timestampComparison;
            }

            int sourceComparison = Integer.compare(this.source, other.source);
            if (sourceComparison != 0) {
                return sourceComparison;
            }

            return Integer.compare(this.destination, other.destination);
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
