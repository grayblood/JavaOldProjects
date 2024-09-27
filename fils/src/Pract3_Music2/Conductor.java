package Pract3_Music2;

import java.util.concurrent.Callable;

public class Conductor implements Callable<Boolean> {
	int tempo;

	public Conductor(int Tempo) {
		tempo = 60000 / Tempo / 16;
	}

	@Override
	public Boolean call() {
		try {
			while (true) {

				Thread.sleep(tempo);

				synchronized (this) {
					// System.out.println("sync");

					notifyAll();

				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
