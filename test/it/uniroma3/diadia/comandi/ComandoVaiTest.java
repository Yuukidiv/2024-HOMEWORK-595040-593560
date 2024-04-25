package it.uniroma3.diadia.comandi;


import static org.junit.Assert.*;

import org.junit.Test;

public class ComandoVaiTest {
	
	private ComandoVai comadandoVai = new ComandoVai();

	@Test
	public void testSetAndGetDirezione() {
		this.comadandoVai.setParametro("nord");
		assertEquals("nord", this.comadandoVai.getDirezione());
	}

}
