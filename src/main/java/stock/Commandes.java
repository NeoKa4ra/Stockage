package stock;


import java.util.LinkedList;
import java.util.HashMap;

public class Commandes implements CommandeItf<String>{
	HashMap<String, LinkedList<String>> stock;
	
	public Commandes(){
		stock = new HashMap<String,LinkedList<String>>();
	}

	@Override
	public String LPUSH(String key, LinkedList<String> value) {
		if(stock.containsKey(key)){	
			LinkedList<String> list = stock.get(key);
			value.addAll(list);
			stock.put(key, value);
			
			return String.valueOf(value.size());
		}else{
			stock.put(key, value);
			return String.valueOf(value.size());
		}
	}
	@Override
	public String RPUSH(String key, LinkedList<String> value) {
		if(stock.containsKey(key)){	
			LinkedList<String> list = stock.get(key);
			list.addAll(value);
			stock.put(key, list);
			
			return String.valueOf(list.size());
		}else{
			stock.put(key, value);
			return String.valueOf(value.size());
		}
		
	}

	@Override
	public String LPUSHX(String key, LinkedList<String> value) {
		if(stock.containsKey(key)){	
			LinkedList<String> list = stock.get(key);
			value.addAll(list);
			stock.put(key, value);
			
			return String.valueOf(value.size());
		}else{
			return "0";
		}
	}

	@Override
	public String RPUSHX(String key, LinkedList<String> value) {
		if(stock.containsKey(key)){	
			LinkedList<String> list = stock.get(key);
			list.addAll(value);
			stock.put(key, list);
			
			return String.valueOf(list.size());
		}else{
			return "0";
		}
	}

	@Override
	public String LINSERT(String key, String mode, String value, String insert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String LPOP(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String RPOP(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String LLEN(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String LSET(String key, int index, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SREM(String key, LinkedList<String> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String APPEND(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DECR(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String INCR(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
