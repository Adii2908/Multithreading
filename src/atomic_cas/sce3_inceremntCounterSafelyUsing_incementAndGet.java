package atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class sce3_inceremntCounterSafelyUsing_incementAndGet {

    private static final AtomicInteger requestCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
          for(int i = 0 ; i < 1000 ; i++){
              // Use incrementAndGet() when you simply need to increment a shared counter.
              requestCount.incrementAndGet();
              //we didn't write a CAS loop ourselves.
              // incrementAndGet() handles the atomic update internally.
          }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Total Count " + requestCount.get());
    }
}
