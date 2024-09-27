package Pract4_Kaneact2;

import java.util.concurrent.Callable;

public class Eager implements Callable<Boolean> {
	Desirable obj;
	String name;

	public Eager(Desirable obj, String name) {
		this.obj = obj;
		this.name = name;
	}

	public Boolean call() {
		try {
			while (true) {
				System.out.println("lope");
				synchronized (obj) {
					System.out.println("esperando");
					obj.wait();
				}
				
				String proName = obj.donarDadaAConsumir();
				
				if (proName != null) {
					System.out.println(proName + " ha saludat a " + name + ".");
					
					Thread.sleep(50);
					
					synchronized (obj.algo) {
						obj.algo.notify();
					}
					return true;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;

	}
}
