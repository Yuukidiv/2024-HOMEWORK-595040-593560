package it.uniroma3.diadia.comandi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	private ComandoVai comadandoVai = new ComandoVai();
	private Stanza a1;
	private Stanza a2;
	private Comando vai;
	private Partita p;
	private Labirinto lab;
	
	@Before
	public void setUp() {
		a1 = new Stanza("Atrio");
		a2 = new Stanza("Bagno");
		vai = new ComandoVai();
		lab = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(lab);

	}

	@Test
	public void testSetAndGetDirezione() {
		this.comadandoVai.setParametro("nord");
		assertEquals("nord", this.comadandoVai.getDirezione());
	}
	@Test
	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(a1);
		a1.impostaStanzaAdiacente("sud", a2);
		vai.esegui(p);
		assertNotEquals(a2, p.getStanzaCorrente());
	}

}
