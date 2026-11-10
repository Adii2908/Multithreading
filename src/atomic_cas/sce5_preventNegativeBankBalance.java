package atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class sce5_PreventNegativeBankBalance {

    private static final AtomicInteger balance = new AtomicInteger(1000);

    public static boolean withdraw(int amount){

        int currentBalance;

        do{
            currentBalance = balance.get();

            if(currentBalance < amount){
                return false;
            }
        }while(!balance.compareAndSet(
                currentBalance,
                currentBalance-amount));
        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {

            boolean result = withdraw(800);

            System.out.println(Thread.currentThread().getName() + " withdrawal successful: " + result);

        };

        Thread t1 = new Thread(task,"Customer-1");
        Thread t2 = new Thread(task,"Customer-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance "+ balance.get());

    }
}

//Key Learning
//CAS allows conditional updates without a traditional lock.