package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

	private List<String> let;
	private int ilette;

	public List<String> getregistroMessaggiScritti() {
		return registroMessaggiScritti;
	}

	public void setregistroMessaggiScritti(List<String> registroMessaggiScritti) {
		this.registroMessaggiScritti = registroMessaggiScritti;
	}

	private List<String> registroMessaggiScritti;
	private int indiceregistroMessaggiScritti;
	private int indiceMessaggiMostrati;

	public IOSimulator(List<String> righeDaLeggere) {
		this.let = righeDaLeggere;
		this.ilette = 0;
		this.indiceMessaggiMostrati = 0;
		this.registroMessaggiScritti = new ArrayList<String>();
	}

	@Override
	public String leggiRiga() {
		String riga = null;

		riga = this.let.get(ilette);
		this.ilette++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.registroMessaggiScritti.add(this.indiceregistroMessaggiScritti, msg);
		this.indiceregistroMessaggiScritti++;
	}

	public String nextMessaggio() {
		String next = this.registroMessaggiScritti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceregistroMessaggiScritti;
	}

}
