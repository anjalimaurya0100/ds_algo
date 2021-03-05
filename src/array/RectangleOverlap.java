package array;

public class RectangleOverlap {
    public static void main(String[] args) {
        Point a1 = new Point(2, 3);
        Point b1 = new Point(2, 3);
        Point a2 = new Point(2, 3);
        Point b2 = new Point(2, 3);

        boolean overlap = isOverlapping(a1, b1, a2, b2);
        System.out.println(overlap);
    }

    private static boolean isOverlapping(Point a1, Point b1, Point a2, Point b2) {
        if (a1.x > b2.x || a2.x > b1.x)
            return false;

        return a1.y >= b2.y && a2.y >= b1.y;
    }

    public static class Point {
        int x;
        int y;

        // constructor
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
