

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;

public class PartitaTest {

	private Partita partitina;
	 

	@Before
	public void setUp() {
		this.partitina = new Partita();
	}
 	
	@Test
	public void testStanzaVincente() {
		assertEquals("Biblioteca", partitina.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testStanzaIniziale() {
		assertEquals("Atrio", partitina.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testPartitaFinita() {
		assertFalse(partitina.isFinita());
	}
}
