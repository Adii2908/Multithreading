package basics;

public class t2{
    public static void main(String args[]) {

        myRunnable rn = new myRunnable();
        Thread th = new Thread(rn);
        th.start();

    }
}

class myRunnable implements Runnable{

    public void run(){
        System.out.println("Thread running using runnable"+ Thread.currentThread().getName());
    }
}
