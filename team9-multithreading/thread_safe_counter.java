public class thread_safe_counter {
    private static final Object lock = new Object();
    private static int c;

    static void count() {
        synchronized (lock) {
            c++;
        }
    }

    static int getCounter() {
        synchronized (lock) {
            return c;
        }
    }
}
