package playground.leetcode2;

/**
 * https://leetcode.com/problems/walking-robot-simulation-ii/?envType=daily-question&envId=2026-04-07
 */
class Robot {
    final int width;
    final int height;
    int x = 0;
    int y = 0;
    Direction direction = Direction.EAST;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    enum Direction {
        NORTH(0, 1),
        EAST(1, 0),
        SOUTH(0, -1),
        WEST(-1, 0);

        final int dx;
        final int dy;
        final String label;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
            this.label = capitalize(name());
        }

        private static String capitalize(String s) {
            if (s == null || s.isEmpty()) return s;
            return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
        }

        public Direction turnRight() {
            return values()[(ordinal() + 1) % 4];
        }

        public Direction turnLeft() {
            return values()[(ordinal() + 3) % 4];
        }
    }

    public void step(int num) {
        int perimeter = 2 * (width - 1) + 2 * (height - 1);
        num = num < perimeter ? num : (num % perimeter) + perimeter;
        stepInternal(num);
    }

    private void stepInternal(int num) {
        if (num == 0) return;

        int nx = x + direction.dx * num;
        int ny = y + direction.dy * num;

        if (nx >= this.width) {
            int stepsToWall = (this.width - 1) - x;
            int remaining = num - stepsToWall;
            x = this.width - 1;
            direction = direction.turnLeft();
            stepInternal(remaining);
        } else if (nx < 0) {
            int stepsToWall = x;
            int remaining = num - stepsToWall;
            x = 0;
            direction = direction.turnLeft();
            stepInternal(remaining);
        } else if (ny >= this.height) {
            int stepsToWall = (this.height - 1) - y;
            int remaining = num - stepsToWall;
            y = this.height - 1;
            direction = direction.turnLeft();
            stepInternal(remaining);
        } else if (ny < 0) {
            int stepsToWall = y;
            int remaining = num - stepsToWall;
            y = 0;
            direction = direction.turnLeft();
            stepInternal(remaining);
        } else {
            x = nx;
            y = ny;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return direction.label;
    }

}