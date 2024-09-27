package Observer;


import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Consulta Consulta = new Consulta();
		ArrayList<Observer> pacientes = new ArrayList<Observer>();

		for (int i = 0; i < 10; i++) {
			Pacients paciente = new Pacients();
			pacientes.add(paciente);
			Consulta.registerObserver(paciente);

		}

		// passen coses
		Consulta.notifyObservers("Paciente3");

	}
}
