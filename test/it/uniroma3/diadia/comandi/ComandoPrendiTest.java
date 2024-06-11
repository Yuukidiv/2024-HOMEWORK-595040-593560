package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private ComandoPrendi comandoPrendi = new ComandoPrendi();
	
	
	@Test
	public void testSetAttrezzo() {
		this.comandoPrendi.setParametro("osso");
		assertEquals(this.comandoPrendi.getAttrezzo(), "osso");
	}
}

