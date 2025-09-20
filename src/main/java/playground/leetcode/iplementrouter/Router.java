package playground.leetcode.iplementrouter;

import java.util.TreeSet;

public class Router {

    final int memoryLimit;

    final TreeSet<Packet> packets;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new TreeSet<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);

        if (packets.contains(p)) {
            return false;
        }

        if (packets.size() >= memoryLimit) {
            packets.pollFirst();
        }

        return packets.add(p);
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        }
        var p = packets.pollFirst();
        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        int c = 0;
        for (Packet value : packets) {
            if (destination != value.destination) {
                continue;
            }
            if (value.timestamp >= startTime && value.timestamp <= endTime) {
                c++;
            }
        }
        return c;
    }


    static class Packet implements Comparable<Packet> {
        private int source;
        private int destination;
        private int timestamp;

        // Constructor
        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
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
