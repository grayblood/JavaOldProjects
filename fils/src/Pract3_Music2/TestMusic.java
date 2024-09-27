package Pract3_Music2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.midi.Instrument;

public class TestMusic {

	public static void main(String[] args) {
		Instrument[] instruments = MidiPlayer.getInstruments();
		System.out.println("Changing instrument to: " + instruments[2].getName());

		Note[] notesLead = {

				// F -> Fs
				// D -> Ds
				new Note(Note.Frequency.Fs5, Note.Duration.negra + Note.Duration.corchea),
				new Note(Note.Frequency.E5, Note.Duration.corchea), 
				new Note(Note.Frequency.Ds5, Note.Duration.negra),
				new Note(Note.Frequency.Ds5, Note.Duration.negra),

				new Note(Note.Frequency.E5, Note.Duration.negra), 
				new Note(Note.Frequency.Ds5, Note.Duration.negra),
				new Note(Note.Frequency.Ds5, Note.Duration.blanca), 
				
				// --------------------------------------------------//
				new Note(Note.Frequency.Fs5, Note.Duration.negra + Note.Duration.corchea),
				new Note(Note.Frequency.E5, Note.Duration.corchea), 
				new Note(Note.Frequency.Ds5, Note.Duration.negra),
				new Note(Note.Frequency.Ds5, Note.Duration.negra),

				new Note(Note.Frequency.E5, Note.Duration.negra), 
				new Note(Note.Frequency.A6, Note.Duration.negra),
				new Note(Note.Frequency.Fs5, Note.Duration.blanca), 
				// --------------------------------------------------//
				// --------------------------------------------------//
				new Note(Note.Frequency.Fs5, Note.Duration.negra + Note.Duration.corchea),
				new Note(Note.Frequency.E5, Note.Duration.corchea), 
				new Note(Note.Frequency.Ds5, Note.Duration.negra),
				new Note(Note.Frequency.Ds5, Note.Duration.negra),

				new Note(Note.Frequency.E5, Note.Duration.negra), 
				new Note(Note.Frequency.Ds5, Note.Duration.negra),
				new Note(Note.Frequency.Ds5, Note.Duration.blanca), 
				new Note(Note.Frequency.Ds5, Note.Duration.corchea),
				new Note(Note.Frequency.E5, Note.Duration.corchea),
				// --------------------------------------------------//
				new Note(Note.Frequency.Fs5, Note.Duration.redonda), 

				new Note(Note.Frequency.G5, Note.Duration.negra),

				// --------------------------------------------------//
				// --------------------------------------------------//

		};

		Note[] notesRythm = { 
				new Note(Note.Frequency.F3, Note.Duration.negra),
				new Note(Note.Frequency.C3, Note.Duration.negra), 
				new Note(Note.Frequency.G3, Note.Duration.negra),
				new Note(Note.Frequency.C3, Note.Duration.negra),

				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.F3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				// --------------------------------------------------//
				new Note(Note.Frequency.F3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.G3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),

				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.G2, Note.Duration.negra),
				new Note(Note.Frequency.F2, Note.Duration.negra),
				new Note(Note.Frequency.C3, Note.Duration.negra),
				// --------------------------------------------------//
				// --------------------------------------------------//
				new Note(Note.Frequency.F3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.G3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),


				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.F3, Note.Duration.blanca),
				
				// --------------------------------------------------//
				new Note(Note.Frequency.Cs3, Note.Duration.semicorchea),
				new Note(Note.Frequency.F2, Note.Duration.corchea),
				new Note(Note.Frequency.B2, Note.Duration.negra),
				new Note(Note.Frequency.C3, Note.Duration.negra),

				new Note(Note.Frequency.F2 + Note.Frequency.B2 , Note.Duration.redonda), 
				

				// --------------------------------------------------//
				// --------------------------------------------------//

		};
		int h = 0;
		for (Instrument instrument : instruments) {

			System.out.println(instrument.getName() + " " + h);
			h++;
		}
		ExecutorService executor = Executors.newCachedThreadPool();
		MidiPlayer.setInstrument(instruments[1], 0);
		MidiPlayer.setInstrument(instruments[2], 1);
		Conductor c = new Conductor(160);
		
		executor.submit(new Performer(notesRythm, c, 1));
		//executor.submit(new Performer(notesLead, c, 0));

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executor.submit(c);

		executor.shutdown();

	}// https://musescore.com/user/3597581/scores/1046571

}
