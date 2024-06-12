package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza = new Stanza("Atrio");
	private Attrezzo osso = new Attrezzo("osso", 1);
	
	@Test
	public void testGetNomeStanza() {
		assertEquals(this.stanza.getNome(), "Atrio");
	}
	
	@Test
	public void testAddHasGetAttrezzo() {
		this.stanza.addAttrezzo(this.osso);
		assertTrue(this.stanza.hasAttrezzo("osso"));
		assertEquals(this.stanza.getAttrezzo("osso"), this.osso);
	}
	
	@Test
	public void testRemoveAttrezzo() {
		this.stanza.addAttrezzo(osso);
		assertTrue(this.stanza.hasAttrezzo("osso"));
		this.stanza.removeAttrezzo(osso);
		assertFalse(this.stanza.hasAttrezzo("osso"));
	}
	

}
