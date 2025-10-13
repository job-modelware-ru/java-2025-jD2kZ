import java.util.concurrent.Semaphore;

public class semaphore_example {
    Semaphore semaphore = new Semaphore(3);

    //only 3 connections allowed
    //all thread safe
    public void connect() throws InterruptedException {
        semaphore.acquire(); // ждём, если все 3 заняты
        try {
            System.out.println(Thread.currentThread().getName() + " подключился");
            Thread.sleep(2000); // имитация работы
        } finally {
            semaphore.release(); // освобождаем слот
        }
    }
}
