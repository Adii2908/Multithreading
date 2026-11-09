package basics;

public class t2{

    public static void main(String args[]) {

        myRunnable rn = new myRunnable();
        Thread th = new Thread(rn);
        th.start();

        // Using Lambda function
        Runnable rn1 = () -> {
            System.out.println("Thread 2 started ");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 completed");
        };


        Thread th1 = new Thread(rn1,"runnable thread");
        th1.start();

    }
}

class myRunnable implements Runnable{

    public void run(){
        System.out.println("Thread 1 running using runnable "+ Thread.currentThread().getName());
    }
}
