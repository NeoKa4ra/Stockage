package stock;

import java.util.ArrayList;

public interface CommandeItf<T> {

	public String LPUSH(String key, ArrayList<T> value); 
	public String RPUSH(String  key, ArrayList<T> value); 
	public String LPUSHX(String key, ArrayList<T> value); 
	public String RPUSHX(String key, ArrayList<T> value); 

	public String LINSERT(String key, String mode, T value, T insert); 
	public String LPOP(String key); 
	public String RPOP(String key); 
	public String LLEN(String key); 
	public String LSET(String key, int index, T value); 
	public String SREM(String key, ArrayList<String> value); 
	
	public String APPEND(String key, T value); 
	public String DECR(String key); 
	public String INCR(String key); 

}
