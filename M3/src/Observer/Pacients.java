package Observer;

public class Pacients implements Observer {
	private String Nom;
	Consulta m_consulta;
	private static int id = 0;

	public Pacients() {
		Nom = "Paciente" + id;
		id++;

	}

	public Pacients(Consulta consulta) {
		Nom = "Paciente" + id;
		id++;
		m_consulta = consulta;
	}

	@Override
	public String toString() {
		return "Pacients [Nom=" + Nom + "]";
	}

	@Override
	public void notifyObserver(String nom) {

		if (this.Nom.equals(nom)) {
			System.out.println(this + ": mi turno");
			if (m_consulta != null) {
				m_consulta.unregisterObserver(this);
			}
		} else {
			System.out.println(this + " Waiting");
		}

	}

}
