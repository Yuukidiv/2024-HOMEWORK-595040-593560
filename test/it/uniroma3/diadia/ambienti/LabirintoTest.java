package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

public class LabirintoTest {
	
	Labirinto l;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		l = Labirinto.newBuilder("labirinto.txt").getLabirinto();
	}
	
	
	@Test
	public void testStanzaVincente() {
		assertEquals("N11",l.getStanzaVincente().getNome());
	}
	
	@Test
	public void testStanzaIniziale() {
		assertEquals("biblioteca",l.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testStanzaCorrente() {
		Stanza N10 = new Stanza("N10");
		l.setStanzaCorrente(N10);
		assertEquals("N10", l.getStanzaCorrente().getNome());
	}
}
