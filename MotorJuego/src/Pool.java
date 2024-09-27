import java.util.ArrayList;

public class Pool<T> {

	ArrayList<T> m_elements = new ArrayList<T>();

	IPoolableFactory<T> m_facFactory = new IPoolableFactory<T>() {
	
		
		@Override
		public T create() {
			m_elements.add(null);
			return null;
		}

		@Override
		public void activate(T element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deactivate(T element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(T element) {
			// TODO Auto-generated method stub
			
		}
	};

	public T getElement() {

		return null;
	}

	public boolean tryReturnElement(T gameObject) {
		return false;

	}

}