package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza stanza;
	// creo mappa per inserire le stanza in modo dinamico / posso creare labirinti diversi
	private Map<String, Stanza> stanzaLat;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanzaLat = new HashMap<String, Stanza>();
	}
	public Map<String, Stanza> getStanzaLat() {
		return stanzaLat;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	// uso il chaining
	public LabirintoBuilder adder(Stanza stanza) {
		this.stanza = stanza;
		this.stanzaLat.put(stanza.getNome(), stanza);
		return this;	// potrei pure metterlo alla fine della catena anyway
	}
	public LabirintoBuilder addStanza(String stanzaAggiunta) {
		Stanza stanzaAgg = new Stanza(stanzaAggiunta);
		this.adder(stanzaAgg);	// inizio a creare il labirinto
		return this;
	}
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza a1 = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(a1);
		this.adder(a1);
		return this;
	}
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza af = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(af);
		this.adder(af);
		return this;
	}
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a1 = new Attrezzo(attrezzo, peso);
		if(this.stanza==null) return this;
		this.stanza.addAttrezzo(a1);
		return this;
	}
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, Direzione direzione) {
		Stanza cor = this.stanzaLat.get(stanzaCorrente);
		Stanza adia = this.stanzaLat.get(stanzaAdiacente);
		cor.impostaStanzaAdiacente(direzione, adia);
		return this;
	}
	public LabirintoBuilder addStanzaBuia(String nome, String attrez) {
		Stanza stanzaBuia = new StanzaBuia(nome, attrez);
		this.adder(stanzaBuia);
		return this;
	}
	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanzaMagica = new StanzaMagica(nome);
		this.adder(stanzaMagica);
		return this;
	}
	public LabirintoBuilder addStanzaBloccata(String nome, String attrez, String dirBloccata) {
		Stanza stanzaBloccata = new StanzaBloccata(nome, attrez, dirBloccata);
		this.adder(stanzaBloccata);
		return this;
	}
}

