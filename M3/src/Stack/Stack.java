package Stack;
import java.util.ArrayList;

public class Stack<T> {

	ArrayList<T> a = new ArrayList<T>();

	public T Pop() {
		T coso = a.get(a.size() - 1);
		a.remove(a.size() - 1);
		System.out.println(coso);
		return coso;

	}

	public void Push(T element) {
		a.add(element);

	}
	public void see() {
		System.out.println(a.get(a.size()-1));
	}
	
}
