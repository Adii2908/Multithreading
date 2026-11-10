package atomic_cas;

import java.util.concurrent.atomic.AtomicBoolean;

public class sce6_executeSomethingOnlyOnceUsingAtomicBoolean {

    private static final AtomicBoolean intialized = new AtomicBoolean(false);

    public static void intialize(){

        if(intialized.compareAndSet(false,true)){
            System.out.println(Thread.currentThread().getName()
                + " is initializing the application");
        }else{
            System.out.println(Thread.currentThread().getName()
            + " initialization already completed");

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(sce6_executeSomethingOnlyOnceUsingAtomicBoolean :: intialize);
        Thread t2 = new Thread(sce6_executeSomethingOnlyOnceUsingAtomicBoolean :: intialize);
        Thread t3 = new Thread(sce6_executeSomethingOnlyOnceUsingAtomicBoolean :: intialize);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
