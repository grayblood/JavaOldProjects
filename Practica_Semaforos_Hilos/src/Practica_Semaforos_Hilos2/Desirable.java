package Practica_Semaforos_Hilos2;

import java.util.concurrent.Callable;

public class Desirable implements Callable<Boolean> {

	String name;
	boolean saludar = true;
	public Object algo = new Object();

	public Desirable(String name) {

		this.name = name;

	}

	public synchronized String donarDadaAConsumir() {
		if (saludar) {
			saludar = false;
			return name;
		}
		return null;
	}

	public Boolean call() {

		try {
			Thread.sleep((long) (Math.random() * 50 + 50));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			while (true) {
				synchronized (this) {
					this.notifyAll();
				}
				
				synchronized (algo) {
					algo.wait();
					saludar = true;
				}
			}
		} catch (InterruptedException e) {
			System.out.println("finalisado correctamente");
		}
		return true;
	}
}
