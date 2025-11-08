public class ScalarReplacement {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
        int distance() { return x * x + y * y; }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            Point p = new Point(i, i + 1); // не утекает
            if (p.distance() < 0) {
                break; // условие редкое, но использует результат
            }
        }
    }
}
