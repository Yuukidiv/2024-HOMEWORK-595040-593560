package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	private final static String NOME = "Prendi";
	private String attrezzo;
	
	@Override 
	public void esegui(Partita partita) {
		Attrezzo att = partita.getStanzaCorrente().getAttrezzo(attrezzo);
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

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
}
