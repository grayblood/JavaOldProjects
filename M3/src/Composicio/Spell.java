package Composicio;

import java.util.ArrayList;

public class Spell {
	String m_name;

	public Spell(String name) {
		m_name = name;
	}

	ArrayList<Compor> comportaments = new ArrayList<Compor>();

	void addComportament(Compor comportament) {
		comportaments.add(comportament);
	}

	void removeComportament(Compor comportament) {
		comportaments.remove(comportament);
	}

	void cast() {
		System.out.println("Hechizo: " + m_name);
		for (Compor comportament : comportaments) {
			comportament.cast();
		}
	}
}
