package Practica_Semaforos_Hilos1;

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

			synchronized (obj) {
				obj.wait();
			}

			String proName = obj.donarDadaAConsumir();

			if (proName != null) {
				System.out.println(proName + " ha saludat a " + name + ".");

				Thread.sleep(50);

				return true;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;

	}
}
