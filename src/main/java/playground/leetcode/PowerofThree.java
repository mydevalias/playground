package playground.leetcode;

import playground.IntMultiCounter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerofThree {

    private static final SimpleHashSet powers =new SimpleHashSet(new int[]{
            1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683,
            59049, 177147, 531441, 1594323, 4782969, 14348907,
            43046721, 129140163, 387420489, 1162261467});

    public boolean isPowerOfThree(int n) {
        return powers.contains(n);
    }

    public static class SimpleHashSet {
        private int[] buckets;
        private boolean[] occupied;
        private int size;

        public SimpleHashSet(int[] list) {
            this.size = list.length * 2; // Simple load factor
            this.buckets = new int[size];
            this.occupied = new boolean[size];

            for (int value : list) {
                add(value);
            }
        }

        private void add(int value) {
            int index = hash(value);
            while (occupied[index]) {
                if (buckets[index] == value) return; // Already exists
                index = (index + 1) % size; // Linear probing
            }
            buckets[index] = value;
            occupied[index] = true;
        }

        public boolean contains(int value) {
            int index = hash(value);
            while (occupied[index]) {
                if (buckets[index] == value) return true;
                index = (index + 1) % size;
            }
            return false;
        }

        private int hash(int value) {
            return (value & 0x7fffffff) % size;
        }
    }
}
