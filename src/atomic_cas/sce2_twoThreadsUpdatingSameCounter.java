package atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class sce2_twoThreadsUpdatingSameCounter {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {

            for(int i = 0; i < 1000 ; i++){

                int currentValue;
                int newValue;

                do {
                    currentValue = count.get();
                    newValue = currentValue + 1;
                } while (!count.compareAndSet(currentValue, newValue));
            }

        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //join() makes one thread wait until another thread has finished running.
        //When you call t.join(), the calling thread (often the main thread) blocks until thread t terminates.
        // Without it, the main thread keeps going and may finish, or use results, before the worker thread is done.


        System.out.println("Final Count: " + count.get());
    }
}
