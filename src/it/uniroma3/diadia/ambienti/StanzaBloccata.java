package it.uniroma3.diadia.ambienti;

import java.util.List;
import java.util.Map;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String attrezzo;
	private  List<Stanza> stanzeAdiacenti;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzo) {
		super(nome);
		this.setAttrezzo(attrezzo);
		this.setDirezioneBloccata(direzioneBloccata);
		this.stanzeAdiacenti = this.getStanzeAdiacenti();
	}

	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	public String getAttrezzo() {
		return attrezzo;
	}

	public void setAttrezzo(String attrezzo) {
		this.attrezzo = attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(this.direzioneBloccata==dir && !this.hasAttrezzo(attrezzo)) {
			this.getDescrizione(); 
			return this;
		}
		return this.stanzeAdiacenti.get(dir);
	}

	@Override
	public String getDescrizione() {
		return "Direzione bloccata. Avrai bisogno di "
				+ attrezzo + " per passare!"
				+ " " + this.toString();
	}
}
