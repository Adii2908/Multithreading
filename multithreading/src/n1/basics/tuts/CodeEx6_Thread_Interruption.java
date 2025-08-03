package n1.basics.tuts;
//Thread Interruption is a mechanism in Java that allows one thread to signal another thread to stop its execution. It does not forcibly
//stop the thread but serves as a request that the target thread can handle appropriately.
public class CodeEx6_Thread_Interruption {

	public static void main(String[] args) {
		ThreadInterruption t1 = new ThreadInterruption();
		t1.start();
		t1.interrupt(); //It didn't let print "Thread is running" despite of t1.start()
	}
}

class ThreadInterruption extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Thread is running........");
		}catch(Exception e) {
			System.out.println(" Thread Interrupted : " + e);
		}
	}
}

/* Output :
Thread Interrupted : java.lang.InterruptedException: sleep interrupted 
*/