package playground.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {


    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.add(i);
        }
        PriorityQueue<Schedule> busy = new PriorityQueue<>();
        int[] counts = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!busy.isEmpty() && busy.peek().endtime <= start) {
                available.add(busy.poll().pos);
            }

            int roomNum;
            long actualEnd;

            if (!available.isEmpty()) {
                roomNum = available.poll();
                actualEnd = end;
            } else {
                Schedule earliest = busy.poll();
                roomNum = earliest.pos;
                int duration = end - start;
                actualEnd = earliest.endtime + duration;
            }

            counts[roomNum]++;
            busy.add(new Schedule(actualEnd, roomNum));
        }

        return findMaxPos(n, counts);
    }

    private static class Schedule implements Comparable<Schedule> {
        long endtime;
        int pos;

        Schedule(long endtime, int pos) {
            this.endtime = endtime;
            this.pos = pos;
        }

        @Override
        public int compareTo(Schedule other) {
            int cmp = Long.compare(this.endtime, other.endtime);
            if (cmp != 0) return cmp;
            return Integer.compare(this.pos, other.pos);
        }
    }

    private static int findMaxPos(int n, int[] counts) {
        int retPos = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (counts[i] > max) {
                retPos = i;
                max = counts[i];
            }
        }
        return retPos;
    }


}
