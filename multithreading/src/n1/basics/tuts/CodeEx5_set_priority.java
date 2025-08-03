package n1.basics.tuts;

public class CodeEx5_set_priority {

	public static void main(String[] args) {
		
		SetPriority t1 = new SetPriority("low");
		SetPriority t2 = new SetPriority("medium");
		SetPriority t3 = new SetPriority("high");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start(); t2.start(); t3.start();

	}

}

class SetPriority extends Thread{
	
	public SetPriority(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i = 0 ; i <= 5 ; i++) {
			String a = "a";
			for(int j = 0 ; j < 100000000 ; j++) {
				
			}
			System.out.println(Thread.currentThread().getName() + "-priority: "
					+ Thread.currentThread().getPriority() + " - count: " + i);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
	
}
