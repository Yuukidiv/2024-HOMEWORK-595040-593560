
public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;


	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		// if inserito da me ma da cancellare anche se serve na cifra
		if(attrezzo== null) {
			System.out.println("Attrezzo non valido!");
			return false;
		}
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		System.out.print("Ho preso l'oggetto dalla stanza, ora sta nella borsa!");
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo == null) System.out.print("Attrezzo non valido!");
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		// a ritorna l'attrezzo rimosso ma proprio l'attrezzo non la stringa
		Attrezzo a = null;
		// --->  TODO (implementare questo metodo) <--
		if(nomeAttrezzo != null) {
			// check se ci sta nell'array
			for(int i = 0; i<numeroAttrezzi; i++) {
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					// do ad a il l'attrezzo rimosso ma in questo modo passo null in teoria RICONTROLLARE
					a = this.attrezzi[i];
					this.attrezzi[i] = null;
					this.numeroAttrezzi = this.numeroAttrezzi - 1;
				}
			}
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


}