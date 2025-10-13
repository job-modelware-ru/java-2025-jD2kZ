import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        // Параллельное выполнение задачи
        int result = pool.invoke(task);
        System.out.println("Total sum: " + result);
        pool.shutdown();
    }
}

class SumTask extends RecursiveTask<Integer> {
    private int[] array;
    private int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) {
            // Базовый случай, когда подзадача слишком мала
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Разделяем задачу на две части
            int mid = (start + end) / 2;
            SumTask task1 = new SumTask(array, start, mid);
            SumTask task2 = new SumTask(array, mid, end);
            task1.fork(); // Разделяем задачу (fork)
            int rightResult = task2.fork().join(); // Обрабатываем и получаем результат второй подзадачи
            int leftResult = task1.join(); // Получаем результат первой подзадачи
            return leftResult + rightResult; // Объединяем результаты (join)
        }
    }
}
