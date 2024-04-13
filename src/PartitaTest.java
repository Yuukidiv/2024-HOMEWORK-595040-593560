import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	private Partita partitina;
	 

	@Before
	public void setUp() {
		this.partitina = new Partita();
	}
 	
	// questi due metodi sopra forse da cambiare da mettere dentro labirinto maye
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
