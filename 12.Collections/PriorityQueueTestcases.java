import java.util.PriorityQueue;

public class PriorityQueueTestcases {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(5); // [5]
        queue.add(2); // [2, 5]
        queue.add(3); // [2, 5, 3]

        System.out.println(queue.poll()); // 2
        System.out.println(queue.poll()); // 3
        System.out.println(queue.poll()); // 5
    }
}
