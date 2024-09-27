package Practica_Semaforos_Hilos4;

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

		Kane c = new Kane("Kane");

		
		
		eagers.add(executor.submit(new Pesat(c, "Astolfo")));
		eagers.add(executor.submit(new Pesat(c, "Rodolfo")));
		eagers.add(executor.submit(new Pesat(c, "Mastolfo")));
		eagers.add(executor.submit(new Pesat(c, "Amorfo")));
		eagers.add(executor.submit(new Pesat(c, "Alfonso")));
		eagers.add(executor.submit(new Pesat(c, "Astaulfo")));
		eagers.add(executor.submit(new Pesat(c, "Macanudo")));
		eagers.add(executor.submit(new Pesat(c, "Remenudo")));
		eagers.add(executor.submit(new Pesat(c, "Remoulfo")));
		eagers.add(executor.submit(new Pesat(c, "Kaellulfo")));
		eagers.add(executor.submit(new Pesat(c, "Misteoulfo")));
		eagers.add(executor.submit(new Pesat(c, "Unastafo")));
		eagers.add(executor.submit(new Pesat(c, "Rifoto")));
		eagers.add(executor.submit(new Pesat(c, "Melfosto")));
		eagers.add(executor.submit(new Pesat(c, "Juasto")));
		eagers.add(executor.submit(new Pesat(c, "Mestilfo")));
		eagers.add(executor.submit(new Pesat(c, "Auralfo")));
		eagers.add(executor.submit(new Pesat(c, "Trascauco")));
		eagers.add(executor.submit(new Pesat(c, "Maltausto")));
		eagers.add(executor.submit(new Pesat(c, "Resteulfo")));
		

		Future<Boolean> kane = executor.submit(c);
		executor.shutdown();

		try {
			kane.get();
			
			executor.shutdownNow();
			executor.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
