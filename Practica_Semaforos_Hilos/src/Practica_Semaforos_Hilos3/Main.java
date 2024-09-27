package Practica_Semaforos_Hilos3;

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
		eagers.add(executor.submit(new Eager(c, "Astaulfo")));
		eagers.add(executor.submit(new Eager(c, "Macanudo")));
		eagers.add(executor.submit(new Eager(c, "Remenudo")));
		eagers.add(executor.submit(new Eager(c, "Remoulfo")));
		eagers.add(executor.submit(new Eager(c, "Kaellulfo")));
		eagers.add(executor.submit(new Eager(c, "Misteoulfo")));
		eagers.add(executor.submit(new Eager(c, "Unastafo")));
		eagers.add(executor.submit(new Eager(c, "Rifoto")));
		eagers.add(executor.submit(new Eager(c, "Melfosto")));
		eagers.add(executor.submit(new Eager(c, "Juasto")));
		eagers.add(executor.submit(new Eager(c, "Mestilfo")));
		eagers.add(executor.submit(new Eager(c, "Auralfo")));
		eagers.add(executor.submit(new Eager(c, "Trascauco")));
		eagers.add(executor.submit(new Eager(c, "Maltausto")));
		eagers.add(executor.submit(new Eager(c, "Resteulfo")));
		

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
