package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import stock.Menu;
import stock.Transaction;

public class TestMenu{
	protected Menu m;
	protected Transaction t;
	
	@Before
	public void setup() {		
		m = new Menu();
		t = new Transaction();
	}
	
	@Test
	public void testDialog(){
		assertEquals(m.dialog("-help"), 0);
		assertEquals(m.dialog("-quit"), -1);
		assertEquals(m.dialog("-hist"), 0);
		assertEquals(m.dialog("else"), 0); // Test d'une fausse transaction
		assertEquals(m.dialog("GET set"), 0);
	}

}