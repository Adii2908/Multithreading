package n1.basics.tuts;
/************************Using Thread Class*********************/
public class CodeEx2_extend_thread {

	public static void main(String[] args) {
		World world = new World();
		world.start(); // start method is called to initiate the new thread
		for(;;) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class World extends Thread{
	@Override
	public void run() {
		for( ;  ; ) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
/* ---output ---> Basically both of the threads are running simultaneously
Thread-0
Thread-0
main
main
Thread-0
Thread-0
main
main
*/