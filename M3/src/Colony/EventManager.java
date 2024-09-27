package Colony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EventManager {
	HashMap<String, ArrayList<Observer>> a;

	private static EventManager m_singleton = null;

	private EventManager() {
		super();
		a = new HashMap<String, ArrayList<Observer>>();
	}

	public static EventManager getInstance() {
		if (m_singleton == null)
			m_singleton = new EventManager();

		return m_singleton;
	}



	public void RegisterObserver(String event, Observer obs) {
		ArrayList<Observer> Ob;
		if (!a.containsKey(event)) {
			Ob = new ArrayList<Observer>();
			a.put(event, Ob);

		} else {
			Ob = a.get(event);
		}
		Ob.add(obs);

	}

	public void unregisterObserver(String event, Observer obs) {
		ArrayList<Observer> Ob = a.get(event);
		if (Ob != null) {
			Ob.remove(obs);

		}

	}

	public void notifyObservers(String event) {
		ArrayList<Observer> Ob = a.get(event);
		if (Ob != null) {
			for (Observer observer : Ob) {
				observer.notifyObserver(event);
			}

		}

	}

	@Override
	public String toString() {
		return "EventManager [a=" + a + "]";
	}

}
