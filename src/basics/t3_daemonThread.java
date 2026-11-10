package basics;

public class t3_daemonThread {

    public static volatile boolean running = true;
    // volatile ->	Makes changes to running visible to the daemon thread.

    public static void main(String[] args) throws InterruptedException {

        Thread daemonThread = new Thread(() -> {

                try {
                    while(running) {
                        System.out.println("Daemon thread is running.....");
                        Thread.sleep(1000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    System.out.println("Daemon thread is terminated");
                }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        Thread.sleep(3000);

        System.out.println("Main thread is finishing");

        running = false;

        daemonThread.join();
        //join -> Makes the main thread wait until the specified thread terminates
        // join() does not make a daemon thread non-daemon. It simply makes the main thread wait for it.

        System.out.println("Main Thread is completed");
    }
}
