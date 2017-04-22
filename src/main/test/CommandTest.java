package test;

import static org.junit.Assert.*;

import java.stock.Commandes;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandTest {

	@Before
	@Test
	public void setUp() throws Exception {
	}

	@After
	@Test
	public void tearDown() throws Exception {
	}

	@Test
	public void testGET(){
		Commandes cmd = new Commandes ();
		cmd.SET("Book", "SLPC");
		assertEquals("Test GET ","SLPC",cmd.GET("Book"));
	}
	
	@Test
	public void testSET(){
		Commandes cmd = new Commandes ();
		String result = cmd.SET("Book", "Romeo and Juliet");
		assertEquals("Test SET ","OK",result);
	}
	
	@Test
	public void testDECR(){
		Commandes cmd = new Commandes ();
		cmd.SET("Number", "124");
		cmd.INCR("Number");
		assertEquals("Test DECR ", "125", cmd.GET("Number"));
	}
	
	@Test
	public void testINCR(){
		Commandes cmd = new Commandes ();
		cmd.SET("Number", "27");
		cmd.INCR("Number");
		assertEquals("Test DECR ", "26", cmd.GET("Number"));
	}
	
	@Test
	public void testDEL(){
		Commandes cmd = new Commandes ();
		cmd.SET("Number", "124");
		cmd.DEL("Number");
		assertEquals("Test DECR ", "the given key does not exists", cmd.GET("Number"));
	}
	
	@Test
	public void testLPush(){
		Commandes cmd = new Commandes ();
		//cmd.LPUSH("Number", "124");
		//cmd.LPUSH("Number", "125");
		assertEquals("Test LPush ", "125 124", cmd.GET("Number"));
	}
	
	@Test
	public void testRPush(){
		Commandes cmd = new Commandes ();
		//cmd.RPUSH("Number", "124");
		//cmd.RPUSH("Number", "125");
		assertEquals("Test LPush ", "124 125", cmd.GET("Number"));
	}

}
