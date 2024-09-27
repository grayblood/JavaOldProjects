package Observer;

import java.util.ArrayList;

public class Consulta
{
	ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registerObserver(Observer observer)
	{
		observers.add(observer);
	}
	
	public void unregisterObserver(Observer observer)
	{
		observers.remove(observer);
	}

	public void notifyObservers(String nom)
	{
		for(Observer observer: observers)
			observer.notifyObserver(nom);
	}
}
