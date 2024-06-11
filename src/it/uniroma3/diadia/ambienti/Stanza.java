package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;

	private String nome;
	protected Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi; // mi servono per la strega
	private Map<Direzione, Stanza> stanzeDirezioni; // sostituisco l'array con una mappa
	private int numStanzeAdiacenti;// sempre per l'implementazione della strega
	private AbstractPersonaggio personaggio;


	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.attrezzi = new HashMap<>();
		this.stanzeDirezioni = new HashMap<>();
		this.numeroAttrezzi = 0;
		this.numStanzeAdiacenti = 0;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean agg = false;
		if(stanzeDirezioni.containsKey(direzione)) {
			// pusho nella mappa se trovo la key una stanza che passo
			this.stanzeDirezioni.put(direzione, stanza);
			agg = true;
		}
		// se invece non ci sta la key verifico se posso inserire la stanza e incremento
		if(agg == false) {
			if (this.numStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeDirezioni.put(direzione,stanza);
				this.numStanzeAdiacenti++;
			}
		}
	}

	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : stanzeDirezioni.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}

	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.stanzeDirezioni = stanzeAdiacenti;
	}

	public int getNumStanzeAdiacenti() {
		return numStanzeAdiacenti;
	}

	public void setNumStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numStanzeAdiacenti = numeroStanzeAdiacenti;
	}
	
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if (this.stanzeDirezioni.containsKey(direzione))
			stanza = this.stanzeDirezioni.get(direzione);
		return stanza;
	}


	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}    

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Map<String,Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */

	// modificato il for delle direzioni per prendere le direzioni possibili con il keyset perchè map
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");

		for (Direzione direzione : this.stanzeDirezioni.keySet()) {
			if (direzione != null) {
				risultato.append(direzione).append(" ");
			}
		}

		// uso attrezziInStanza perchè posso cosi usare append prendendo le values
		risultato.append("\nAttrezzi nella stanza: ");
		Collection<Attrezzo> nomiAttrezzi = this.attrezziInStanza();
		if (nomiAttrezzi != null) {
			risultato.append(nomiAttrezzi.toString()).append(" ");
		}

		return risultato.toString();
	}
	//
	public Collection<Attrezzo> attrezziInStanza() {
		return this.attrezzi.values();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			trovato = true;
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.size() == 0) {
			return false;
		}
		if(attrezzo != null)
			this.attrezzi.remove(attrezzo.getNome());
		return false;
	}

	public Set<Direzione> getDirezioni() {
		return stanzeDirezioni.keySet();
	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}
	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

	// implemento hashcode e equals da ricordarsi di inserire equals
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	
	



} 