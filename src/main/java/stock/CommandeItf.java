package stock;

import java.util.LinkedList;

public interface CommandeItf<T> {

	public String LPUSH(String key, LinkedList<T> value); //push left 
	public String RPUSH(String  key, LinkedList<T> value);//push right 
	public String LPUSHX(String key, LinkedList<T> value); //push left if exist
	public String RPUSHX(String key, LinkedList<T> value); //push right if exist

	public String LINSERT(String key, String mode, T value, T insert); 
	public String LPOP(String key); 
	public String RPOP(String key); 
	public String LLEN(String key); 
	public String LSET(String key, int index, T value); 
	public String SREM(String key, LinkedList<String> value); 
	
	public String APPEND(String key, T value); 
	public String DECR(String key); 
	public String INCR(String key);


}
