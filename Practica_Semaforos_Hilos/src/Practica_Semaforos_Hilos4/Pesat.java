package Practica_Semaforos_Hilos4;

import java.util.concurrent.Callable;

public class Pesat implements Callable<Boolean> {
	Kane obj;
	String name;

	public Pesat(Kane obj, String name) {
		this.obj = obj;
		this.name = name;
	}

	public Boolean call() {
		try {
			while (true) {

				synchronized (obj) {
					obj.wait();
				}

				String proName = obj.donarDadaAConsumir(this);

				if (proName != null) {
					System.out.println(proName + " ha saludat a " + name + ".");
					proName = null;
				}
				Thread.sleep((long) (Math.random() * 1000));

				synchronized (obj.algo) {
					obj.algo.notify();
				}

				
			}
		} catch (InterruptedException e) {
			System.out.println("pena");
		}
		return false;

	}
}
