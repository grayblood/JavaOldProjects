package Trivial;

/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Modification of EchoClient to test DataStreams with types.
 * Demo code for teaching purposes. Use at your own risk.
 */

public class ClientTrivial {

	public static void main(String[] args) {
		/*
		 * if (args.length != 2) { System.err.println(
		 * "Usage: java EchoClient <host name> <port number>"); System.exit(1); }
		 */
		String hostName = "localhost";//"10.1.82.10";
		int portNumber = 60009;

		BuffEntradaSalida2 bES = null;
		String b;
		boolean end = false;
		try (Socket socket = new Socket(hostName, portNumber);
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

			bES = new BuffEntradaSalida2(socket);

			boolean finish = false;

			try {
				b = TrivialMessages.msgToString(bES.receiveByte());
				System.out.println(b);

				bES.sendByte(TrivialMessages.BYTE_ACK);
				System.out.println("ACK");
				boolean login = true;
				while (login) {

					System.out.println("Pick an username");
					bES.send(stdIn.readLine());
					byte uso = bES.receiveByte();

					if (uso == TrivialMessages.BYTE_NICK_UNAVAILABLE) {
						System.out.println("Username already in use");
						bES.send(stdIn.readLine());
					} else if (uso == TrivialMessages.BYTE_ACK) {
						System.out.println("ACK");
						login = false;
					}
				}
				int vueltas = 0;
				do {
					vueltas++;
					System.out.println(vueltas);
					// Now we wait
					System.out.println("Esperar");
					byte waiting = bES.receiveByte();
					if (waiting == TrivialMessages.BYTE_ON_GAME) {
						System.out.println("El servidor avisa que hi ha una partida en curs");
						bES.sendByte(TrivialMessages.BYTE_ACK);
						waiting = bES.receiveByte();
					}
					if (waiting == TrivialMessages.BYTE_QUEUE) {
						System.out.println("El servidor avisa que es troba en compte enrere per a comenzar partida");
					}

					String json = bES.receive();
					decodejson(1, json);
					bES.sendByte(TrivialMessages.BYTE_ACK);
					
					
					int respuesta = Integer.parseInt(stdIn.readLine());
					bES.sendint(respuesta);
					System.out.println("respuesta: "+ respuesta);
					
					
				
					
					

					System.out.println("reciveACK?");

					bES.receiveByte(TrivialMessages.BYTE_ACK);
					
					
					
					bES.receiveByte();
					
					bES.sendByte(TrivialMessages.BYTE_ACK);
					
					json = bES.receive();

					bES.sendByte(TrivialMessages.BYTE_ACK);
					decodejson(2, json);
					bES.receiveByte(TrivialMessages.BYTE_CONTINUE);
					bES.sendByte(TrivialMessages.BYTE_ACK);
					System.out.println("Continue?");
					String contine =stdIn.readLine();
					
					if (contine.equals("Si")) {
						bES.sendByte(TrivialMessages.BYTE_CONTINUE_YES);
						System.out.println("Si");
					}
					if (contine.equals("No")) {
						System.out.println("No");
						bES.sendByte(TrivialMessages.BYTE_CONTINUE_NO);
						end = true;
					}
					System.out.println("ACK");
					bES.receiveByte(TrivialMessages.BYTE_ACK);
					
				} while (!end);
				System.out.println("Cerrando");
				bES.close();

			} catch (IOException e) {
				System.out.println("Problem reading/sending the input data.");
				e.printStackTrace();
			}

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Another exception.");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void decodejson(int type, String jsonString) throws BuffEntradaSalidaException {
		try {
			JSONParser parser = new JSONParser();

			JSONObject json = (JSONObject) parser.parse(jsonString);
			if (type == 1) {

				System.out.println(json.get("pregunta"));

				JSONArray respuestas = (JSONArray) json.get("respostes");
				for (Iterator iterator = respuestas.iterator(); iterator.hasNext();) {
					Object object = (Object) iterator.next();
					System.out.println(object);
				}
			} else {
				//System.out.println(json.get("resultats"));
				JSONArray resultats = (JSONArray) json.get("resultats");
				for (Iterator iterator = resultats.iterator(); iterator.hasNext();) {
					Object object = (Object) iterator.next();
					System.out.println(object);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BuffEntradaSalidaException("Problema con json");
		}

	}
}
