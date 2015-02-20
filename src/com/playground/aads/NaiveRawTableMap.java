package com.playground.aads;

/**
 * just for fun
 *
 * User: liviu
 * Date: 3/5/14
 * Time: 11:11 PM
 */
public class NaiveRawTableMap<K, V> {

    private Entry<K, V> table[];

    public NaiveRawTableMap() {
        table = new Entry[15];
    }

    public void put(K key, V value) {
        int place = row(key);
        if (table[place] == null) {
            table[place] = new Entry<>(key, value);
        } else {
            Entry<K, V> entry = table[place];
            while (true) {
                if (entry.key.equals(key)) {
                    entry.data = value;
                    return;
                } else {
                    if (entry.next != null) {
                        entry = entry.next;
                    } else {
                        entry.next = new Entry<>(key, value);
                        return;
                    }
                }
            }
        }
    }

    public V get(K key) {
        int place = row(key);
        Entry<K, V> entry = table[place];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.data;
            } else {
                entry = entry.next;
            }
        }
        return null;
    }

    private int row(K key) {
        return key.hashCode() % table.length;
    }


    public class Entry<K, V> {
        K key;
        V data;
        Entry<K, V> next;

        public Entry(K key, V data) {
            this.key = key;
            this.data = data;
        }
    }

}
