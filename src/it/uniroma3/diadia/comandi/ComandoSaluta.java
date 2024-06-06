package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	private IO io;
	private final static String NOME = "Saluta";
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			io.mostraMessaggio(personaggio.saluta());
		} else
			io.mostraMessaggio("In questa stanza non ci sta nessuno, sto impazzendo!");
	}
	

}
