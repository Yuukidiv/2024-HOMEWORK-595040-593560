package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComandoPrendiTest {
	
	private ComandoPrendi comandoPrendi = new ComandoPrendi();
	
	@Test
	public void testSetAttrezzo() {
		this.comandoPrendi.setParametro("osso");
		assertEquals(this.comandoPrendi.getAttrezzo(), "osso");
	}
}
