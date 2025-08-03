package n3.locks;
/*In multithreading,locks(aka Synchronization mechanism) are used to ensure that multiple threads do not interfere 
with each other when accessing shared resources.*/
public class C1_TheoryBasics_without_locks {
/*1.////////Intrinsic/////-These are built into every object in java.You don't see them, but they're there. 
 When you use a synchronized keyword, you're using these automatic locks*/
	
/*////////Explicit///////-These are more advanced locks you can control yourself using the Lock class from 
java.util.concurrent.locks. You explicitly say when to lock and unlock, giving you more control over how and when
people can write in the notebook	*/
	public static void main(String[] args) {
		without_lock_bank bankAcc = new without_lock_bank();
		Runnable task = new Runnable() {//anonymous
			public void run() {
				bankAcc.withdrawal(50);
			}
		};
		Thread t1 = new Thread(task,"Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		t1.start(); t2.start();
	}
}

class without_lock_bank{
	private int balance = 100;
	public synchronized void withdrawal(int amount) {
		if(balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is trying to withdraw " + amount);
			try {
				Thread.sleep(3000);
			}catch(Exception e){
				
			}
			balance -= amount;
		   System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance "
		   		+ "is " + balance);
		}else {
			System.out.println(Thread.currentThread().getName() + " Insufficient balance. ");
		}
	}
}

/*Output
Thread 1 is trying to withdraw 50
Thread 1 completed withdrawal. Remaining balance is 50
Thread 2 is trying to withdraw 50
Thread 2 completed withdrawal. Remaining balance is 0
 */

/*
The Synchronized keyword in Java provides basic thread-safety but has limitations: it locks the entire method
or block, leading to potential performance issues. It lacks a try-lock mechanism, causing thread to block
indefinitely, increasing the risk of deadlocks.
											Additionally, synchronized doesn't support multiple condition
variables, offering only a single monitor per object with basic wait/notify mechanisms.
		In contrast, explicit locks(Lock interface) offer finer-grained control,try-lock capabilities to 
avoid blocking, and more sophisticated thread coordination through multiple condition variables, making them
more flexible and powerful for complex concurrency scenarios.
 */
