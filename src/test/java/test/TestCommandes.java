package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import stock.Commandes;

public class TestCommandes {
	protected Commandes c;
	
	@Before
	public void setup() {
		c = new Commandes();
	}
	
	@Test
	public void testSET(){
		assertEquals(c.SET("existing","15"),"OK");
	}
	
	@Test
	public void testGET(){
		assertEquals(this.c.GET("unexisting"),"the given key does not exists");
		this.c.SET("exists","15");
		assertEquals(this.c.GET("exists"), "15");
	}
	
	@Test
	public void testDECR(){
		assertEquals(this.c.DECR("unexisting"),"the given key does not exists");
		this.c.SET("notAnInteger","Hello");
		assertEquals(this.c.DECR("notAnInteger"), "the given value of the key is not an integer");
		this.c.SET("anInteger","15");
		assertEquals(this.c.DECR("anInteger"), "(Integer) " + 14);
	}			
	
	@Test
	public void testINCR(){
		assertEquals(this.c.INCR("unexisting"),"the given key does not exists");
		this.c.SET("notAnInteger","Hello");
		assertEquals(this.c.INCR("notAnInteger"), "the given value of the key is not an integer");
		this.c.SET("anInteger","15");
		assertEquals(this.c.INCR("anInteger"), "(Integer) " + 16);
	}
	
	@Test
	public void testDEL(){
		assertEquals(this.c.DECR("unexisting"),"the given key does not exists");
		this.c.SET("notAnInteger","Hello");
		assertEquals(this.c.DECR("notAnInteger"), "the given value of the key is not an integer");
		this.c.SET("anInteger","15");
		assertEquals(this.c.DECR("anInteger"), "(Integer) 14");
	}
	
	@Test
	public void testLPUSH(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		assertEquals(this.c.LPUSH("newList",list),"(Integer) " + 1);
		list = new LinkedList<String>();
		list.add("Scnd Elt");
		assertEquals(this.c.LPUSH("newList",list),"(Integer) " + 2);
		list = new LinkedList<String>();
		list.add("3rd Elt");
		list.add("4th Elt");
		assertEquals(this.c.LPUSH("newList",list),"(Integer) " + 4);
	}
	
	@Test
	public void testRPUSH(){
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		assertEquals(this.c.LPUSH("newList",list),"(Integer) " + 1);
		list = new LinkedList<String>();
		list.add("Scnd Elt");
		assertEquals(this.c.LPUSH("newList",list),"(Integer) " + 2);
		list = new LinkedList<String>();
		list.add("3rd Elt");
		list.add("4th Elt");
		assertEquals(this.c.LPUSH("newList",list),"(Integer) " + 4);
	}
	
	@Test
	public void testLPOP(){
		assertEquals(this.c.LPOP("notAList"),"the given key does not exists");
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		list.add("Scnd Elt");
		list.add("3rd Elt");
		list.add("4th Elt");
		this.c.LPUSH("listLPOP",list);
		assertEquals(this.c.LPOP("listLPOP"),"First Elt");
	}
	
	@Test
	public void testRPOP(){
		assertEquals(this.c.RPOP("notAList"),"the given key does not exists");
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		list.add("Scnd Elt");
		list.add("3rd Elt");
		list.add("4th Elt");
		this.c.LPUSH("listRPOP",list);
		assertEquals(this.c.RPOP("listRPOP"),"4th Elt");
	}
	
	@Test
	public void testLLEN(){
		assertEquals(this.c.LLEN("notAList"),"the given key does not exists");
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		list.add("Scnd Elt");
		list.add("3rd Elt");
		list.add("4th Elt");
		this.c.LPUSH("listLLEN",list);
		assertEquals(this.c.LLEN("listLLEN"),"4");
	}
	
	@Test
	public void testSREM(){
		assertEquals(this.c.SREM("notAList","First Elt"),"the given key does not exists");
		Set<String> set = new HashSet<String>();
		set.add("1 Elt");
		set.add("2 Elt");
		set.add("3 Elt");
		c.SADD("cle", set);
		assertEquals(this.c.SREM("cle","1 Elt"),"(Integer) 1");
		assertEquals(this.c.SREM("cle","1 Elt"),"(Integer) 0");
	}
	
	@Test
	public void testSADD(){
		// UNDONE
		Set<String> set = new HashSet<String>();
		set.add("1 Elt");
		set.add("2 Elt");
		set.add("3 Elt");
		assertEquals(c.SADD("cle", set), "(Integer) " + 3);
		set = new HashSet<String>();
		set.add("4 Elt");
		set.add("5 Elt");
		set.add("6 Elt");
		assertEquals(c.SADD("cle", set), "(Integer) " + 6);
	}
	
	@Test
	public void testSISMEMBER(){
		assertEquals(this.c.SISMEMBER("notAList","First Elt"),"the given key does not exists");
		Set<String> set = new HashSet<String>();
		set.add("1 Elt");
		set.add("2 Elt");
		set.add("3 Elt");
		c.SADD("cle", set);
		assertEquals(this.c.SISMEMBER("cle","1 Elt"),"(Integer) 1");
		assertEquals(this.c.SISMEMBER("cle","5th Elt"),"(Integer) 0");
	}
	
	@Test
	public void testSMEMBERS(){
		assertEquals(this.c.SMEMBERS("unexisting"),"the given key does not exists");
		Set<String> set = new HashSet<String>();
		set.add("1 Elt");
		set.add("2 Elt");
		set.add("3 Elt");
		c.SADD("cle", set);
		assertEquals(this.c.SMEMBERS("cle"),"[1 Elt, 3 Elt, 2 Elt]");
	}
	
	@Test
	public void testSUNION(){
		Set<String> set = new HashSet<String>();
		set.add("1 Elt");
		set.add("2 Elt");
		set.add("3 Elt");
		c.SADD("cle", set);
		assertEquals(this.c.SUNION("cle","unexisting"),"[1 Elt, 3 Elt, 2 Elt]");
		set = new HashSet<String>();
		set.add("4 Elt");
		set.add("5 Elt");
		set.add("6 Elt");
		c.SADD("cle2", set);
		assertEquals(this.c.SUNION("cle","cle2"),"[5 Elt, 6 Elt, 1 Elt, 4 Elt, 3 Elt, 2 Elt]");
	}
	
	@Test
	public void testHSET(){
		assertEquals(this.c.HSET("unexisting key", "unexisting field", "unexisting value"),"(Integer) 0");
		assertEquals(this.c.HSET("key", "field", "value"),"(Integer) 0");
		assertEquals(this.c.HSET("key", "field", "other value"),"(Integer) 0");
		assertEquals(this.c.HSET("key", "other field", "other value"),"(Integer) 1");
	}
	
	@Test
	public void testHGETALL(){
		assertEquals(this.c.HGETALL("unexisting"),"the given key does not exists");
		this.c.HSET("key", "field", "value");
		assertEquals(this.c.HGETALL("key"),"{field=value}");
	}
	
	@Test
	public void testHGET(){
		assertEquals(this.c.HGET("unexisting","field"),"the given key does not exists");
		this.c.HSET("key", "field", "value");
		assertEquals(this.c.HGET("key","not a field"),"the given field does not exist");
		assertEquals(this.c.HGET("key", "field"),"field" + " " + "value");
	}
	
	@Test
	public void testHINCRBY(){
		assertEquals(this.c.HINCRBY("unexisting","field","15"),"the given key does not exists");
		this.c.HSET("key", "field", "value");
		assertEquals(this.c.HINCRBY("key","not a field","15"),"the given field does not exist");
		assertEquals(this.c.HINCRBY("key", "field","15"),"the given field is not an integer");
		this.c.HSET("key", "integer", "15");
		assertEquals(this.c.HINCRBY("key", "integer","15"),"integer" + " (Integer) " + 30);
	}
	
	@Test
	public void testHDECRBY(){
		assertEquals(this.c.HDECRBY("unexisting","field","15"),"the given key does not exists");
		this.c.HSET("key", "field", "value");
		assertEquals(this.c.HDECRBY("key","not a field","15"),"the given field does not exist");
		assertEquals(this.c.HDECRBY("key", "field","15"),"the given field is not an integer");
		this.c.HSET("key", "integer", "15");
		assertEquals(this.c.HDECRBY("key", "integer","15"),"integer" + " (Integer) " + 0);
	}
	
	@Test
	public void testHDEL(){
		assertEquals(this.c.HDEL("unexisting","field"),"the given key does not exists");
		this.c.HSET("key", "field", "value");
		assertEquals(this.c.HDEL("key","not a field"),"the given field does not exist");
		assertEquals(this.c.HDEL("key", "field"),"the given field is not an integer");
		this.c.HSET("key", "integer", "15");
		assertEquals(this.c.HDEL("key", "integer"),"integer" + " (Integer) 0");
	}

}
