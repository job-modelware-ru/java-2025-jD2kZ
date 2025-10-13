public class wait_notify_example {

    private int data;
    private boolean empty = false;

    public synchronized int take() throws InterruptedException {
        while (empty) {
            wait(); // ждём, пока producer не положит данные
        }
        empty = true;
        notifyAll(); // уведомляем producer, что буфер свободен
        return data;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (!empty) {
            wait(); // ждём, пока consumer не заберёт данные
        }
        data = value;
        empty = false;
        notifyAll(); // уведомляем consumer
    }
}
