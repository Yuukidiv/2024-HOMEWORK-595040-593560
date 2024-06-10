package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;

public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione);
}
