package n1.basics.tuts;

/*	New - A thread is in this state when it is created but not started.
Runnable - After the start method is called, the thread becomes runnable. It's ready to run and is waiting for CPU time.
Running - The thread is in this state when it is executing.
Blocked/waiting - A thread is in this state when it is waiting for a resource or for another thread to perform an action.
Terminated - A thread is in this state when it has finished executing.
*/

public class CodeEx4_thread_lifecycle {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		System.out.println(t1.getState()); //-> NEW
		
		t1.start();
		System.out.println(t1.getState()); //-> RUNNABLE
		
		Thread.sleep(100);//not giving error because main method is throwing InterruptedException
		System.out.println(t1.getState()); // -> TIMED_WAITING
		
		t1.join();
		System.out.println(t1.getState()); // -> TERMINATED
	}
}

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Running ");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
