package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
	
//	private Labirinto.LabirintoBuilder lab;
//	private String nomeStanzaIniziale = "Atrio";
//	private String nomeStanzaVincente = "Uscita";
//	
//	@Before
//	public void setUp() {
//		
//		this.lab = new Labirinto.LabirintoBuilder();
//	}
//	
//	@Test
//	public void testGetLabirinto() {
//		assertNotNull(lab.getLabirinto());
//	}
//	@Test
//    public void testAddAttrezzoConStanza() {
//        lab.addStanza("stanzaConAttrezzo");
//        lab.addAttrezzo("Masamune", 20);
//        assertTrue(lab.getStanzaLat().get("stanzaConAttrezzo").hasAttrezzo("Masamune"));
//    }
//
//	@Test
//	public void testMonolocale() {
//		Labirinto monolocale = lab
//				.addStanzaIniziale(nomeStanzaIniziale)
//				.addStanzaVincente(nomeStanzaIniziale)
//				.getLabirinto();
//	assertEquals(nomeStanzaIniziale,monolocale.getStanzaCorrente().getNome());
//	assertEquals(nomeStanzaIniziale,monolocale.getStanzaVincente().getNome());
//	}
//	
//
//	@Test
//	public void testMonolocaleConAttrezzo() {
//		Labirinto monolocale = lab
//				.addStanzaIniziale(nomeStanzaIniziale).addAttrezzo("spada",1)
//				.addStanzaVincente(nomeStanzaIniziale).addAttrezzo("spadina", 3)
//				.getLabirinto();
//		assertEquals(nomeStanzaIniziale,monolocale.getStanzaCorrente().getNome());
//		assertEquals(nomeStanzaIniziale,monolocale.getStanzaVincente().getNome());
//		assertEquals("spada",monolocale.getStanzaCorrente().getAttrezzo("spada").getNome());
//		assertEquals("spadina",monolocale.getStanzaVincente().getAttrezzo("spadina").getNome());
//	}
	
	Labirinto.LabirintoBuilder labirinto;
	
	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = new Labirinto.LabirintoBuilder("labirinto.txt");
	}
	

	@Test
	public void testAddStanza() {
		labirinto.addStanza("N10");
		Stanza N10 = new Stanza("N10");
		assertEquals(N10.getNome(), labirinto.getNome2stanza().get("N10").getNome());
	}
	

	@Test
	public void testAddAttrezzo(){
		Attrezzo attrezzo = new Attrezzo("osso", 2);
		labirinto.addStanzaIniziale("stanzetta").addAttrezzo(attrezzo.getNome(), attrezzo.getPeso());
		assertEquals(attrezzo.getNome(), labirinto.getLabirinto().getStanzaCorrente().getAttrezzo("osso").getNome());
		assertEquals(attrezzo.getPeso(), labirinto.getLabirinto().getStanzaCorrente().getAttrezzo("osso").getPeso());		
	}
	

	@Test
    public void testHasAttrezzo() {
        labirinto.addStanza("N11");
        labirinto.addAttrezzo("osso", 2);
        assertTrue(labirinto.getNome2stanza().get("N11").hasAttrezzo("osso"));
    }

}
