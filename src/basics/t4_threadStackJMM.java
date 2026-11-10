package basics;

public class t4_threadStackJMM {

    public static Object sharedObj = new Object();
    // shareObj is stored in the heap area, and shared by thread stack
    // both thread can access this, hence same hashCode generates across

    public static void main(String[] args) {

        System.out.println(sharedObj.hashCode());

        Runnable myRunnable1 = () -> {

            System.out.println("Thread1 is implemented");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            System.out.println(sharedObj.hashCode());
            //same hashcode will be generated
            int localVariable1 = 1;
            //since local variable stores in thread stack
            //threads can access own and not access each other thread stack
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 completed");

        };

        Runnable myRunnable2 = () -> {
            System.out.println("Thread 2 is starting");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            int localVariable2 = 1;
            //since local variable stores in thread stack
            //threads can access own and not access each other thread stack
            System.out.println(sharedObj.hashCode());
            //same hashcode will be generated
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thraed 2 is completed");
        };

        Thread th1 = new Thread(myRunnable1, "runnable1");
        th1.start();

        Thread th2 = new Thread(myRunnable2, "runnable2");
        th2.start();
    }
}
