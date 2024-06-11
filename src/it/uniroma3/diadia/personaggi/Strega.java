package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/*
 Strega: se interagiamo con una strega questa ci 
trasferisce in una stanza tra quelle adiacenti. 
Siccome è permalosa:
• se non l’abbiamo ancora salutata, ci «trasferisce» nella 
stanza adiacente che contiene meno attrezzi
• altrimenti in quella che contiene più attrezzi
 */
public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_STREGA_NON_SALUTATA = "Sono molto permalosa, non si saluta? Vattene un pò!";
	private static final String MESSAGGIO_STREGA_SALUTATA = "Sono permalosa, ma salutandomi ecco che te ne vai in una stanza zeppa di attrezzini!";
	private Attrezzo attrezzo; 
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();
		Stanza maxAtrezzi = stanzeAdiacenti.get(0);
		Stanza minAtrezzi = stanzeAdiacenti.get(0);
		
		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAtrezzi.getNumeroAttrezzi())
					maxAtrezzi = s;
				if(s.getNumeroAttrezzi() < minAtrezzi.getNumeroAttrezzi())
					minAtrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.setStanzaCorrente(maxAtrezzi);
			msg = MESSAGGIO_STREGA_NON_SALUTATA;
		} else {
			partita.setStanzaCorrente(minAtrezzi);
			msg = MESSAGGIO_STREGA_SALUTATA;
		}

		return msg;
	}
	

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "Grazie mille! AHAHAHAH";
	}
	
}
