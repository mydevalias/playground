package playground.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Schedule> pq = new PriorityQueue<>();
        int counts[] = new int[n];
        int i;
        for (i = 0; i < Math.min(n, meetings.length); i++) {
            counts[i]++;
            Schedule schedule = new Schedule(meetings[i][1], i);
            pq.add(schedule);
        }

        while (!pq.isEmpty()) {
            i++;
            Schedule prev = pq.poll();
            if (i < meetings.length) {
                prev.endtime = meetings[i][1];
                counts[prev.pos]++;
                pq.add(prev);
            }
        }

        return findMaxPos(n, counts);

    }

    private static class Schedule implements Comparable<Schedule> {
        int endtime;
        int pos;

        Schedule(int endtime, int pos) {
            this.endtime = endtime;
            this.pos = pos;
        }

        @Override
        public int hashCode() {
            return 31 * endtime + pos;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Schedule other = (Schedule) obj;
            return endtime == other.endtime && pos == other.pos;
        }

        @Override
        public int compareTo(Schedule other) {
            int cmp = Integer.compare(this.endtime, other.endtime);
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
