
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partitina;
	private Partita partita;
	private Partita partitona;
	private Stanza stanza;
	 

	@Before
	public void setUp() {
		this.partitina = new Partita();
		this.partita = new Partita();
		partita.getGiocatore().setCfu(0);
		this.partitona = new Partita();
		this.stanza = new Stanza("Biblioteca");
		this.partitona.getLabirinto().setStanzaCorrente(stanza);
	    this.partitona.getLabirinto().setStanzaVincente(stanza);
		
	}
 	

	@Test
	public void testPartitaFinitaPerCfu() {
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testPartitaFinitaPerStanzaCoincidenti() {
		assertTrue(partitona.isFinita());
	}
	

	@Test
	public void testPartitaFinita() {
		assertFalse(partitina.isFinita());
	}
}
