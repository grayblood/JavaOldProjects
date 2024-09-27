
public interface IPoolableFactory<T>{
	public T create();
	public void activate(T element);
	public void deactivate(T element);
	public void delete(T element);
	
}
