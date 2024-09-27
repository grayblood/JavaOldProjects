package Pract1;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Tempo1 implements Runnable {

	int segondsperacabar;

	public Tempo1(int segondsperacabar1) {
		segondsperacabar = segondsperacabar1;
	}

	public void run() {
		try {

			for (int i = segondsperacabar; 0 < i; i--) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				
				Thread.sleep(1000);
			
			}
			System.out.println(Thread.currentThread().getName() + " Ended");


		  
		   } catch (InterruptedException e) {
		    
			   System.out.println("Interrumpido " + Thread.currentThread().getName());
		  
		   
		     Thread.currentThread().interrupt();
		   
		   }
	}

}