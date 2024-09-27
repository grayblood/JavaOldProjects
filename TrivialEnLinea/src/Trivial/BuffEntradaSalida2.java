package Trivial;

import java.net.Socket;


import java.io.*;
import java.net.*;

public class BuffEntradaSalida2 {
	DataOutputStream out;
	DataInputStream in;
	PrintWriter outs;
	BufferedReader ins;

	public BuffEntradaSalida2(Socket socket) throws IOException {
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
		outs = new PrintWriter(socket.getOutputStream(), true);
		ins = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	void close() {
		try {
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Problema de cerrado de buffers: " + e.getMessage());
		}
	}

	void send(String message) throws IOException {
		outs.println(message);
	}

	void sendint(int num) throws IOException {

		out.writeInt(num);
	}

	int ReceiveInt() throws IOException {
		int a = in.readInt();
		//System.out.println(a);
		return a;
	}

	void sendByte(byte message) throws IOException {
		out.writeByte(message);
	}

	byte receiveByte() throws IOException {

		byte a = in.readByte();
		//System.out.println(a);
		// return TrivialMessages.msgToString(in.readByte());
		return a;
	}

	void receiveByte(byte message) throws IOException, BuffEntradaSalidaException {
		byte recibido = receiveByte();
		if (recibido != message) {
			throw new BuffEntradaSalidaException("Esperaba recibir " + TrivialMessages.msgToString(message)
					+ " pero recibi " + TrivialMessages.msgToString(recibido));
		}

	}

	String receive() throws IOException {
		return ins.readLine();
	}

	void receive(String message) throws IOException, BuffEntradaSalidaException {
		String recibido = receive();
		if (!recibido.equals(message))
			throw new BuffEntradaSalidaException("Esperaba recibir " + message + " pero recibi " + recibido);
	}

}
