package Practica_Semaforos_Hilos1;

import java.util.concurrent.Callable;

public class Desirable implements Callable<Boolean> {

	String name;
	boolean saludar = true;
	public Object algo = new Object();

	public Desirable(String name) {

		this.name = name;

	}

	public  String donarDadaAConsumir() {
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
		
		

			synchronized (this) {
				this.notifyAll();
			}
			return saludar;


	}
}
