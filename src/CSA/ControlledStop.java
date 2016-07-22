package CSA;

import java.util.concurrent.atomic.AtomicBoolean;

final class ControlledStop implements Runnable {
	
	private final AtomicBoolean done = new AtomicBoolean(false);
	
	@Override public void run() { 
		while (!done.get()) {
		try {
			// ...
			Thread.currentThread().sleep(1000); 
			// Do something 
			shutdown();
			System.out.println(Thread.currentThread().getName());
			} catch(InterruptedException ie) {
			Thread.currentThread().interrupt(); // Reset interrupted status }
			} 
		}
	}
	public void shutdown() { 
		done.set(true);
	} 
	
	public static void main(String[] args) throws Exception { 
		
		for (int i = 0; i < 5; i++) {
			ControlledStop cnTest = new ControlledStop();
			Thread t = new Thread (cnTest);
			t.start();
		}
	}
}
