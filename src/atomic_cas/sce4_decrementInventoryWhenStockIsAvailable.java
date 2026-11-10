package atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class sce4_decrementInventoryWhenStockIsAvailable {

    private static final AtomicInteger inventory = new AtomicInteger(10);

    public static boolean purchaseProduct(){
        int currentStock;

        do{
            currentStock = inventory.get();
            if(currentStock <= 0){
                return false;
            }
//CAS is useful when an update must satisfy a condition before it happens.
        }while(!inventory.compareAndSet(
                currentStock,
                currentStock - 1
        ));
        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable customer = () -> {
            boolean purchased = purchaseProduct();
            System.out.println(Thread.currentThread().getName()+ " purchase: " + purchased);
        };

        Thread[] customers = new Thread[15];

        for(int i = 0; i < customers.length ; i++){
            customers[i] = new Thread(customer, "Customer-" + (i + 1));
            customers[i].start();
        }

        for(Thread customerThread : customers){
            customerThread.join();
        }

        System.out.println("Remaining inventory: " + inventory.get());
    }
}

//Exactly 10 can purchase, other 5 received false
//Key Learning :
//CAS is useful when an update must satisfy a condition before it happens.
