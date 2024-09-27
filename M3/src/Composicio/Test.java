package Composicio;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {

		ArrayList<Spell> Element = new ArrayList<Spell>();
		Spell Hechizo = new Spell("Meteorito");

		Hechizo.addComportament(new Earth());
		Hechizo.addComportament(new Fire());
		Element.add(Hechizo);
		Hechizo = new Spell("Congelar");
		Hechizo.addComportament(new Water());
		Hechizo.addComportament(new Wind());
		Element.add(Hechizo);
		Hechizo = new Spell("Barro");
		Hechizo.addComportament(new Water());
		Hechizo.addComportament(new Earth());
		Element.add(Hechizo);
		Hechizo = new Spell("Turnato du fogo");
		Hechizo.addComportament(new Fire());
		Hechizo.addComportament(new Wind());
		Element.add(Hechizo);

		System.out.println("Castear");
		for (Spell hechizo : Element) {
			hechizo.cast();
		}
	}
}
