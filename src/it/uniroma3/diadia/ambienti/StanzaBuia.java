package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	final static private String FRASE_DEFAULT = "Qui c'è buio pesto";
	
	private String attrezzo;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.setAttrezzo(attrezzo);
	}
	
	public String getAttrezzo() {
		return attrezzo;
	}
	
	public void setAttrezzo(String attrezzo) {
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzo))
			return FRASE_DEFAULT;
		return this.toString();
	}

}
