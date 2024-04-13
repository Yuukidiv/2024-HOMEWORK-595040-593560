import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	private Giocatore giocatore;
	private Giocatore giocatore2;

	
	@Before
	public void setUp() {
		this.giocatore= new Giocatore();
		this.giocatore2 = new Giocatore();
		this.giocatore2.setCfu(100);

	}
	
	@Test
	public void testCfuInizialiGiusti() {
		assertEquals(20, giocatore.getCfu());
	}

	@Test
	public void testCfuCambiati() {
		assertEquals(100, giocatore2.getCfu());
	}

	@Test
	public void testBorsaPresente() {
		assertNotNull( giocatore.getBorsa());
	}

}
