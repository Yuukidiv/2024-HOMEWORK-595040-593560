
public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	public int cfu;
	private Borsa borsa;
	
	Giocatore() {
		borsa = new Borsa();
		this.cfu= CFU_INIZIALI;
		
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	public int getCfu() {
		return this.cfu;
	}
}
