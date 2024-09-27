package Pract3_Music2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sound.midi.Instrument;

public class TestMusic2 {

	public static void main(String[] args) {
		
		Instrument[] instruments = MidiPlayer.getInstruments();
		System.out.println("Changing instrument to: " + instruments[2].getName());
		Note[] notesLead = { 
				new Note(Note.Frequency.E3, Note.Duration.negra),
				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.F3, Note.Duration.negra),
				new Note(Note.Frequency.G3, Note.Duration.negra),

				new Note(Note.Frequency.G3, Note.Duration.negra), 
				new Note(Note.Frequency.F3, Note.Duration.negra),
				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.D3, Note.Duration.negra),

				new Note(Note.Frequency.C3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.D3, Note.Duration.negra), 
				new Note(Note.Frequency.E3, Note.Duration.negra),

				new Note(Note.Frequency.E3, Note.Duration.semicorchea),
				new Note(Note.Frequency.D3, Note.Duration.corchea), 
				new Note(Note.Frequency.D3, Note.Duration.blanca),
				

				// --------------------------------------------------//

				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.E3, Note.Duration.negra),
				new Note(Note.Frequency.F3, Note.Duration.negra), 
				new Note(Note.Frequency.G3, Note.Duration.negra),

				new Note(Note.Frequency.G3, Note.Duration.negra), 
				new Note(Note.Frequency.F3, Note.Duration.negra),
				new Note(Note.Frequency.E3, Note.Duration.negra),
				new Note(Note.Frequency.D3, Note.Duration.negra),

				new Note(Note.Frequency.C3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.D3, Note.Duration.negra),
				new Note(Note.Frequency.E3, Note.Duration.negra),

				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				new Note(Note.Frequency.C3, Note.Duration.corchea), 
				new Note(Note.Frequency.C3, Note.Duration.blanca),
				

				// --------------------------------------------------//

				new Note(Note.Frequency.D3, Note.Duration.negra), 
				new Note(Note.Frequency.D3, Note.Duration.negra),
				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.C3, Note.Duration.negra),

				new Note(Note.Frequency.D3, Note.Duration.negra), 
				new Note(Note.Frequency.E3, Note.Duration.corchea),
				new Note(Note.Frequency.F3, Note.Duration.corchea), 
				new Note(Note.Frequency.E3, Note.Duration.negra),
				new Note(Note.Frequency.C3, Note.Duration.negra),

				new Note(Note.Frequency.D3, Note.Duration.negra), 
				new Note(Note.Frequency.E3, Note.Duration.corchea),
				new Note(Note.Frequency.F3, Note.Duration.corchea), 
				new Note(Note.Frequency.E3, Note.Duration.negra),
				new Note(Note.Frequency.D3, Note.Duration.negra),

				new Note(Note.Frequency.C3, Note.Duration.negra), 
				new Note(Note.Frequency.D3, Note.Duration.negra),
				

				// --------------------------------------------------//

				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.E3, Note.Duration.negra),
				new Note(Note.Frequency.F3, Note.Duration.negra), 
				new Note(Note.Frequency.G3, Note.Duration.negra),

				new Note(Note.Frequency.G3, Note.Duration.negra), 
				new Note(Note.Frequency.F3, Note.Duration.negra),
				new Note(Note.Frequency.E3, Note.Duration.negra), 
				new Note(Note.Frequency.D3, Note.Duration.negra),

				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.C3, Note.Duration.negra),
				new Note(Note.Frequency.D3, Note.Duration.negra), 
				new Note(Note.Frequency.E3, Note.Duration.negra),

				new Note(Note.Frequency.D3, Note.Duration.semicorchea),
				
				new Note(Note.Frequency.C3, Note.Duration.corchea),
				new Note(Note.Frequency.C3, Note.Duration.blanca),

		};

		Note[] notesRythm = {

				new Note(Note.Frequency.C2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				new Note(Note.Frequency.C2, Note.Duration.redonda),
			

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				// --------------------------------------------------//
				new Note(Note.Frequency.C2, Note.Duration.redonda),
			

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				
				new Note(Note.Frequency.C2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.blanca),
				
				new Note(Note.Frequency.C2, Note.Duration.blanca),
				

				// --------------------------------------------------//
				new Note(Note.Frequency.G2, Note.Duration.redonda),
	

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				
				new Note(Note.Frequency.G2, Note.Duration.blanca),
				

				// --------------------------------------------------//
				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.redonda),
				

				new Note(Note.Frequency.G2, Note.Duration.blanca),
				
				new Note(Note.Frequency.C2, Note.Duration.blanca),

		};

		
		// int h = 0;
		/*
		 * for (Instrument instrument : instruments) {
		 * System.out.println(instrument.getName() + h);
		 * 
		 * }
		 */

		ExecutorService executor = Executors.newCachedThreadPool();
		MidiPlayer.setInstrument(instruments[2], 0);
		MidiPlayer.setInstrument(instruments[2], 1);
		Conductor c = new Conductor(125);
		
		executor.submit(new Performer(notesLead, c, 0));
		executor.submit(new Performer(notesRythm, c, 1));
		
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
