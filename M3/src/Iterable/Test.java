package Iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
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

		Stack<Integer> stack = new Stack<Integer>();

		stack.Push(3);
		stack.Push(2);
		stack.Push(1);
		stack.Push(4);
		stack.Push(7);
		stack.Push(8);
		stack.Push(5);
		for (Integer integer : stack) {

			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("Stack");

	}
}
