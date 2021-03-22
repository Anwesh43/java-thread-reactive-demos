package demos.anwesh;

import java.util.concurrent.atomic.AtomicBoolean;

public class CustomLock {

    private AtomicBoolean isWaiting = new AtomicBoolean(false);

    public synchronized void lock() {
        while(isWaiting.get()) {
            try {
                wait();
            }
            catch (Exception ex) {

            }
        }
        isWaiting.set(true);

    }

    public synchronized void unlock() {
        if (isWaiting.get()) {
            isWaiting.set(false);
            notify();
        }
    }
}
