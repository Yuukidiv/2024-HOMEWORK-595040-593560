package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	private Stanza stanzaCorrente;
	
	public Partita(){
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		this.finita = false;
		
		this.stanzaCorrente = this.labirinto.getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public boolean giocatoreIsVivo() { return true;}
	

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
}
