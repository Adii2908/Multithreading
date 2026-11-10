package atomic_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class sce1_updateValueOnlyIfMatches {

    public static void main(String[] args) {

        AtomicInteger value = new AtomicInteger(100);

        // see, OkayO
        boolean updated = value.compareAndSet(100, 200);
        //
        boolean updated1 = value.compareAndSet(100, 300);

        System.out.println("Updated Successful: " + updated);
        System.out.println("Updated Successful: " + updated1);
        System.out.println("Current Value " + value.get());

    }
}
