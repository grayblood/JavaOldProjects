package Pract1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			int a = (int) Math.random() * 10;
			executor.submit(new Tempo1(10));
			System.out.println(a);
		}
			
			try {
			     
			     if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
			       executor.shutdownNow(); 
			       
			       if (!executor.awaitTermination(5, TimeUnit.SECONDS))
			           System.err.println("Executor did not terminate");
			     }
			   } catch (InterruptedException e) {
			    
			     executor.shutdownNow();
	
			   }
			/*try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		

		for (Thread thread : threads) {
			/*try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		System.out.println("Fi programa");
		
	}
}
