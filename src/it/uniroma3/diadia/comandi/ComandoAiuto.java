package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	private final static String NOME = "aiuto";
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	
	@Override 
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.println(elencoComandi[i]+" ");
		System.out.println("");
	}
	
	@Override
	public void setParametro(String parametro) {}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
}
