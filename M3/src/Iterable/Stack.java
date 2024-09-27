package Iterable;
import java.util.ArrayList;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

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
	
	private class MyStackIterator<T> implements Iterator<T>
	{
		private int comptador = a.size();
		@Override
		public boolean hasNext()
		{
			//comprovar si hi ha un següent element i tornar
			//true o false
			if((comptador-1)>=0)
				return true;
			
			return false;
		}

		@Override
		public T next()
		{
			//em mouria a la posici del segent element i el retornaria
			comptador--;
			return (T) a.get(comptador);
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyStackIterator<T>();
	}
	
}
