package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{
	private final static String NOME = "aiuto";
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
}
