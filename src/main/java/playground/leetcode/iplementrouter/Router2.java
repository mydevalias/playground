package playground.leetcode.iplementrouter;

import java.util.*;

public class Router2 {
    private static long sequenceCounter = 0;
    final int memoryLimit;

    final TreeSet<Long> packets;
    final Map<Integer, TreeMap<Integer, Integer>> destData;

    final Set<Long> packetKeys;

    public Router2(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new TreeSet<>();
        this.destData = new HashMap<>();
        this.packetKeys = new HashSet<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        long key = encodeKey(timestamp, source, destination);

        if (packetKeys.contains(key)) {
            return false;
        }

        if (packets.size() >= memoryLimit) {
            forwardPacket();
        }

        long packetData = encodePacket(timestamp, source, destination, sequenceCounter++);
        boolean added = packets.add(packetData);

        if (added) {
            packetKeys.add(key);
            destData.computeIfAbsent(destination, k -> new TreeMap<>())
                    .merge(timestamp, 1, Integer::sum);
        }
        return added;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        }
        long packetData = findNext();

        int timestamp = getTimestamp(packetData);
        int source = getSource(packetData);
        int destination = getDestination(packetData);

        packetKeys.remove(encodeKey(timestamp, source, destination));
        removeFromDestData(destination, timestamp);

        return new int[]{source, destination, timestamp};
    }

    private long findNext() {
        long first = packets.pollFirst();
        int firstTimestamp = getTimestamp(first);

        if (!packets.isEmpty() && getTimestamp(packets.first()) == firstTimestamp) {
            List<Long> toAdd = new ArrayList<>();
            long minSequencePacket = first;
            long minSequence = getSequence(first);

            while (!packets.isEmpty() && getTimestamp(packets.first()) == firstTimestamp) {
                long p = packets.pollFirst();
                long seq = getSequence(p);
                if (seq < minSequence) {
                    toAdd.add(minSequencePacket);
                    minSequencePacket = p;
                    minSequence = seq;
                } else {
                    toAdd.add(p);
                }
            }

            packets.addAll(toAdd);
            return minSequencePacket;
        }
        return first;
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

    private long encodePacket(int timestamp, int source, int destination, long sequence) {
        return ((long) timestamp << 44) | ((long) source << 32) | ((long) destination << 20) | sequence;
    }

    private long encodeKey(int timestamp, int source, int destination) {
        return ((long) timestamp << 43) | ((long) source << 22) | destination;
    }

    private int getTimestamp(long packetData) {
        return (int) (packetData >>> 44);
    }

    private int getSource(long packetData) {
        return (int) ((packetData >>> 32) & 0xFFF);
    }

    private int getDestination(long packetData) {
        return (int) ((packetData >>> 20) & 0xFFF);
    }

    private long getSequence(long packetData) {
        return packetData & 0xFFFFF;
    }
}
