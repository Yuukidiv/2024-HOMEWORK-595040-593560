package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String attrezzo;
	private Stanza[] stanzeAdiacenti;

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

	public boolean attrezzoNellaStanza() {
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(attrezzi[i].getNome().equals(this.attrezzo)) return true;
		}

		return false;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(this.direzioneBloccata==dir && !this.attrezzoNellaStanza()) {
			this.getDescrizione(); 
			return this;
		}
		Stanza stanza = null;
		String[] direzioni = this.getDirezioni();
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (direzioni[i].equals(dir))
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}

	@Override
	public String getDescrizione() {
		return "Direzione bloccata. Avrai bisogno di "
				+ attrezzo + " per passare!"
				+ " " + this.toString();
	}
}
