package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class AbstractComandoTest {

	ComandoGuarda cg;
	
	@Before
	public void setUp() throws Exception {
		cg = new ComandoGuarda();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConcreteComandoGetNome() {
		 assertNotEquals("AbstractComando", cg.getNome());
		 assertEquals("guarda", cg.getNome());
	}
	

	@Test
	public void testConcreteComandoGetIO() {
		cg.setIo(new IOConsole());
		 assertNotNull(cg.getIo());
	}
	
	@Test
	public void testConcreteComandoParametro() {
		cg.setParametro("giorgio");
		 assertNotNull(cg.getParametro());
	}


}
