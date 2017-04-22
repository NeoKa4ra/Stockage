package test;

import java.util.LinkedList;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import stock.Commandes;

public class TestCommandes extends TestCase {
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
		assertEquals(this.c.DECR("unexisting"),"the given key does not exists");
		this.c.SET("notAnInteger","Hello");
		assertEquals(this.c.DECR("notAnInteger"), "the given value of the key is not an integer");
		this.c.SET("anInteger","15");
		assertEquals(this.c.DECR("anInteger"), "(Integer) " + 16);
	}
	
	@Test
	public void testDEL(){
		assertEquals(this.c.DECR("unexisting"),"the given key does not exists");
		this.c.SET("notAnInteger","Hello");
		assertEquals(this.c.DECR("notAnInteger"), "the given value of the key is not an integer");
		this.c.SET("anInteger","15");
		assertEquals(this.c.DECR("anInteger"), "(Integer) 0");
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
		assertEquals(this.c.LLEN("listLLEN"),4);
	}
	
	@Test
	public void testSREM(){
		assertEquals(this.c.SREM("notAList","First Elt"),"the given key does not exists");
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		list.add("Scnd Elt");
		list.add("3rd Elt");
		list.add("4th Elt");
		this.c.LPUSH("list",list);
		assertEquals(this.c.SREM("list","First Elt"),"(Integer) 1");
		assertEquals(this.c.SREM("list","First Elt"),"(Integer) 0");
	}
	
	@Test
	public void testSADD(){
		// UNDONE
	}
	
	@Test
	public void testSISMEMBER(){
		assertEquals(this.c.SISMEMBER("notAList","First Elt"),"the given key does not exists");
		LinkedList<String> list = new LinkedList<String>();
		list.add("First Elt");
		list.add("Scnd Elt");
		list.add("3rd Elt");
		list.add("4th Elt");
		this.c.LPUSH("list",list);
		assertEquals(this.c.SISMEMBER("list","First Elt"),"(Integer) 1");
		assertEquals(this.c.SISMEMBER("list","5th Elt"),"(Integer) 0");
	}
	
	@Test
	public void testSMEMBERS(){
		assertEquals(this.c.GET("unexisting"),"the given key does not exists");
		// Not full done
	}
	
	@Test
	public void testSUNION(){
		assertEquals(this.c.GET("unexisting"),"the given key does not exists");
		// Not full done
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
		// UNDONE
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
