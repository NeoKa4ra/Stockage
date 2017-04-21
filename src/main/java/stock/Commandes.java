package stock;


import java.util.LinkedList;
import java.util.HashMap;

public class Commandes implements CommandeItf<String>{
	HashMap<String, LinkedList<String>> stock;
	
	public Commandes(){
		stock = new HashMap<String,LinkedList<String>>();
	}

	public String GET(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SET(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String DECR(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String INCR(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String DEL(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String LPUSH(String key, LinkedList<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String RPUSH(String key, LinkedList<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String LPOP(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String RPOP(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String LLEN(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SREM(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SADD(String key, LinkedList<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SISMEMBER(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SMEMBERS(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String SUNION(String key1, String key2) {
		// TODO Auto-generated method stub
		return null;
	}

	public String HSET(String key, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String HGETALL(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public String HGET(String key, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	public String HINCRBY(String key, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	public String HDEL(String key) {
		// TODO Auto-generated method stub
		return null;
	}


}
