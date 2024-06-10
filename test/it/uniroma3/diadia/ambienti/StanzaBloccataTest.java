package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	Direzione nord;

	private StanzaBloccata stanzaBloccata = new StanzaBloccata("atrio", nord, "piedediporco");
	private Stanza biblioteca = new Stanza("biblioteca");
	private Attrezzo osso = new Attrezzo("osso",1);
	private Attrezzo piedediporco = new Attrezzo("piedediporco",1);
	
	@Test
	public void testGetDirezioneBloccata() {
		assertEquals(this.stanzaBloccata.getDirezioneBloccata(), nord);
	}

	@Test
	public void testStanzaAdiacenteSenzaAttrezzo() {
		this.stanzaBloccata.impostaStanzaAdiacente(nord, this.biblioteca);
		this.stanzaBloccata.addAttrezzo(this.osso);
		assertEquals(this.stanzaBloccata.getStanzaAdiacente(nord), this.stanzaBloccata);
	}
	
	@Test
	public void testStanzaAdiacenteConAttrezzo() {
		this.stanzaBloccata.impostaStanzaAdiacente(nord, this.biblioteca);
		this.stanzaBloccata.addAttrezzo(this.piedediporco);
		assertEquals(this.stanzaBloccata.getStanzaAdiacente(nord), this.biblioteca);
	}
}
