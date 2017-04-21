package stock;

import java.util.LinkedList;
import java.util.Set;

public interface CommandeItf<T> {


	public String GET(String key); 
	public String SET(String key, String value);
	
	public String DECR(String key); 
	public String INCR(String key);
	public String DEL(String key);
		
	public String LPUSH(String key, LinkedList<T> value); 
	public String RPUSH(String  key, LinkedList<T> value);
	public String LPOP(String key); 
	public String RPOP(String key); 
	public String LLEN(String key); 
	
	
	public String SREM(String key, String value); 
	public String SADD(String key, Set<String> value); 
	public String SISMEMBER(String key, T value); 
	public String SMEMBERS(String key);
	public String SUNION(String key1, String key2);
	 
	public String HSET(String key,String field, T value);
	public T HGETALL(String key);
	public String HGET(String key, String field);
	public String HINCRBY(String key, String field, String value);
	public String HDECRBY(String key, String field, String value);
	public String HDEL(String key, String field);


}
