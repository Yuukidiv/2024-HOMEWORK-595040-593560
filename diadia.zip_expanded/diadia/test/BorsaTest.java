import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	private Borsa borsina;
	private Borsa borsetta;
	private Attrezzo scimitarra;
	private Attrezzo martello;
	

	@Before
	public void setUp() {
		this.borsina = new Borsa();
		this.borsetta = new Borsa();
		this.scimitarra = new Attrezzo("Scimitarra", 10);	// peso irrealistico vabbe
		this.borsetta.addAttrezzo(scimitarra);
		this.martello = new Attrezzo("Martello", 15);
		
	}
	@Test
	public void testBorsaVuota() {
		assertTrue(this.borsina.isEmpty());
	}

	@Test
	public void testBorsaConAttrezzoPresente() {
		assertNotNull(this.borsetta.getAttrezzo("Scimitarra"));
	}
	
	@Test
	public void testBorsaConAttrezzoMaNonPresente() {
		assertNotEquals(this.borsetta.getAttrezzo("Scimitarra").getNome(), this.martello.getNome());
	}
	
}
