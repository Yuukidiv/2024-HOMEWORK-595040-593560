package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{

	private IO io = new IOConsole();
	private String parametro;

	abstract public void esegui(Partita partita);

	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro  = parametro;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

	public IO getIo() {
		return io;
	}
}

