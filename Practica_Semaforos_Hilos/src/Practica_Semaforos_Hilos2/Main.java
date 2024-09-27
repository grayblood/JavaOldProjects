package Practica_Semaforos_Hilos2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<Boolean>> eagers = new ArrayList<Future<Boolean>>();

		Desirable c = new Desirable("Marcos");

		eagers.add(executor.submit(new Eager(c, "Astolfo")));
		eagers.add(executor.submit(new Eager(c, "Rodolfo")));
		eagers.add(executor.submit(new Eager(c, "Mastolfo")));
		eagers.add(executor.submit(new Eager(c, "Amorfo")));
		eagers.add(executor.submit(new Eager(c, "Alfonso")));
		

		executor.submit(c);
		executor.shutdown();

		try {
			for (Future<Boolean> future : eagers) {
				future.get();
			}
			
			executor.shutdownNow();
			executor.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
