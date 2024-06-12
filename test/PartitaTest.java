
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Labirinto labirinto;
	Partita p;
	Stanza s;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("N11", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLabirinto().setStanzaCorrente(s);
		assertEquals(s, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse(p.isFinita());
	}
	
}
