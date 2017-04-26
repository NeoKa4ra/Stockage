package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stock.Transaction;

public class TestTransaction {
	protected Transaction t;
	
	@Before
	public void setup() {
		t = new Transaction();
	}
	
	@Test
	public void testExecCommandeSET(){
		String input = "SET false";
		assertEquals(t.execCommande(input), -1);
		input = "SET damien 13";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeGET(){
		String input = "GET the false";
		assertEquals(t.execCommande(input), -1);
		String setter = "SET damien 13";
		t.execCommande(setter);
		input = "GET bat";
		assertEquals(t.execCommande(input), -1);
		input = "GET damien";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeDECR(){
		String input = "DECR the false";
		assertEquals(t.execCommande(input), -1);
		String notInt = "SET damien false";
		t.execCommande(notInt);
		input = "DECR damien";
		assertEquals(t.execCommande(input), -1);
		String aInt = "SET damien 13";
		t.execCommande(aInt);
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeINCR(){
		String input = "INCR the false";
		assertEquals(t.execCommande(input), -1);
		String notInt = "SET damien false";
		t.execCommande(notInt);
		input = "INCR damien";
		assertEquals(t.execCommande(input), -1);
		String aInt = "SET damien 13";
		t.execCommande(aInt);
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeDEL(){
		String input = "DEL the false";
		assertEquals(t.execCommande(input), -1);
		String notInt = "SET damien false";
		t.execCommande(notInt);
		input = "DEL damien";
		assertEquals(t.execCommande(input), -1);
		String aInt = "SET damien 13";
		t.execCommande(aInt);
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeLPUSH(){
		String input = "LPUSH false";
		assertEquals(t.execCommande(input), -1);
		input = "LPUSH this is a true thing";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeRPUSH(){
		String input = "RPUSH false";
		assertEquals(t.execCommande(input), -1);
		input = "RPUSH this is a true thing";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeLPOP(){
		String input = "LPOP is false";
		assertEquals(t.execCommande(input), -1);
		String pushing = "LPUSH key is a true thing";
		t.execCommande(pushing);
		input = "LPOP notAKey";
		assertEquals(t.execCommande(input), -1);
		input = "LPOP key";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeRPOP(){
		String input = "RPOP is false";
		assertEquals(t.execCommande(input), -1);
		String pushing = "RPUSH key is a true thing";
		t.execCommande(pushing);
		input = "RPOP notAKey";
		assertEquals(t.execCommande(input), -1);
		input = "RPOP key";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeLLEN(){
		String input = "LLEN is false";
		assertEquals(t.execCommande(input), -1);
		String pushing = "RPUSH key is a true thing";
		t.execCommande(pushing);
		input = "LLEN notAKey";
		assertEquals(t.execCommande(input), -1);
		input = "LLEN key";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeSADD(){
		String input = "SADD false";
		assertEquals(t.execCommande(input), -1);
		input = "SADD key val1 val2 val3";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeSREM(){
		String input = "SREM false";
		assertEquals(t.execCommande(input), -1);
		String adding = "SADD key val1 val2 val3";
		t.execCommande(adding);
		input = "SREM notAKey val1";
		assertEquals(t.execCommande(input), -1);
		input = "SREM key val1";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeSISMEMBER(){
		String input = "SISMEMBER false";
		assertEquals(t.execCommande(input), -1);
		String adding = "SADD key val1 val2 val3";
		t.execCommande(adding);
		input = "SISMEMBER notAKey val1";
		assertEquals(t.execCommande(input), -1);
		input = "SISMEMBER key val10";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeSMEMBERS(){
		String input = "SMEMBERS is false";
		assertEquals(t.execCommande(input), -1);
		String adding = "SADD key val1 val2 val3";
		t.execCommande(adding);
		input = "SMEMBERS notAKey";
		assertEquals(t.execCommande(input), -1);
		input = "SMEMBERS key";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeSUNION(){
		String input = "SUNION false";
		assertEquals(t.execCommande(input), -1);
		String adding = "SADD key val1 val2 val3";
		t.execCommande(adding);
		input = "SUNION key key2";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeHSET(){
		String input = "HSET false";
		assertEquals(t.execCommande(input), -1);
		input = "HSET key field value";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeHGETALL(){
		String input = "HGETALL is false";
		assertEquals(t.execCommande(input), -1);
		String fillIn = "HSET key field value";
		t.execCommande(fillIn);
		input = "HGETALL notAKey";
		assertEquals(t.execCommande(input), -1);
		input = "HGETALL key";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeHGET(){
		String input = "HGET false";
		assertEquals(t.execCommande(input), -1);
		String fillIn = "HSET key field value";
		t.execCommande(fillIn);
		input = "HGET notAKey field";
		assertEquals(t.execCommande(input), -1);
		input = "HGET key notAfield";
		assertEquals(t.execCommande(input), -1);
		input = "HGET key field";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeHINCRBY(){
		String input = "HINCRBY false";
		assertEquals(t.execCommande(input), -1);
		String fillIn = "HSET fakeKey field value";
		t.execCommande(fillIn);
		input = "HINCRBY fakeKey field 15";
		assertEquals(t.execCommande(input), -1);
		input = "HINCRBY fakeKey field value";
		assertEquals(t.execCommande(input), -1);
		fillIn = "HSET key field 15";
		t.execCommande(fillIn);
		input = "HINCRBY key field 15";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeHDECRBY(){
		String input = "HDECRBY false";
		assertEquals(t.execCommande(input), -1);
		String fillIn = "HSET fakeKey field value";
		t.execCommande(fillIn);
		input = "HDECRBY fakeKey field 15";
		assertEquals(t.execCommande(input), -1);
		input = "HDECRBY fakeKey field value";
		assertEquals(t.execCommande(input), -1);
		fillIn = "HSET key field 15";
		t.execCommande(fillIn);
		input = "HDECRBY key field 15";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testExecCommandeHDEL(){
		String input = "HDEL false";
		assertEquals(t.execCommande(input), -1);
		String fillIn = "HSET fakeKey field value";
		t.execCommande(fillIn);
		input = "HDEL fakeKey field";
		assertEquals(t.execCommande(input), -1);
		fillIn = "HSET key field 15";
		t.execCommande(fillIn);
		input = "HDEL key field";
		assertEquals(t.execCommande(input), 0);
	}
	
	@Test
	public void testUndoCommande(){
		String input = "SET damien 13";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "SET damien 13";
		t.execCommande(input);
		input = "DECR damien";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "SET damien 13";
		t.execCommande(input);
		input = "INCR damien";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "SET damien 13";
		t.execCommande(input);
		input = "DEL damien";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
	}
	
	@Test
	public void testUndoCommandeList(){
		String input = "LPUSH this is a true thing";
		assertEquals(t.execCommande(input), 0);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "RPUSH this is a true thing";
		assertEquals(t.execCommande(input), 0);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
	}
	
	@Test
	public void testUndoCommandSet(){
		String input = "SADD key val1 val2 val3";
		assertEquals(t.execCommande(input), 0);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "SADD key2 val1 val2 val3";
		assertEquals(t.execCommande(input), 0);
		
		input = "SADD key val4 val5 val6";
		assertEquals(t.execCommande(input), 0);
		
		input = "SUNION key key2";
		assertEquals(t.execCommande(input), 0);
		t.undoCommand(input);
		assertEquals(t.size(), 1);
	}
	
	@Test
	public void testUndoCommandHash(){
		String input = "HSET key field value";
		assertEquals(t.execCommande(input), 0);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "HSET key field value";
		t.execCommande(input);
		input = "HDECRBY key field 15";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "HSET key field value";
		t.execCommande(input);
		input = "HINCRBY key field 15";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
		
		input = "HSET key field value";
		t.execCommande(input);
		input = "HDEL key field 15";
		t.execCommande(input);
		t.undoCommand(input);
		assertEquals(t.size(), 0);
	}
	
	@Test
	public void testExecCommandeERROR(){
		String input = "ERROR";
		assertEquals(t.execCommande(input), -1);
	}
	
	@Test (expected = NullPointerException.class)
	public void testExecCommandeNull() throws NullPointerException{
		t.execCommande(null);
	}
	
	@Test
	public void testExecCommandeEMPTY(){
		String input = "  do something";
		assertEquals(t.execCommande(input), -1);
	}
	
	@Test
	public void testExecCommandeDONTEXIST(){
		String input = "notExistingCommand";
		assertEquals(t.execCommande(input), -1);
	}

}
