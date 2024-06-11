package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	private final static String NOME = "Prendi";
	private String attrezzo;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.getParametro());
		if(a==null) {
			this.getIo().mostraMessaggio("Attrezzo non presente nella stanza!");
		} 
		else {
			if(partita.getGiocatore().getBorsa().getPeso()>=a.getPeso()) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			} 
			else
				this.getIo().mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
			}
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
