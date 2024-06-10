package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoNonValido;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	private IO io;
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}
	
	 @Override
	public Comando costruisciComando(String istruzione) {
	 Scanner scannerDiParole = new Scanner(istruzione);
	 String nomeComando = null; 
	 String parametro = null;
	 Comando comando = null;
	 
	 if (scannerDiParole.hasNext())
	 nomeComando = scannerDiParole.next();//prima parola: nome del comando
	 if (scannerDiParole.hasNext())
	 parametro = scannerDiParole.next();//seconda parola: eventuale parametro
	 try {
	 String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
	 nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
	 nomeClasse += nomeComando.substring(1);
	 comando = (Comando)Class.forName(nomeClasse).newInstance();
	 comando.setParametro(parametro);
	 } catch (Exception e) { 
	 comando = new ComandoNonValido();
	 this.io.mostraMessaggio("Comando inesistente");
	 }
	 return comando;
	} 
	}


