package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica s1;
	private Attrezzo k;
	private Attrezzo m;
	private Attrezzo b;
	
	@Before
	public void setUp() throws Exception {
		s1 = new StanzaMagica("stanza1");
		k = new Attrezzo("katana", 10);
		m = new Attrezzo("martello", 15);
		b = new Attrezzo("bacchetta", 8);
	}


	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(m));

	}
	
	@Test
	public void testModificaAttrezzo() {
		assertTrue(s1.addAttrezzo(k));
		assertTrue(s1.addAttrezzo(b));
		assertTrue(s1.addAttrezzo(m));
		}
}
