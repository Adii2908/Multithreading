package basics;

public class t1 {
    public static void main(String args[]){
        myThread mt = new myThread();
        mt.start();
    }
}

class myThread extends Thread{

    public void run(){
        System.out.println("Thread running " + Thread.currentThread().getName());
    }

}
