package Colony;

import java.util.ArrayList;

public class Scheduler {
	static ArrayList<Settler> Settlers = new ArrayList<Settler>();
	static ArrayList<Room> Colony = new ArrayList<Room>();
	static Settler s;
	static Room room;
	static EventManager e = EventManager.getInstance();

	public static void main(String[] args) {

		room = new Room("Medbay");

		room.addMachine(new Dispenser());
		room.addMachine(new Autotreat());
		room.addMachine(new Laboratory());
		Colony.add(room);

		room = new Room("Engineering");

		room.addMachine(new Dispenser());
		room.addMachine(new Welding());
		room.addMachine(new Laboratory());
		Colony.add(room);

		room = new Room("Maintenance");

		room.addMachine(new Dispenser());
		room.addMachine(new Welding());
		room.addMachine(new Broom());
		Colony.add(room);

		for (int i = 0; i < 10; i++) {
			s = new Settler("Settler" + i);

			Settlers.add(s);

		}
	

		s = SearchSettler(1);
		e.RegisterObserver("Medbay", s);
		s = SearchSettler(2);
		e.RegisterObserver("Medbay", s);
		s = SearchSettler(3);
		e.RegisterObserver("Medbay", s);

		s = SearchSettler(4);
		e.RegisterObserver("Engineering", s);
		s = SearchSettler(5);
		e.RegisterObserver("Engineering", s);
		s = SearchSettler(6);
		e.RegisterObserver("Engineering", s);

		s = SearchSettler(7);
		e.RegisterObserver("Maintenance", s);
		s = SearchSettler(8);
		e.RegisterObserver("Maintenance", s);
		s = SearchSettler(9);
		e.RegisterObserver("Maintenance", s);

		
		Notificar("Maintenance");
		Notificar("Medbay");
		Notificar("Engineering");

	}

	public static void Notificar(String name) {
		e.notifyObservers(name);
		for (Room room : Colony) {
			if (room.getM_name() == name) {
				System.out.println();
				room.Funcion();
				System.out.println();
				
			}
		}
		
		
		
	}

	public static Settler SearchSettler(int i) {
		Settler settler = Settlers.get(i);
		return settler;

	}

}
