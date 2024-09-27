import java.util.ArrayList;
import java.util.HashMap;



public class EventListener {
	HashMap<String, ArrayList<IObserver>> a;

	private static EventListener m_singleton = null;

	private EventListener() {
		super();
		a = new HashMap<String, ArrayList<IObserver>>();
	}

	public static EventListener getInstance() {
		if (m_singleton == null)
			m_singleton = new EventListener();

		return m_singleton;
	}



	public void RegisterObserver(String event, IObserver obs) {
		ArrayList<IObserver> Ob;
		if (!a.containsKey(event)) {
			Ob = new ArrayList<IObserver>();
			a.put(event, Ob);

		} else {
			Ob = a.get(event);
		}
		Ob.add(obs);

	}

	public void unregisterObserver(String event, IObserver obs) {
		ArrayList<IObserver> Ob = a.get(event);
		if (Ob != null) {
			Ob.remove(obs);

		}

	}

	public void notifyObservers(String event, GameObject Entity) {
		ArrayList<IObserver> Ob = a.get(event);
		if (Ob != null) {
			for (IObserver observer : Ob) {
				observer.notifyObserver(event, Entity);
			}

		}

	}

	@Override
	public String toString() {
		return "EventListener [a=" + a + "]";
	}
}
