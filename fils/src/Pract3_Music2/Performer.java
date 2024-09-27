package Pract3_Music2;

import java.util.concurrent.Callable;

public class Performer implements Callable<Boolean> {
	Object pana;
	int channel;
	Note[] notas;

	public Performer(Note[] Notas, Object Obj, int Channel) {
		notas = Notas;
		pana = Obj;
		channel = Channel;
	}

	@Override
	public Boolean call() {
		try {
			synchronized (pana) {

				pana.wait();

			}

			for (Note note : notas) {

				// System.out.println(note);
				MidiPlayer.play(channel, note);
				for (int i = 0; i < note.getDuration(); i++) {
					// System.out.println("hola2 " + i + " " + note.getDuration());
					synchronized (pana) {
						pana.wait();
					}

				}
				MidiPlayer.stop(channel, note);

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
