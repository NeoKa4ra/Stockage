package stock;

import java.util.LinkedList;

public interface CommandeItf<T> {


	public String GET(String key); 
	public String SET(String key, String value);
	
	public String DECR(String key); 
	public String INCR(String key);
	public String DEL(String key);
		
	public String LPUSH(String key, LinkedList<T> value); //push left 
	public String RPUSH(String  key, LinkedList<T> value);//push right  
	public String LPOP(String key); 
	public String RPOP(String key); 
	public String LLEN(String key); 
	
	
	public String SREM(String key); 
	public String SADD(String key, LinkedList<String> value); 
	public String SISMEMBER(String key, T value); 
	public String SMEMBERS(String key);
	public String SUNION(String key1, String key2);
	 
	public String HSET(String key,String field, T value);
	public T HGETALL(String key);
	//public String HMSET(String key, LinkedList<String> value);
	public String HGET(String key, String field);
	public String HINCRBY(String key, int value);
	public String HDEL(String key);


}
