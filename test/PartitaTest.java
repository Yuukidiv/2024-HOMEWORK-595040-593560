

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class PartitaTest {

	private Partita partitina;
	private Labirinto lab;
	 

	@Before
	public void setUp() {
		this.partitina = new Partita(lab);
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
