package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
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
			// check se c'è sta nella lista
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
		Collections.sort(listaOrdinata);
		System.out.println(listaOrdinata);
		return listaOrdinata;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> setOrdinato = new TreeSet<Attrezzo>();
		
		return setOrdinato;
	}

}