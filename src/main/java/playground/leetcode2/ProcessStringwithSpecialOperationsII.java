package playground.leetcode2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ProcessStringwithSpecialOperationsII {
    public char processStr(String s, long k) {
        FlippableBuilder fb = new FlippableBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                fb.deleteLast();
            } else {
                if (c == '#') {
                    fb.duplicate();
                } else {
                    if (c == '%') {
                        fb.toggleReverse();
                    } else {
                        fb.append(c);
                    }
                }
            }
        }
        return fb.charAt(k);
    }


    private static class FlippableBuilder {
        private final Deque<Character> data = new ArrayDeque<>();
        private boolean reversed = false;

        void append(char c) {
            if (reversed) {
                data.addFirst(c);
            } else {
                data.addLast(c);
            }
        }

        void deleteLast() {
            if (data.isEmpty()) {
                return;
            }
            if (reversed) {
                data.removeFirst();
            } else {
                data.removeLast();
            }
        }

        void duplicate() {
            int size = data.size();
            if (size == 0) {
                return;
            }
            char[] snapshot = new char[size];
            int i = 0;
            for (char c : data) {
                snapshot[i++] = c;
            }
            for (char c : snapshot) {
                data.addLast(c);
            }
        }

        void toggleReverse() {
            reversed = !reversed;
        }

        char charAt(long i) {
            if (i >= data.size()) {
                return '.';
            }
            if (reversed) {
                i = data.size() - 1 - i;
            }
            Iterator<Character> it = data.iterator();
            char c = 0;
            for (int k = 0; k <= i; k++) {
                c = it.next();
            }
            return c;
        }
    }


}
