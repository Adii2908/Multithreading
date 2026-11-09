package basics;

public class t1_createThreadByInheritance {
    public static void main(String args[]){
        myThread mt = new myThread();
        mt.start();

        // Using anonymous function
        Thread th = new Thread (() -> {
            System.out.println("Thread running one more " + Thread.currentThread().getName());
        });
        th.start();
    }
}

class myThread extends Thread{

    public void run(){
        System.out.println("Thread running " + Thread.currentThread().getName());
    }

}
