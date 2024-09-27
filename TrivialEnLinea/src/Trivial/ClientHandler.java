package Trivial;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;



//añadir minimo 2 JUGADORES

public class ClientHandler implements Callable<String> {
	Socket socket;

	BuffEntradaSalida2 bES = null;
	Boolean available = false;
	ManagerServer server;
	String name;

	public ClientHandler(Socket socket, ManagerServer server) throws IOException {
		this.socket = socket;
		bES = new BuffEntradaSalida2(socket);
		this.server = server;

	}

	@Override
	public String call() throws Exception {
		try {
			System.out.println(
					Thread.currentThread().getName() + ": Connection established with " + socket.getInetAddress()
							+ " at port " + socket.getPort() + " and local port " + socket.getLocalPort());

			// conectar
			bES.sendByte(TrivialMessages.BYTE_WELCOME);
			bES.receiveByte(TrivialMessages.BYTE_ACK);

			// Nick
			do {

				System.out.println("preguntar nombre");
				name = bES.receive();
				System.out.println(name);
				available = server.nickDisponible(name);
				System.out.println(available);

				if (available) {
					bES.sendByte(TrivialMessages.BYTE_ACK);
					System.out.println("available");
				} else {
					bES.sendByte(TrivialMessages.BYTE_NICK_UNAVAILABLE);
					System.out.println("Unavailable");
				}
			} while (!available);
			boolean seguir = true;
			do {
				boolean lobby = true;

				do {

					System.out.println("Preparando Lobby");

					if (server.PuedoJugar()) {
						bES.sendByte(TrivialMessages.BYTE_QUEUE);
						System.out.println("available");
						lobby = false;
					} else {
						bES.sendByte(TrivialMessages.BYTE_ON_GAME);
						System.out.println("Unavailable");
						synchronized (server.lobby) {
							server.lobby.wait();
						}
					}
				} while (lobby);

				System.out.println("Esperando la cola");
				synchronized (server.empezar) {
					server.empezar.wait();
				}
				String pregunta = "{\"pregunta\": \"Pregunta de dues respostes\",\"respostes\": [\"Resposta Correcte\",\"Resposta incorrecte\"]}";
				System.out.println(pregunta);
				bES.send(pregunta);
				
				System.out.println("ACK");
				bES.receiveByte(TrivialMessages.BYTE_ACK);


				
				
				
				int resposta = bES.ReceiveInt();		
				System.out.println("respuesta "+ resposta);
				
				
				
				boolean correcto = false;
				
				bES.sendByte(TrivialMessages.BYTE_ACK);
				System.out.println("ACK");
				if (resposta == 1) {
					bES.sendByte(TrivialMessages.BYTE_ANSWER_CORRECT);
					System.out.println("a correcte");

					correcto = true;
				}
				if (resposta == 2) {
					bES.sendByte(TrivialMessages.BYTE_ANSWER_WRONG);
					System.out.println("incorrecte");

					correcto = false;
				}
				
				
				synchronized (server.todosJugadores) {
					server.jugadorRespondido(name, correcto);
					server.todosJugadores.wait();
					bES.receiveByte(TrivialMessages.BYTE_ACK);
					System.out.println("todos jugadores");

				}
				
				String puntuacion = server.GetPlayers();
				bES.send(puntuacion);
				System.out.println("ENVIAR PUNTUACION");
				
				
				bES.receiveByte(TrivialMessages.BYTE_ACK);
				System.out.println("ACK");
				bES.sendByte(TrivialMessages.BYTE_CONTINUE);
				System.out.println("CONTINUE");
				bES.receiveByte(TrivialMessages.BYTE_ACK);
				System.out.println("ACK");

				System.out.println("Continuar?");
				byte cont = bES.receiveByte();

				if (cont == TrivialMessages.BYTE_CONTINUE_YES) {
					System.out.println("Si");
				} else if (cont == TrivialMessages.BYTE_CONTINUE_NO) {
					System.out.println("No");

					seguir = false;
				}
				bES.sendByte(TrivialMessages.BYTE_ACK);
			} while (seguir);
			bES.close();
		} catch (IOException | BuffEntradaSalidaException e) {
			System.out.println("Exception caught when trying to listen to port " + socket.getLocalPort()
					+ " or listening for a connection");
			System.out.println(e.getMessage());
		}

		

		// TODO Auto-generated method stub
		return null;
	}
}
