package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComandoPosaTest {


	private ComandoPosa comandoPosa = new ComandoPosa();
	
	@Test
	public void testSetAttrezzo() {
		this.comandoPosa.setParametro("osso");
		assertEquals(this.comandoPosa.getAttrezzo(), "osso");
	}
}
