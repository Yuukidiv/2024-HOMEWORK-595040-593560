package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	private final static String NOME = "Prendi";
	private String attrezzo;

	@Override
	public void esegui(Partita partita) {
		Attrezzo att = partita.getStanzaCorrente().getAttrezzo(attrezzo);

		if(att==null) {
			this.getIo().mostraMessaggio("Attrezzo non presente nella stanza!");
		} 
		else {
			if(partita.getGiocatore().getBorsa().getPeso()<=att.getPeso()) {
				partita.getGiocatore().getBorsa().addAttrezzo(att);
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(att);
				this.getIo().mostraMessaggio(att.getNome() + " è stato aggiunto alla borsa!");
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
