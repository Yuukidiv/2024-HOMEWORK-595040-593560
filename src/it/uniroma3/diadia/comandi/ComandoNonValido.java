package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{
	
	private final static String NOME = "Comando sconosciuto";
	
	@Override 
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando sconosciuto");
	}
	
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
}
