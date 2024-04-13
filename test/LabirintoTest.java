import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class LabirintoTest {

	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		
		this.labirinto = new Labirinto();
		
	}
	
	@Test
	public void testLabirintoNonVuoto() {
		assertNotNull(labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testStanzaVincenteGiusta() {
		assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaCorrenteGiusta() {
		assertEquals("Atrio",labirinto.getStanzaCorrente().getNome());
	}
}
