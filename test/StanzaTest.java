
import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanzina;
	private Stanza stanzona;
	private Attrezzo attrezzo;

	
	
	@Before
	public void setUp() {
		this.stanzina = new Stanza("vuota");
		this.stanzona = new Stanza("nonVuota");
		this.attrezzo = new Attrezzo("spada", 10);
		stanzona.addAttrezzo(attrezzo);
	}
	
	@Test
	public void testStanzaSenzaAttrezzi() {	
		assertNull(stanzina.getAttrezzo("NonCiSonoeheh"));
	}
	
	@Test
	public void testStanzaNonVuota() {	
		assertNotNull(stanzona.getAttrezzo("spada"));
	}
	
	@Test
	public void testStanzaNonVuotaAttrezzoAssente() {	
		assertNull(stanzona.getAttrezzo("martello"));
	}
	

}
