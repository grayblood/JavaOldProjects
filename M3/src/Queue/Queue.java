package Queue;
import java.util.ArrayList;

public class Queue<T> {

	ArrayList<T> a = new ArrayList<T>();

	public T Pop() {
		T coso = a.get(0);
		a.remove(0);
		System.out.println(coso);
		return coso;

	}

	public void Push(T element) {
		a.add(element);

	}
	public void see() {
		System.out.println(a.get(0));
	}
	
}
