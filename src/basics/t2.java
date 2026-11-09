package basics;

public class t2{

    public static void main(String args[]) {

        myRunnable rn = new myRunnable();
        Thread th = new Thread(rn);
        th.start();

        // Using Lambda function
        Runnable rn1 = () ->
                System.out.println("Thread running using runnable " + Thread.currentThread().getName());

        Thread th1 = new Thread(rn1);
        th1.start();

    }
}

class myRunnable implements Runnable{

    public void run(){
        System.out.println("Thread running using runnable "+ Thread.currentThread().getName());
    }
}
