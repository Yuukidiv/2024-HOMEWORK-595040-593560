package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaBuiaTest {
	
	private String nome = "Atrio";
	private String attrezzo = "lanterna";
	private StanzaBuia stanzaBuia = new StanzaBuia(nome, attrezzo);
	
	@Test
	public void testGetAttrezzo() {
		assertEquals(attrezzo, this.stanzaBuia.getAttrezzo());
	}
	
	@Test
	public void testGetDescrizione() {
		assertEquals("Qui c'è buio pesto", this.stanzaBuia.getDescrizione());
	}
}
