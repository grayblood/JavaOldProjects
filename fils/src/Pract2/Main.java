package Pract2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		Activitat1y2();

		Actividad3y4();
	}

	private static void Activitat1y2() {
		Random r = new Random();
		ExecutorService executor = Executors.newFixedThreadPool(500000);
		System.out.println("llamo el thread");
		
		ArrayList<Integer> llista1 = new ArrayList<Integer>();
		for (int i = 0; i < 500000; i++) {

			llista1.add(r.nextInt());

		}

		List<Integer> llista2 = llista1.subList(0, 250000);
		List<Integer> llista3 = llista1.subList(250000, 500000);

		try {
			System.out.println("Esperant que acabin els threads.");

			/* Lista completa */

			// Future<List<Integer>> maximresultat = executor.submit(new
			// MaximMinim(llista1));

			/* Media lista 0 , 250000 */
			Future<List<Integer>> maximresultat1 = executor.submit(new MaximMinim(llista2));

			/* Media lista 250000 , 500000 */
			Future<List<Integer>> maximresultat2 = executor.submit(new MaximMinim(llista3));

			/* Combinar las 2 listas anteriores */
			List<Integer> llista4 = maximresultat1.get();
			llista4.addAll(maximresultat2.get());
			Future<List<Integer>> maximresultat3 = executor.submit(new MaximMinim(llista4));

			executor.shutdown();

			/* print zone */

			// System.out.print("maximresultat: ");
			// System.out.println(maximresultat.get().get(0) + " , " +
			// maximresultat.get().get(1));

			System.out.print("maximresultat1: ");
			System.out.println(maximresultat1.get().get(0) + " , " + maximresultat1.get().get(1));

			System.out.print("maximresultat2: ");
			System.out.println(maximresultat2.get().get(0) + " , " + maximresultat2.get().get(1));

			System.out.print("maximresultat3: ");
			System.out.println(maximresultat3.get().get(0) + " , " + maximresultat3.get().get(1));

			System.out.println("Tot Fet");

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}

	private static void Actividad3y4() {
		Random r = new Random();
		ExecutorService executor = Executors.newFixedThreadPool(50000000);
		System.out.println("llamo el thread");
		
		
		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("freeMemory "+ freeMemory);
		
		
		ArrayList<Integer> llista1 = new ArrayList<Integer>();
		for (int i = 0; i < 50000000; i++) {

			llista1.add(r.nextInt());

		}

		List<Integer> llista2 = llista1.subList(0, 250000);
		List<Integer> llista3 = llista1.subList(250000, 500000);

		try {
			System.out.println("Esperant que acabin els threads.");

			/* Lista completa */

			// Future<List<Integer>> maximresultat = executor.submit(new
			// MaximMinim(llista1));

			/* Media lista 0 , 250000 */
			Future<List<Integer>> maximresultat1 = executor.submit(new MaximMinim(llista2));

			/* Media lista 250000 , 500000 */
			Future<List<Integer>> maximresultat2 = executor.submit(new MaximMinim(llista3));

			/* Combinar las 2 listas anteriores */
			List<Integer> llista4 = maximresultat1.get();
			llista4.addAll(maximresultat2.get());
			Future<List<Integer>> maximresultat3 = executor.submit(new MaximMinim(llista4));

			executor.shutdown();

			/* print zone */

			// System.out.print("maximresultat: ");
			// System.out.println(maximresultat.get().get(0) + " , " +
			// maximresultat.get().get(1));

			System.out.print("maximresultat1: ");
			System.out.println(maximresultat1.get().get(0) + " , " + maximresultat1.get().get(1));

			System.out.print("maximresultat2: ");
			System.out.println(maximresultat2.get().get(0) + " , " + maximresultat2.get().get(1));

			System.out.print("maximresultat3: ");
			System.out.println(maximresultat3.get().get(0) + " , " + maximresultat3.get().get(1));

			System.out.println("Tot Fet");

		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}
}
