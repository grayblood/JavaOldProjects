package Pract3_Music;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sound.midi.Instrument;

public class TestMusic {

	public static void main(String[] args) {

		/*
		 * Note[] notesLead = {
		 * 
		 * new Note(Note.Frequency.E3, Note.Duration.negra), new Note(Note.Frequency.E3,
		 * Note.Duration.negra), new Note(Note.Frequency.F3, Note.Duration.negra), new
		 * Note(Note.Frequency.G3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.G3, Note.Duration.negra), new Note(Note.Frequency.F3,
		 * Note.Duration.negra), new Note(Note.Frequency.E3, Note.Duration.negra), new
		 * Note(Note.Frequency.D3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.C3, Note.Duration.negra), new Note(Note.Frequency.C3,
		 * Note.Duration.negra), new Note(Note.Frequency.D3, Note.Duration.negra), new
		 * Note(Note.Frequency.E3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.E3, Note.Duration.semicorchea), new
		 * Note(Note.Frequency.D3, Note.Duration.corchea), new Note(Note.Frequency.D3,
		 * Note.Duration.blanca),
		 * 
		 * 
		 * // --------------------------------------------------//
		 * 
		 * new Note(Note.Frequency.E3, Note.Duration.negra), new Note(Note.Frequency.E3,
		 * Note.Duration.negra), new Note(Note.Frequency.F3, Note.Duration.negra), new
		 * Note(Note.Frequency.G3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.G3, Note.Duration.negra), new Note(Note.Frequency.F3,
		 * Note.Duration.negra), new Note(Note.Frequency.E3, Note.Duration.negra), new
		 * Note(Note.Frequency.D3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.C3, Note.Duration.negra), new Note(Note.Frequency.C3,
		 * Note.Duration.negra), new Note(Note.Frequency.D3, Note.Duration.negra), new
		 * Note(Note.Frequency.E3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.D3, Note.Duration.semicorchea), new
		 * Note(Note.Frequency.C3, Note.Duration.corchea), new Note(Note.Frequency.C3,
		 * Note.Duration.blanca),
		 * 
		 * 
		 * // --------------------------------------------------//
		 * 
		 * new Note(Note.Frequency.D3, Note.Duration.negra), new Note(Note.Frequency.D3,
		 * Note.Duration.negra), new Note(Note.Frequency.E3, Note.Duration.negra), new
		 * Note(Note.Frequency.C3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.D3, Note.Duration.negra), new Note(Note.Frequency.E3,
		 * Note.Duration.corchea), new Note(Note.Frequency.F3, Note.Duration.corchea),
		 * new Note(Note.Frequency.E3, Note.Duration.negra), new Note(Note.Frequency.C3,
		 * Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.D3, Note.Duration.negra), new Note(Note.Frequency.E3,
		 * Note.Duration.corchea), new Note(Note.Frequency.F3, Note.Duration.corchea),
		 * new Note(Note.Frequency.E3, Note.Duration.negra), new Note(Note.Frequency.D3,
		 * Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.C3, Note.Duration.negra), new Note(Note.Frequency.D3,
		 * Note.Duration.negra),
		 * 
		 * 
		 * // --------------------------------------------------//
		 * 
		 * new Note(Note.Frequency.E3, Note.Duration.negra), new Note(Note.Frequency.E3,
		 * Note.Duration.negra), new Note(Note.Frequency.F3, Note.Duration.negra), new
		 * Note(Note.Frequency.G3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.G3, Note.Duration.negra), new Note(Note.Frequency.F3,
		 * Note.Duration.negra), new Note(Note.Frequency.E3, Note.Duration.negra), new
		 * Note(Note.Frequency.D3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.C3, Note.Duration.negra), new Note(Note.Frequency.C3,
		 * Note.Duration.negra), new Note(Note.Frequency.D3, Note.Duration.negra), new
		 * Note(Note.Frequency.E3, Note.Duration.negra),
		 * 
		 * new Note(Note.Frequency.D3, Note.Duration.semicorchea),
		 * 
		 * new Note(Note.Frequency.C3, Note.Duration.corchea), new
		 * Note(Note.Frequency.C3, Note.Duration.blanca),
		 * 
		 * };
		 * 
		 * Note[] notesRythm = {
		 * 
		 * new Note(Note.Frequency.C2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.C2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * // --------------------------------------------------// new
		 * Note(Note.Frequency.C2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * new Note(Note.Frequency.C2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.blanca),
		 * 
		 * new Note(Note.Frequency.C2, Note.Duration.blanca),
		 * 
		 * 
		 * // --------------------------------------------------// new
		 * Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.blanca),
		 * 
		 * 
		 * // --------------------------------------------------// new
		 * Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.redonda),
		 * 
		 * 
		 * new Note(Note.Frequency.G2, Note.Duration.blanca),
		 * 
		 * new Note(Note.Frequency.C2, Note.Duration.blanca),
		 * 
		 * };
		 */
		Note[] arpegio = { new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),

				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),

				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),

				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),

				new Note(Note.Frequency.C7, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),

				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),

				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),

				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),

				new Note(Note.Frequency.A2, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),

				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),

				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),

				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),

				new Note(Note.Frequency.A6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),

				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),

				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),

				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),

				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),

				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),

				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),

				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),

				new Note(Note.Frequency.C7, Note.Duration.semicorchea),
				new Note(Note.Frequency.G6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.D6, Note.Duration.semicorchea),

				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.G5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.D5, Note.Duration.semicorchea),

				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.G4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.D4, Note.Duration.semicorchea),

				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.G3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.semicorchea),

				new Note(Note.Frequency.A2, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),

				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),

				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),

				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),

				new Note(Note.Frequency.A6, Note.Duration.semicorchea),
				new Note(Note.Frequency.E6, Note.Duration.semicorchea),
				new Note(Note.Frequency.C6, Note.Duration.semicorchea),
				new Note(Note.Frequency.B5, Note.Duration.semicorchea),

				new Note(Note.Frequency.A5, Note.Duration.semicorchea),
				new Note(Note.Frequency.E5, Note.Duration.semicorchea),
				new Note(Note.Frequency.C5, Note.Duration.semicorchea),
				new Note(Note.Frequency.B4, Note.Duration.semicorchea),

				new Note(Note.Frequency.A4, Note.Duration.semicorchea),
				new Note(Note.Frequency.E4, Note.Duration.semicorchea),
				new Note(Note.Frequency.C4, Note.Duration.semicorchea),
				new Note(Note.Frequency.B3, Note.Duration.semicorchea),

				new Note(Note.Frequency.A3, Note.Duration.semicorchea),
				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.semicorchea),
				new Note(Note.Frequency.B2, Note.Duration.semicorchea), };

		Note[] piano = {
				// new Note(Note.Frequency.SILENCE, Note.Duration.redonda*12),

				new Note(Note.Frequency.C6, Note.Duration.redonda),

				new Note(Note.Frequency.B5, Note.Duration.blanca),

				new Note(Note.Frequency.D6, Note.Duration.blanca),

				/* 1 */
				new Note(Note.Frequency.C6, Note.Duration.redonda),

				new Note(Note.Frequency.D6, Note.Duration.negra),

				new Note(Note.Frequency.C6, Note.Duration.negra),

				new Note(Note.Frequency.B5, Note.Duration.negra),

				new Note(Note.Frequency.D6, Note.Duration.negra),
				/* 1end */

				new Note(Note.Frequency.C6, Note.Duration.redonda),

				new Note(Note.Frequency.B5, Note.Duration.blanca),

				new Note(Note.Frequency.D6, Note.Duration.blanca),

				/* 2 */
				new Note(Note.Frequency.D6, Note.Duration.corchea), new Note(Note.Frequency.E6, Note.Duration.corchea),

				new Note(Note.Frequency.C6, Note.Duration.blanca + Note.Duration.negra),

				new Note(Note.Frequency.E6, Note.Duration.negra),

				new Note(Note.Frequency.D6, Note.Duration.negra),

				new Note(Note.Frequency.C6, Note.Duration.negra),

				new Note(Note.Frequency.B5, Note.Duration.negra),
				/* 2end */
		};

		Note[] piano2 = {
				// new Note(Note.Frequency.SILENCE, Note.Duration.redonda*12),

				new Note(Note.Frequency.C5, Note.Duration.redonda),

				new Note(Note.Frequency.B4, Note.Duration.blanca),

				new Note(Note.Frequency.D5, Note.Duration.blanca),

				/* 1 */
				new Note(Note.Frequency.C5, Note.Duration.redonda),

				new Note(Note.Frequency.F5, Note.Duration.negra),

				new Note(Note.Frequency.E5, Note.Duration.negra),

				new Note(Note.Frequency.D5, Note.Duration.negra),

				new Note(Note.Frequency.F5, Note.Duration.negra),
				/* 1end */

				new Note(Note.Frequency.C5, Note.Duration.redonda),

				new Note(Note.Frequency.B4, Note.Duration.blanca),

				new Note(Note.Frequency.D5, Note.Duration.blanca),

				/* 2 */
				new Note(Note.Frequency.D5, Note.Duration.corchea), new Note(Note.Frequency.E5, Note.Duration.corchea),

				new Note(Note.Frequency.C5, Note.Duration.blanca + Note.Duration.negra),

				new Note(Note.Frequency.C6, Note.Duration.negra),

				new Note(Note.Frequency.B5, Note.Duration.negra),

				new Note(Note.Frequency.A5, Note.Duration.negra),

				new Note(Note.Frequency.G5, Note.Duration.negra),
				/* 2end */
		};

		Note[] piano3 = {
				// new Note(Note.Frequency.SILENCE, Note.Duration.redonda*12),

				new Note(Note.Frequency.E5, Note.Duration.redonda),

				new Note(Note.Frequency.D5, Note.Duration.blanca),

				new Note(Note.Frequency.F5, Note.Duration.blanca),

				/* 1 */
				new Note(Note.Frequency.E5, Note.Duration.redonda),

				new Note(Note.Frequency.SILENCE, Note.Duration.redonda),
				/* 1end */

				new Note(Note.Frequency.E5, Note.Duration.redonda),

				new Note(Note.Frequency.D5, Note.Duration.blanca),

				new Note(Note.Frequency.F5, Note.Duration.blanca),

				/* 2 */
				new Note(Note.Frequency.B5, Note.Duration.corchea), new Note(Note.Frequency.C6, Note.Duration.corchea),

				new Note(Note.Frequency.A5, Note.Duration.blanca + Note.Duration.negra),

				new Note(Note.Frequency.SILENCE, Note.Duration.redonda)
				/* 2end */
		};
		Instrument[] instruments = MidiPlayer.getInstruments();
		System.out.println("Changing instrument to: " + instruments[2].getName());
		int h = 0;

		for (Instrument instrument : instruments) {
			
			System.out.println(instrument.getName() + h);
			h++;
		}

		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Conductor c = new Conductor(125);
		executor.submit(new Performer(arpegio, c, 0));
		executor.submit(new Performer(piano, c, 1));
		executor.submit(new Performer(piano2, c, 2));
		executor.submit(new Performer(piano3, c, 3));
		MidiPlayer.setInstrument(instruments[46], 0);
		MidiPlayer.setInstrument(instruments[0], 1);
		MidiPlayer.setInstrument(instruments[1], 2);
		MidiPlayer.setInstrument(instruments[2], 3);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executor.submit(c);

		executor.shutdown();

	}
}
