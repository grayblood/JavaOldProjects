package Pool;
import java.util.ArrayList;

public class Pool {
	public ArrayList<Object> Pool = new ArrayList<Object>();
	public ArrayList<Boolean> m_availability = new ArrayList<Boolean>();;

	public Pool() {
		Object a1 = new Object();
		Object a2 = new Object();
		Object a3 = new Object();
		Object a4 = new Object();
		Object a5 = new Object();

		Pool.add(a1);
		Pool.add(a2);
		Pool.add(a3);
		Pool.add(a4);
		Pool.add(a5);

		for (int i = 0; i < 10; i++) {
			m_availability.add(true);
		}

	}

	public Object get() {
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
		return Pool;

	}

	public void retorn(Object element) {
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
