package playground.leetcode3;

public class CircleAndRectangleOverlapping {

    static boolean circleIntersectsSegment(double cx, double cy, double r,
                                           double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        double closestX, closestY;
        if (dx == 0 && dy == 0) {
            closestX = x1;
            closestY = y1;
        } else {
            double t = ((cx - x1) * dx + (cy - y1) * dy) / (dx * dx + dy * dy);
            t = Math.max(0, Math.min(1, t));
            closestX = x1 + t * dx;
            closestY = y1 + t * dy;
        }

        double distX = cx - closestX;
        double distY = cy - closestY;
        return (distX * distX + distY * distY) <= r * r;
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        boolean centerInsideRect = xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2;

        return centerInsideRect ||
                circleIntersectsSegment(xCenter, yCenter, radius, x1, y1, x1, y2) ||
                circleIntersectsSegment(xCenter, yCenter, radius, x1, y1, x2, y1) ||
                circleIntersectsSegment(xCenter, yCenter, radius, x1, y2, x2, y2) ||
                circleIntersectsSegment(xCenter, yCenter, radius, x2, y1, x2, y2);
    }
}
