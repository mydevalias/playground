package playground.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    record Point(int x, int y) {
    }

    enum Direction {
        NORTH(1, 0),
        EAST(0, 1),
        SOUTH(-1, 0),
        WEST(0, -1);

        final int di;
        final int dj;

        Direction(int di, int dj) {
            this.di = di;
            this.dj = dj;
        }

        public Direction turnRight() {
            return values()[(ordinal() + 1) % 4];
        }

        public Direction turnLeft() {
            return values()[(ordinal() + 3) % 4];
        }
    }

    public static int squaredDistance(int i, int j) {
        return i * i + j * j;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int i = 0;
        int j = 0;
        Set<Point> obs = pointsObs(obstacles);
        int res = 0;
        Direction dir = Direction.NORTH;
        for (var c : commands) {
            if (c == -1) {
                dir = dir.turnRight();
            } else {
                if (c == -2) {
                    dir = dir.turnLeft();
                } else {
                    for (int k = 0; k < c; k++) {
                        int ni = i + dir.di;
                        int nj = j + dir.dj;
                        if (obs.contains(new Point(ni, nj))) {
                            break;
                        }
                        i = ni;
                        j = nj;
                        res = Math.max(res, squaredDistance(i, j));
                    }
                }
            }

        }

        return 0;
    }

    private static Set<Point> pointsObs(int[][] obstacles) {
        Set<Point> obs = new HashSet<>(obstacles.length);
        for (var o : obstacles) {
            obs.add(new Point(o[1], o[0]));
        }
        return obs;
    }
}
