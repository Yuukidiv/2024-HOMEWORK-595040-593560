 package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends  AbstractComando{
	private final static String NOME = "Vai";
	private Direzione direzione;

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null; 
		
		if(this.getParametro()!=null)
			this.direzione = Direzione.valueOf(this.getParametro());
		
		if(direzione == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;		
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza==null) {
			System.out.println("Direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
}
