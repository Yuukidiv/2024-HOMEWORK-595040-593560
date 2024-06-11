package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 20;
	private List<Attrezzo> attrezzi;
	private int pesoMax;


	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.attrezzi = new ArrayList<Attrezzo>();
		this.pesoMax = pesoMax;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null) {
			return false;
		}
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		this.attrezzi.add(attrezzo);
		return true;
	} 

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null; 	
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			Attrezzo a = iteratore.next();
			peso += a.getPeso();
		}
		return peso;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();

		if(nomeAttrezzo != null) {
			while(iteratore.hasNext()) {
				a = iteratore.next();
				if(a.getNome().equals(nomeAttrezzo)) {
					iteratore.remove();
					return a;
				}
			}
		}
		return null;
	}

	/*Borsa vuota*/
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/**
	 * Restituisce la descrizione della borsa.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.attrezzi.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");

			Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
			while(iteratore.hasNext()) {
				Attrezzo a = iteratore.next();
				s.append(a.toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaOrdinata = new ArrayList<Attrezzo>();
		listaOrdinata.addAll(this.attrezzi);
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		// ordino con nuovo modo, passo prima per comparator e vedo se sono uguali sennò passo a compareTo
		listaOrdinata.sort(cmp);
		System.out.println(listaOrdinata);
		return listaOrdinata;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> sortedSetOrdinatoPerPeso = new TreeSet<Attrezzo>(cmp);
		sortedSetOrdinatoPerPeso.addAll(this.attrezzi);
		return sortedSetOrdinatoPerPeso; 
	}
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> setOrdinatoPerNome = new TreeSet<Attrezzo>();
		setOrdinatoPerNome.addAll(this.attrezzi);
		return setOrdinatoPerNome;
	}

	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> amap = new TreeMap<>();
		for(Attrezzo att : this.attrezzi){
			if(amap.containsKey(att.getPeso())) {
				amap.get(att.getPeso()).add(att);
			}
			else {
				Set<Attrezzo>  hash=new HashSet<Attrezzo>();
				hash.add(att);
				amap.put(att.getPeso(), hash);
			}
		}
		return amap;
	}

}