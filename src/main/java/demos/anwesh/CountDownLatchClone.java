package demos.anwesh;

import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchClone {

    AtomicInteger counter;

    public CountDownLatchClone(int n) {
        counter = new AtomicInteger(n);
    }

    public synchronized void await() {
        while (counter.get() > 0) {
            try {
                wait();
            } catch (Exception ex) {

            }
        }
    }

    public synchronized void decrement() {
        counter.decrementAndGet();
        if (counter.get() == 0) {
            notifyAll();
        }
    }
}
