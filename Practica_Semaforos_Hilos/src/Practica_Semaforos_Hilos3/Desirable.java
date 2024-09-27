package Practica_Semaforos_Hilos3;

import java.util.concurrent.Callable;

public class Desirable implements Callable<Boolean> {

	String name;
	int saludar = 5;
	public Object algo = new Object();

	public Desirable(String name) {

		this.name = name;

	}

	public synchronized String donarDadaAConsumir() {
		if (saludar != 0) {
			saludar--;
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
			synchronized (this) {
				this.notifyAll();
			}
			
			while (true) {
				synchronized (algo) {
					algo.wait();
					saludar++;
					synchronized (this) {
						this.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("finalisado correctamente");
		}
		return true;
	}
}
