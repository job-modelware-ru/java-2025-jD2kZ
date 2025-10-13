import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class future_example {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Задача завершена!";
        };
        Future<String> future = executor.submit(task);
        try {
            // Ожидание завершения задачи и получение результата
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
