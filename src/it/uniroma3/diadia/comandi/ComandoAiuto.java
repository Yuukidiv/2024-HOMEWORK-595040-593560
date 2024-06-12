package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	private final static String NOME = "aiuto";
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta", "regala", "interagisci"};
	
	@Override 
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIo().mostraMessaggio(elencoComandi[i]+" ");
		this.getIo().mostraMessaggio("");
	}
	
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
}
