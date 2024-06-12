package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	private final static String NOME = "Posa";
	private String attrezzo;

	@Override
	public void esegui(Partita partita) {
		Attrezzo att = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
		if (att!=null) {	
			this.getIo().mostraMessaggio(att.getNome() + " posato!");
			partita.getStanzaCorrente().addAttrezzo(att);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
		}
		else
			this.getIo().mostraMessaggio("Attrezzo non presente in borsa!");
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
