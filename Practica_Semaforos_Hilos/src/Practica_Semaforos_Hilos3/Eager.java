package Practica_Semaforos_Hilos3;

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
				synchronized (obj) {
					obj.wait();
				}
				
				String proName = obj.donarDadaAConsumir();
				
				if (proName != null) {
					System.out.println(proName + " ha saludat a " + name + ".");
					
					Thread.sleep((long) (Math.random() * 1000));
					
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
