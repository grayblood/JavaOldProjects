package Colony;

public class Settler implements Observer {
	private String n_nom;

	public Settler(String name) {
		n_nom = name;
	}


	@Override
	public void notifyObserver(String nom) {
		System.out.println(n_nom + " ves a la sala: " + nom);
		
	}


	public String getN_nom() {
		return n_nom;
	}


	@Override
	public String toString() {
		return "Settler [n_nom=" + n_nom + "]";
	}
	
}
