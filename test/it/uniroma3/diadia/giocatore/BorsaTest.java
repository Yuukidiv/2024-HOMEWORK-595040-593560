package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsa;
	private Attrezzo osso = new Attrezzo("osso", 2);
	private Attrezzo lanterna = new Attrezzo("lanterna", 3);
	private Attrezzo scimitarra = new Attrezzo("scimitarra", 10);
	
	@Test
	public void testBorsaVuota() {
		borsa  = new Borsa();
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testAddOggettoInBorsaLeggero() {
		borsa  = new Borsa(10);
		borsa.addAttrezzo(osso);
		assertTrue(this.borsa.addAttrezzo(osso));
	}

	@Test
	public void testAddOggettoInBorsaPesante() {
		borsa  = new Borsa(1);
		borsa.addAttrezzo(osso);
		assertFalse(this.borsa.addAttrezzo(osso));
	}
	
	@Test
	public void testGetOggettoInBorsa() {
		borsa  = new Borsa(10);
		borsa.addAttrezzo(osso);
		assertTrue(this.borsa.getAttrezzo("osso")!=null);
	}
	
	@Test
	public void testGetPesoBorsa() {
		borsa = new Borsa();
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(osso);
		assertTrue(this.borsa.getPeso()==6);
	}
	
	@Test
	public void testRemoveAttrezzo() {
		borsa = new Borsa();
		assertTrue(this.borsa.isEmpty());
		this.borsa.addAttrezzo(osso);
		assertFalse(this.borsa.isEmpty());
		this.borsa.removeAttrezzo("osso");
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testGetBorsaOrdinata() {
		List<Attrezzo> borsaOrdinata = new ArrayList<>();
		borsaOrdinata.add(lanterna);
		borsaOrdinata.add(scimitarra);
		borsaOrdinata.add(osso);
		
		Collections.sort(borsaOrdinata);
		
		assertEquals(this.osso, borsaOrdinata.get(0));
		assertEquals(this.lanterna, borsaOrdinata.get(1));
		assertEquals(this.scimitarra, borsaOrdinata.get(2));
	}
}
