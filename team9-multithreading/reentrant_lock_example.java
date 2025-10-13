import java.util.concurrent.locks.*;

public class reentrant_lock_example {
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private int data;
    private boolean empty = true;

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            while (!empty) {
                notFull.await(); // аналог wait()
            }
            data = value;
            empty = false;
            notEmpty.signal(); // аналог notify()
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (empty) {
                notEmpty.await();
            }
            empty = true;
            notFull.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }
}
