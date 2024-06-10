package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class BorsaTest {

	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo scimitarra;
	private Attrezzo katana;
	private Attrezzo excalibur;
	private Attrezzo lightsaber;
	private Borsa borsa2; 

	@Before
	public void setUp() {
		this.osso = new Attrezzo("osso", 2);
		this.lanterna = new Attrezzo("lanterna", 3);
		this.scimitarra = new Attrezzo("scimitarra", 10);
		this.katana = new Attrezzo("katana", 3);
		this.excalibur = new Attrezzo("excalibur", 10);
		this.lightsaber = new Attrezzo("lightsaber",2);
		this.borsa2 = new Borsa();
	}

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
		borsa2.addAttrezzo(scimitarra);
		borsa2.addAttrezzo(osso);
		borsa2.addAttrezzo(lanterna);

		Collections.sort(borsaOrdinata);
		assertEquals(this.osso, borsaOrdinata.get(0));
		assertEquals(this.lanterna, borsaOrdinata.get(1));
		assertEquals(this.scimitarra, borsaOrdinata.get(2));
	}
	@Test 
	public void testSortedBorsaOrdinataPerNomePesoUguale() {
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> borsaSetOrdinata = new TreeSet<>(cmp);
		borsa2.addAttrezzo(katana);
		borsa2.addAttrezzo(lanterna);
		borsaSetOrdinata.add(lanterna);
		borsaSetOrdinata.add(katana);
		// System.out.println(borsaSetOrdinata);
		assertArrayEquals(borsaSetOrdinata.toArray(), borsa2.getContenutoOrdinatoPerPeso().toArray());
	}
	@Test
	public void testSortedBorsaPerPesoDiverso() {
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> borsaOrdinata = new TreeSet<>(cmp);
		borsa2.addAttrezzo(excalibur);
		borsa2.addAttrezzo(katana); 
		borsaOrdinata.add(excalibur);
		borsaOrdinata.add(katana);
		System.out.println(borsaOrdinata);
		assertArrayEquals(borsaOrdinata.toArray(), borsa2.getContenutoOrdinatoPerPeso().toArray());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		borsa2.addAttrezzo(katana);
		borsa2.addAttrezzo(lanterna);
		borsa2.addAttrezzo(osso);
		borsa2.addAttrezzo(lightsaber);
		Map<Integer, Set<Attrezzo>> risultato = borsa2.getContenutoRaggruppatoPerPeso();

		// vedo se ci sono 2 gruppi da 2 pesi diversi
		assertEquals(2, risultato.size());

		// verifico se il gruppo di peso 2 contiene 2 elementi
		Set<Attrezzo> peso2 = risultato.get(2);
		assertNotNull(peso2);
		assertEquals(2, peso2.size());
		assertTrue(peso2.contains(osso));
		assertTrue(peso2.contains(lightsaber));

		// faccio la stessa cosa ma con il gruppo di peso 3
		Set<Attrezzo> peso3 = risultato.get(3);
		assertNotNull(peso3);
		assertEquals(2, peso3.size());
		assertTrue(peso3.contains(katana));
		assertTrue(peso3.contains(lanterna));
	}

}

