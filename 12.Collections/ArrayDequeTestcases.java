import java.util.ArrayDeque;

public class ArrayDequeTestcases {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.push(1); // [1]
        queue.add(2); // [1, 2]
        queue.offer(3); // [1, 2, 3]

        System.out.println(queue);

        queue.remove(); // [2, 3]
        queue.pop(); // [3]
        queue.poll(); // [0]

        System.out.println(queue);
    }
}
