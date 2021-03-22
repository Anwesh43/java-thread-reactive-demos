package demos.anwesh;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        BiConsumer<String, Long> delayConsumer = (String threadName, Long delay) -> {
            try {
                System.out.println("Running on a " + threadName +" thrad");
                Thread.sleep(delay);
                System.out.println("Ran on a " + threadName +" thread");
            } catch (Exception ex) {

            }
        };
//        Thread t1 = new Thread(() -> {
//            delayConsumer.accept("new", 3000l);
//        });
//        t1.start();
//        try {
//            delayConsumer.accept("main", 6000l);
//        } catch (Exception ex) {
//
//        }

        final CustomLock customLock = new CustomLock();
        Consumer<String> consumer = (String message) -> {
            try {
                customLock.lock();
                Thread.sleep(3000);
                System.out.println(message);
                customLock.unlock();
            } catch (Exception ex) {

            }
        };
//        new Thread(() -> {
//            consumer.accept("Hello 1");
//        }).start();
//
//        new Thread(() -> {
//            consumer.accept("Hello 2");
//        }).start();
//
//        new Thread(() -> {
//            consumer.accept("Hello 3");
//        }).start();
//
//        new Thread(() -> {
//            consumer.accept("Hello 4");
//        }).start();
//
//        new Thread(() -> {
//            consumer.accept("Hello 5");
//        }).start();
//
        final CountDownLatchClone cd = new CountDownLatchClone(6);
        Consumer<String> consumer1 = (String message) -> {
            try {
                Thread.sleep(3000);
                System.out.println(message);
                cd.decrement();
            } catch (Exception ex) {

            }
        };
        new Thread(() -> {
            consumer1.accept("A1");
        }).start();

        new Thread(() -> {
            consumer1.accept("A2");
        }).start();

        new Thread(() -> {
            consumer1.accept("A3");
        }).start();

        new Thread(() -> {
            consumer1.accept("A4");
        }).start();

        new Thread(() -> {
            consumer1.accept("A5");
        }).start();

        new Thread(() -> {
            consumer1.accept("A6");
        }).start();
        cd.await();
        System.out.println("ended program");
        FlowDemo fd = new FlowDemo();
        fd.demo();
    }
}
