
public class Giocatore {
	public int cfu;
	private Borsa borsa;
	
	Giocatore() {
		borsa = new Borsa();
		
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
