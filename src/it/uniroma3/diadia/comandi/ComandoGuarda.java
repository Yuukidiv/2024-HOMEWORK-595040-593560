package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{

	private final static String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println("Hai: "+partita.getGiocatore().getCfu()+ "CFU!");
		System.out.println(partita.getGiocatore().getBorsa().toString());
		
		//Implementare stato della partita
	}
	
	@Override 
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
	
}
