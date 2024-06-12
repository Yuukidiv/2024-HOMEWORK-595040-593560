package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

	private int contatoreAttrezziPosati;

	private int sogliaMagica;

	private static final int SOGLIA_MAGICA_DEFAULT = 1;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}


	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		int pesoX2 = attrezzo.getPeso() * 2;
		attrezzo = new Attrezzo(attrezzo.getNome(),pesoX2);
		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.contatoreAttrezziPosati>this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		this.contatoreAttrezziPosati++;

		return super.addAttrezzo(attrezzo);
	}

}
