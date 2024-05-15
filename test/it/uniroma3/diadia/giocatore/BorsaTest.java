package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class BorsaTest {

	private Borsa borsa;
	private Attrezzo osso = new Attrezzo("osso", 2);
	private Attrezzo lanterna = new Attrezzo("lanterna", 3);
	private Attrezzo scimitarra = new Attrezzo("scimitarra", 10);
	private Attrezzo oca = new Attrezzo("oca", 2);
	
	
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
	public void testGetBorsaOrdinataPerPeso() {
		List<Attrezzo> listaOrdinataPerPeso = new ArrayList<Attrezzo>();
		
		listaOrdinataPerPeso.add(lanterna);
		listaOrdinataPerPeso.add(scimitarra);
		listaOrdinataPerPeso.add(osso);
		
		Collections.sort(listaOrdinataPerPeso);
		
		assertEquals(this.osso, listaOrdinataPerPeso.get(0));
		assertEquals(this.lanterna, listaOrdinataPerPeso.get(1));
		assertEquals(this.scimitarra, listaOrdinataPerPeso.get(2));
	}
	
	@Test 
	public void testGetBorsaOrdinataPerNome() {
		ComparatoreAttrezziPerNome comp = new ComparatoreAttrezziPerNome();
		Set<Attrezzo> setOrdinatoPerNome = new TreeSet<Attrezzo>(comp);
		assertTrue(setOrdinatoPerNome.add(this.scimitarra));
		assertTrue(setOrdinatoPerNome.add(this.lanterna));
		assertTrue(setOrdinatoPerNome.add(this.osso));
		
		Iterator<Attrezzo> iteratore = setOrdinatoPerNome.iterator();
		assertEquals(this.lanterna, iteratore.next());
		assertEquals(this.osso, iteratore.next());
		assertEquals(this.scimitarra, iteratore.next());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		ComparatoreAttrezziPerPeso comp = new ComparatoreAttrezziPerPeso();
		Set<Attrezzo> setOrdinatoPerNome = new TreeSet<Attrezzo>(comp);
		assertTrue(setOrdinatoPerNome.add(this.oca));
		assertTrue(setOrdinatoPerNome.add(this.lanterna));
		assertTrue(setOrdinatoPerNome.add(this.osso));
		
		Iterator<Attrezzo> iteratore = setOrdinatoPerNome.iterator();
		assertEquals(this.oca, iteratore.next());
		assertEquals(this.osso, iteratore.next());
		assertEquals(this.lanterna, iteratore.next());
	}
}
