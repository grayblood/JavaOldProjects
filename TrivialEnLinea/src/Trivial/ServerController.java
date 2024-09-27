package Trivial;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerController {
	public static void main(String[] args) {

		int portNumber = 60009;
		try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
			ExecutorService executor = Executors.newCachedThreadPool();
			ManagerServer server = new ManagerServer();
			executor.submit(server);
			while (true) {
				System.out.println("Esperant que es connecti un client");
				Socket clientSocket = serverSocket.accept();
				
				executor.submit(new ClientHandler(clientSocket, server));
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen to port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
