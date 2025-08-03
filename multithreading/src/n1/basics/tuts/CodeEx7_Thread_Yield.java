package n1.basics.tuts;

import java.util.stream.IntStream;

/*In multithreading, the yield() function used to pause the execution of the current thread and allow other threads of the same or 
 higher priority to execute. It is a way for a thread to voluntarily give up CPU time, promoting better thread scheduling and resource
 utilization. */
public class CodeEx7_Thread_Yield {

	public static void main(String[] args) {
		ThreadYield t1 = new ThreadYield("Aditya");
		ThreadYield t2 = new ThreadYield("Vipul");
		t1.start(); t2.start();
	}

}

class ThreadYield extends Thread{
	
	public ThreadYield(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		IntStream.range(0, 3).forEach( i -> {
			System.out.println(Thread.currentThread().getName() + " is running.");
			Thread.yield(); // yeild is letting other function go
		});
	}
}
/* when Thread.yield() is not there
Aditya is running.
Aditya is running.
Vipul is running.
Vipul is running.
Vipul is running.
Aditya is running.
*/
/* when Thread.yield() is there
Vipul is running.
Aditya is running.
Vipul is running.
Aditya is running.
Vipul is running.
Aditya is running.
*/
