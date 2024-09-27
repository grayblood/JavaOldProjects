package Practica_Semaforos_Hilos4;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class Kane implements Callable<Boolean> {

	String name;
	int saludar = 5;
	public Object algo = new Object();
	boolean end = true;
	HashMap<Pesat, Integer> Pesats = new HashMap<Pesat, Integer>();

	public Kane(String name) {

		this.name = name;

	}

	public synchronized String donarDadaAConsumir(Pesat pesat) {

		if (saludar != 0) {

			if (Pesats.get(pesat) == null) {
				Pesats.put(pesat, 1);
				saludar--;

			} else {
				if (Pesats.get(pesat) == 3) {
					System.out.println("end ahead");
					end = false;
					System.out.println(pesat.name + " " + Pesats.get(pesat));
				} else {
					Pesats.put(pesat, Pesats.get(pesat) + 1);
					saludar--;
					return name;

				}

			}
			// System.out.println(pesat.name + " " + Pesats.get(pesat));

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

			while (end) {

				synchronized (algo) {
					algo.wait();
					saludar = 5;
					synchronized (this) {
						this.notifyAll();
					}
				}
			}

		} catch (

		InterruptedException e) {
			System.out.println("finalisado correctamente");
		}
		return true;
	}
}
