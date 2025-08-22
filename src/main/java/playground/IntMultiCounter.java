package playground;

import java.util.Arrays;

public class IntMultiCounter {
    private int[] indices;
    private int[] counts;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public IntMultiCounter() {
        this.indices = new int[INITIAL_CAPACITY];
        this.counts = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void increment(int index) {
        increment(index, 1);
    }

    public void increment(int index, int amount) {
        int pos = findIndex(index);
        if (pos >= 0) {
            counts[pos] += amount;
        } else {
            insertAt(-(pos + 1), index, amount);
        }
    }

    public int get(int index) {
        int pos = findIndex(index);
        return pos >= 0 ? counts[pos] : 0;
    }

    public void reset(int index) {
        int pos = findIndex(index);
        if (pos >= 0) {
            removeAt(pos);
        }
    }

    public int size() {
        return size;
    }

    private int findIndex(int index) {
        return Arrays.binarySearch(indices, 0, size, index);
    }

    private void insertAt(int pos, int index, int count) {
        if (size == indices.length) {
            resize();
        }

        System.arraycopy(indices, pos, indices, pos + 1, size - pos);
        System.arraycopy(counts, pos, counts, pos + 1, size - pos);

        indices[pos] = index;
        counts[pos] = count;
        size++;
    }

    private void removeAt(int pos) {
        System.arraycopy(indices, pos + 1, indices, pos, size - pos - 1);
        System.arraycopy(counts, pos + 1, counts, pos, size - pos - 1);
        size--;
    }

    private void resize() {
        int newCapacity = indices.length * 2;
        indices = Arrays.copyOf(indices, newCapacity);
        counts = Arrays.copyOf(counts, newCapacity);
    }
}
