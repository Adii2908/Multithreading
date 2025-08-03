package n3.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C2_with_locks {

	public static void main(String[] args) {
		with_lock_bank bank = new with_lock_bank();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				bank.withdrawal(50);
			}
		};
		Thread t1 = new Thread(task , "Thread 1");
		Thread t2 = new Thread(task , "Thread 2");
		t1.start(); t2.start();
	}

}
class with_lock_bank{
	private int balance = 100;
	private Lock lock = new ReentrantLock();
	
	public void withdrawal(int amount) {
		try {
			if(lock.tryLock(1000,TimeUnit.MILLISECONDS)) {//it tries to lock within given time(waiting) otherwise moves forward
				if(balance >= amount) {
					System.out.println(Thread.currentThread().getName()+ " attempting to withdraw "+ amount);
					try {  
						System.out.println(Thread.currentThread().getName()+ " proceeding with the withdrawal.");
						Thread.sleep(10000);
						
						balance -= amount;
						System.out.println(Thread.currentThread().getName()+ " completed withdrawal."
								+ "Remaining Balance is "+ balance);
					}catch(Exception e) {
						Thread.currentThread().interrupt(); //important to log if thread is interrupted(Good Practice)
						//more logic can be added after interruption as if we want to resotre or something.
					}finally {//using to release resources
						lock.unlock();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+ " insufficient balance.");
				}
			}else {
				System.out.println(Thread.currentThread().getName()+ " could not acquire the lock, "
						+ "will try later");
			}
		}catch(Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
/*Output
Thread 1 attempting to withdraw 50
Thread 1 proceeding with the withdrawal.
Thread 2 could not acquire the lock, will try later
Thread 1 completed withdrawal.Remaining Balance is 50
 */
//lock.lock() -> trying to unlock for infinite time unlike lock.tryLock()