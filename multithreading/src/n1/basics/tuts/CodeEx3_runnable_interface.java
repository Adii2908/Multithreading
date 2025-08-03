package n1.basics.tuts;
/*****************Using Runnable Interface*******************/
public class CodeEx3_runnable_interface {

	public static void main(String[] args) {
		WorldRunnable runnable = new WorldRunnable();
		Thread t1 = new Thread(runnable);//passing object to create thread.
		t1.start();// start method is called to initiate the new thread
		for(;;) { System.out.println("main");	}

}}

class WorldRunnable implements Runnable {

	@Override
	public void run() {
		for(;;) {
			System.out.println("World");
		}
	}
}

/*Output -> 
main
main
main
World
World
World
World
World
World
World
main
main
main
main
main */