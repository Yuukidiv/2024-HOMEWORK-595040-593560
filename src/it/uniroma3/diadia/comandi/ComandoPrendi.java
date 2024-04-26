package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String attrezzo;
	
	@Override 
	public void esegui(Partita partita) {
		Attrezzo att = partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(att);
		partita.getStanzaCorrente().removeAttrezzo(att);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}
	
	public String getAttrezzo() {
		return this.attrezzo;
	}
}
