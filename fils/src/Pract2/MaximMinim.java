package Pract2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MaximMinim implements Callable<List<Integer>> {
	List<Integer> llista;
	int max;
	int min;
	 long start;
	public MaximMinim(List<Integer> llista2) {
		  start = System.currentTimeMillis();
		this.llista = llista2;
		max = 0;
		min = 999999;
	}

	public List<Integer> call() {
		for (Integer callable : llista) {

			int current;

			current = callable;
			if (current > max) {
				max = current;
			}
			if (current < min) {
				min = current;
			}

		}
		List<Integer> resultados = new ArrayList<Integer>();
		resultados.add(max);
		resultados.add(min);
		long end = System.currentTimeMillis();
	      //finding the time difference and converting it into seconds
	      float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
		return resultados;
	}

}
