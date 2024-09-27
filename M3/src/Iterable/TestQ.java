package Iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class TestQ {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(3);
		list.add(23);
		list.add(2);
		list.add(98);
		list.add(27);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		for (Integer obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
		Iterator<Integer> iterador = list.iterator();
		while (iterador.hasNext()) {
			Integer obj = iterador.next();
			System.out.print(obj + " ");
		}

		System.out.println();
		System.out.println();

		Queue<Integer> queue = new Queue<Integer>();

		queue.Push(3);
		queue.Push(2);
		queue.Push(1);
		queue.Push(4);
		queue.Push(7);
		queue.Push(8);
		queue.Push(5);
		for (Integer integer : queue) {

			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("Queue");
	}
}
