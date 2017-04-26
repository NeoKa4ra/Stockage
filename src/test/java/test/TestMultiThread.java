package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import stock.Commandes;

public class TestMultiThread {
	protected Commandes c;
	
	@Before
	public void setup() {
		c = new Commandes();
	}
	
	@Test
	public void testMultiThreadIncr(){
		TestThread t1 = new TestThread();
		TestThread t2 = new TestThread();
		
		c.SET("key","15");
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(c.GET("key"), "215");
	}
	
	public class TestThread extends Thread {
		  public TestThread(){
		    super();
		  }
		  public void run(){
			  for(int i=0;i<100;i++){
					c.INCR("key");
			  }
			  System.out.println("done");
		  }
		  
		}
}
