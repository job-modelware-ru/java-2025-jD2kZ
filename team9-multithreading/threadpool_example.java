import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class threadpool_example {
    public static void main(String[] args) {
        // Создание пула потоков с фиксированным числом потоков (3)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Отправка задач в пул
        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Задача " + taskNumber + " выполняется потоком " + Thread.currentThread().getName());
            });
        }

        //Завершение работы пула
        executor.shutdown();
    }
}
