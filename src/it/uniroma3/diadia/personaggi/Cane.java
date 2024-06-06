package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

// cane morde perdo cfu se ci interagisco
public class Cane extends AbstractPersonaggio {
	private static final String MESSAGGIO_CANE = "WOOF, WOOF Ti sto mordendo grrrr, hai perso un cfu";
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}
}
