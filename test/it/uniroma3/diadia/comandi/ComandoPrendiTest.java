package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;
	private IO io;
	Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		 labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 10);
		new Attrezzo("incudine", 5);
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}

	
	public boolean attrezzoPresente(String attrezzo) {
		if(partita.getStanzaCorrente().getAttrezzo(attrezzo)==null)
			return false;
		return true;
		}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}

	
}
