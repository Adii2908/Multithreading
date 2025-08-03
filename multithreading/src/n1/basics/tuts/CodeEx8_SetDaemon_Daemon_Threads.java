package n1.basics.tuts;
/* A daemon thread is a background thread that provides services to user threads. It runs in the background and does not prevent the JVM from
 exiting when all user threads have finished execution.*/

public class CodeEx8_SetDaemon_Daemon_Threads {

	public static void main(String[] args) {
		SetDaemon t1 = new SetDaemon();//t1 is a user thread //high priority
		t1.setDaemon(true); // now  t1 is daemon thread. //low priority
		//Daemon threads are automatically terminated by the JVM when no user threads are left.
		t1.start();
		System.out.println("Main done");
	}
}

class SetDaemon extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello World !");
		}
	}
}

/* Output -
 	Main done
Hello World !
Hello World !
Hello World !
Hello World !
Hello World !
Hello World !
Hello World !
Hello World !
*/

/*Explanantion
The main thread starts.An instance of SetDaemon (t1) is created.t1 is explicitly set as a daemon thread.
t1 starts, and its run() method enters an infinite loop, continuously printing "Hello World !".Immediately after t1.start(), the main thread prints "Main done".
The main thread (which is a user thread) finishes its execution.Crucially, since the main thread was the only user thread, and it has finished,
the JVM checks if there are any remaining user threads. There are none.Because t1 is a daemon thread, the JVM does not wait for it to finish.
The JVM will terminate, abruptly stopping the t1 thread even though it was in an infinite loop.
 */
