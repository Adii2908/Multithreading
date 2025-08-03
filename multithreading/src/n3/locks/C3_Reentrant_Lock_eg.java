package n3.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*A Reentrant Lock in Java is a type of lock that allows a thread to acquire the same lock multiple times without causing a deadlock.
If a thread already holds the lock, it can re-enter the lock without being locked. This is useful when a thread needs to repeatedly 
enter synchronized blocks or methods within the same execution flow. 
The Reentrant lock class from the java.util.concurent.locks package provides this functionality, offering more flexibility than the 
synchronized keyword, including try-locking, and multiple condition variables for advanced thread co-ordination.
 */
public class C3_Reentrant_Lock_eg {

	public static void main(String[] args) {
		ReentrantLock_basics example = new ReentrantLock_basics();
		example.outerMethod();
	}
}

class ReentrantLock_basics{
	private final Lock lock = new ReentrantLock();
	
	public void outerMethod() {
		lock.lock();
		try {
			System.out.println("Outer Method");
			innerMethod();
		}finally {
			lock.unlock();
		}
	}
	
	public void innerMethod() {
		lock.lock();
		try {
			System.out.println("Inner Method");
		}finally {
			lock.unlock();
		}
	}
}
