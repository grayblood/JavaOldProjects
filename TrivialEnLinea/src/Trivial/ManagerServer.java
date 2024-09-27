package Trivial;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ManagerServer implements Callable<Boolean> {
	// Controlador de semaforo
	HashMap<String, Integer> playerNames = new HashMap<String, Integer>();

	int jugadores = 0;
	private boolean jugando = false;
	public final Object lobby = new Object();
	public final Object conectar = new Object();
	public final Object empezar = new Object();
	public final Object jugado = new Object();
	public final Object puntuacion = new Object();
	public final Object todosJugadores = new Object();

	private void reset() {
		jugadores = 0;
		jugando = false;
	}

	public ManagerServer() throws IOException {
		playerNames.put("Player1", 0);

	}

	public synchronized boolean nickDisponible(String name) {

		if (!playerNames.containsKey(name)) {
			playerNames.put(name, 0);

			return true;
		} else {

			return false;
		}
	}

	public boolean PuedoJugar() {
		synchronized (conectar) {
			if (!jugando) {
				jugadores++;
				conectar.notifyAll();
				return true;
			}
			return false;
		}
	}

	private void esperarJugadores() throws InterruptedException {
		synchronized (jugado) {
			int totalJugadores = jugadores;
			System.out.println(totalJugadores);
			while (totalJugadores > 0) {
				jugado.wait();
				totalJugadores--;
				System.out.println(totalJugadores);
			}
		}
	}

	public void jugadorRespondido(String nick, boolean correcto) throws InterruptedException {
		synchronized (jugado) {
			// buscar jugador
			// actualizar puntuacion
			if (correcto) {
				playerNames.put(nick, playerNames.get(nick) + 1);
			}
			jugado.notify();
		}
	}

	public String GetPlayers() {
		JSONArray resultats = new JSONArray();

		for (Map.Entry<String, Integer> entry : playerNames.entrySet()) {
			JSONObject a = new JSONObject();
			a.put(entry.getKey(), entry.getValue());
			resultats.add(a);
		}
		JSONObject a = new JSONObject();
		a.put("resultats", resultats);
		System.out.println(a);
		return a.toString();

	}

	public Boolean call() {
		try {

			while (true) {

				// lobby
				reset();
				synchronized (conectar) {
					synchronized (lobby) {
						lobby.notifyAll();
					}
					conectar.wait();
				}
				Thread.sleep(4500);
				jugando = true;
				Thread.sleep(500);

				// preparar la pregunta en json
				synchronized (empezar) {
					empezar.notifyAll();
				}

				// esperar que terminen los jugadores
				esperarJugadores();
				synchronized (todosJugadores) {
					todosJugadores.notifyAll();
				}

			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return false;

	}
}
