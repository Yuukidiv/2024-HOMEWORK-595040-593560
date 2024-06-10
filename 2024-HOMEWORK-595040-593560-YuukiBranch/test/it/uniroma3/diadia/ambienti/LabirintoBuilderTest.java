package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
	
	private Labirinto.LabirintoBuilder lab;
	private String nomeStanzaIniziale = "Atrio";
	private String nomeStanzaVincente = "Uscita";
	
	@Before
	public void setUp() {
		
		this.lab = new Labirinto.LabirintoBuilder();
	}
	
	@Test
	public void testGetLabirinto() {
		assertNotNull(lab.getLabirinto());
	}
	@Test
    public void testAddAttrezzoConStanza() {
        lab.addStanza("stanzaConAttrezzo");
        lab.addAttrezzo("Masamune", 20);
        assertTrue(lab.getStanzaLat().get("stanzaConAttrezzo").hasAttrezzo("Masamune"));
    }

	@Test
	public void testMonolocale() {
		Labirinto monolocale = lab
				.addStanzaIniziale(nomeStanzaIniziale)
				.addStanzaVincente(nomeStanzaIniziale)
				.getLabirinto();
	assertEquals(nomeStanzaIniziale,monolocale.getStanzaCorrente().getNome());
	assertEquals(nomeStanzaIniziale,monolocale.getStanzaVincente().getNome());
	}
	

	@Test
	public void testMonolocaleConAttrezzo() {
		Labirinto monolocale = lab
				.addStanzaIniziale(nomeStanzaIniziale).addAttrezzo("spada",1)
				.addStanzaVincente(nomeStanzaIniziale).addAttrezzo("spadina", 3)
				.getLabirinto();
		assertEquals(nomeStanzaIniziale,monolocale.getStanzaCorrente().getNome());
		assertEquals(nomeStanzaIniziale,monolocale.getStanzaVincente().getNome());
		assertEquals("spada",monolocale.getStanzaCorrente().getAttrezzo("spada").getNome());
		assertEquals("spadina",monolocale.getStanzaVincente().getAttrezzo("spadina").getNome());
	}
	
	

}
