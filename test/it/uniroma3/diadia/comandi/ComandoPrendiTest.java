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
	private Stanza a1;
	private Attrezzo att;
	private Comando prendi;
	private Partita p;
	private Labirinto lab;
	// test implementabili da fare anche altri
	@Before
	public void setUp() {
		att = new Attrezzo("cuffie", 2);
		lab = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("cartaIgienica", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(lab);

	}
	
	@Test
	public void testSetAttrezzo() {
		this.comandoPrendi.setParametro("osso");
		assertEquals(this.comandoPrendi.getAttrezzo(), "osso");
	}
}

