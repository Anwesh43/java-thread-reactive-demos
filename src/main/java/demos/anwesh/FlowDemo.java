package demos.anwesh;

import java.util.concurrent.Flow.*;



public class FlowDemo {

    public void demo() {
        Publisher<String> pb = (Subscriber<? super String> sb) -> {
            try {
                int i = 0;
                while(i < 5) {
                    sb.onNext("Hello" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        sb.onError(ex);
                    }
                    i++;
                }
                sb.onComplete();
            } catch (Exception ex) {
                sb.onError(ex);
            }
        };
        pb.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(String item) {
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("ended");
            }
        });
    }
}
