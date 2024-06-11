package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

// cane morde perdo cfu se ci interagisco
public class Cane extends AbstractPersonaggio {

	private static final String MESSAGGIO_CANE_ARRABBIATO = "WOOF, WOOF. Ti sto mordendo grrrr, hai perso un cfu";
	private static final String MESSAGGIO_CANE_DOCILE = "WOOF, WOOF. Grazie! Ecco a te!";
	
	private static final String NOME_ATTREZZO_PREFERITO = "osso";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE_ARRABBIATO;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

		StringBuilder risposta = new StringBuilder("");
		
		if(attrezzo==null) {
			risposta.append(this.agisci(partita));
			return risposta.toString();
		}

		if(attrezzo.getNome().equals(NOME_ATTREZZO_PREFERITO)) {
			Attrezzo attrezzoRicevuto = new Attrezzo("Moneta", 1);
			partita.getStanzaCorrente().addAttrezzo(attrezzoRicevuto);
			risposta.append(MESSAGGIO_CANE_DOCILE);
			risposta.append("Hai ricevuto in cambio: " + attrezzoRicevuto.getNome());
		} 
		else {
			risposta.append(MESSAGGIO_CANE_ARRABBIATO);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}

		return risposta.toString();
	}
}
