package it.uniroma3.diadia.ambienti;

import java.util.List;
import java.util.Map;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String attrezzo;
	private List<Stanza> stanzeAdiacenti;

	public StanzaBloccata(String nome, Direzione direzione, String attrezzo) {
		super(nome);
		this.setAttrezzo(attrezzo);
		this.setDirezioneBloccata(direzione);
		this.stanzeAdiacenti = this.getStanzeAdiacenti();
	}

	public Direzione getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(Direzione direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getAttrezzo() {
		return attrezzo;
	}

	public void setAttrezzo(String attrezzo) {
		this.attrezzo = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
		if(this.direzioneBloccata==dir && !this.hasAttrezzo(attrezzo)) {
			this.getDescrizione(); 
			return this;
		}
		return super.getStanzaAdiacente(dir);
	}

	@Override
	public String getDescrizione() {
		return "Direzione bloccata. Avrai bisogno di "
				+ attrezzo + " per passare!"
				+ " " + this.toString();
	}
}
