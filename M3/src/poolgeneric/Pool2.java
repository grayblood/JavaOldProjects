package poolgeneric;
import java.util.ArrayList;

public class Pool2<T> {
	public ArrayList<T> Pool = new ArrayList<T>();
	public ArrayList<Boolean> m_availability = new ArrayList<Boolean>();;

	public Pool2() {
		Object a1 = new Object();
		Object a2 = new Object();
		Object a3 = new Object();
		Object a4 = new Object();
		Object a5 = new Object();

		Pool.add((T) a1);
		Pool.add((T) a2);
		Pool.add((T) a3);
		Pool.add((T) a4);
		Pool.add((T) a5);

		for (int i = 0; i < 10; i++) {
			m_availability.add(true);
		}

	}

	public T get() {
		try {

			for (int i = 0; i < Pool.size(); i++) {
				if (m_availability.get(i)) {
					m_availability.set(i, false);
					return Pool.get(i);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (T) Pool;

	}

	public void retorn(T element) {
		for (int i = 0; i < Pool.size(); i++) {

			if (Pool.get(i) == element) {
				m_availability.set(i, true);
			}
		}
	}

	@Override
	public String toString() {
		return "Pool [Pool=" + Pool + ", m_availability=" + m_availability + "]";
	}

}
