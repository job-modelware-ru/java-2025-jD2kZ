public class DeadCodeElimination {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            int x = i * 2 + 10; // результат не используется
        }
    }
}
