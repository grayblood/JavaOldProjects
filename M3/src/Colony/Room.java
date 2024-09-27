package Colony;

import java.util.ArrayList;

public class Room {

	private String m_name;

	public Room(String name) {
		m_name = name;
	}

	ArrayList<Compor> comportaments = new ArrayList<Compor>();

	void addMachine(Compor comportament) {
		comportaments.add(comportament);
	}

	void removeMachine(Compor comportament) {
		comportaments.remove(comportament);
	}


	void Funcion() {
		System.out.println("Sala: " + m_name);
		for (Compor comportament : comportaments) {
			System.out.print(" - ");
			comportament.Funcion();
		}

	}

	public String getM_name() {
		return m_name;
	}

	@Override
	public String toString() {
		return "Room [m_name=" + m_name + "]";
	}


}
