package java.stock;


import java.util.LinkedList;
import java.util.Set;
import java.stock.CommandeItf;
import java.util.HashMap;

public class Commandes implements CommandeItf<String>{
	HashMap<String, String> stockString;
	HashMap<String, LinkedList<String>> stockList;
	HashMap<String, Set<String>> stockSet;
	HashMap<String, HashMap<String,String>> stockHash;
	
	
	public Commandes(){
		stockString = new HashMap<String,String>();
		stockList = new HashMap<String,LinkedList<String>>();
		stockSet = new HashMap<String, Set<String>>();
		stockHash = new HashMap<String, HashMap<String,String>>();		
	}
	
	public int size(){
		int size = 0;
		size += stockString.size();
		size += stockList.size();
		size += stockSet.size();
		size += stockHash.size();
		return size;
	}
	
	public void removeString(String key){
		stockString.remove(key);
	}
	
	public void removeList(String key){
		stockList.remove(key);
	}
	
	public void removeSet(String key){
		stockList.remove(key);
	}
	
	public void removeHash(String key){
		stockList.remove(key);
	}
	

	public String GET(String key) {
		if(stockString.containsKey(key)){
			synchronized (stockString) {
				return stockString.get(key);
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String SET(String key, String value) {

		stockString.put(key, value);
		return "OK";		
	}

	public String DECR(String key) {
		
		if(stockString.containsKey(key)){			
			if(isInteger(stockString.get(key))){
				synchronized (stockString) {
					int tmp = Integer.parseInt(stockString.get(key));
					tmp--;
					stockString.put(key, String.valueOf(tmp));
					return "(Integer) " + tmp;
				}			
			}else{
				return "the given value of the key is not an integer";
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String INCR(String key) {
		
		if(stockString.containsKey(key)){			
			if(isInteger(stockString.get(key))){
				synchronized (stockString) {
					int tmp = Integer.parseInt(stockString.get(key));
					tmp++;
					stockString.put(key, String.valueOf(tmp));
					return "(Integer) " + tmp;
				}
			}else{
				return "the given value of the key is not an integer";
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String DEL(String key) {
		
		if(stockString.containsKey(key)){			
			if(isInteger(stockString.get(key))){				
				synchronized (stockString) {
					stockString.put(key, "0");				
					return "(Integer) 0";
				}
			}else{
				return "the given value of the key is not an integer";
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String LPUSH(String key, LinkedList<String> value) {
		if(stockList.containsKey(key)){
			synchronized (stockList) {
				LinkedList<String> tmp = stockList.get(key);
				value.addAll(tmp);
				stockList.put(key, value);
				return "(Integer) " + stockList.get(key).size();
			}
		}else{			
			stockList.put(key, value);
			return "(Integer) " + stockList.get(key).size();
			
		}
	}

	public String RPUSH(String key, LinkedList<String> value) {
		if(stockList.containsKey(key)){
			synchronized (stockList) {
				LinkedList<String> tmp = stockList.get(key);
				tmp.addAll(value);
				stockList.put(key, tmp);
				return "(Integer) " + stockList.get(key).size();
			}
		}else{		
			stockList.put(key, value);
			return "(Integer) " + stockList.get(key).size();			
		}
	}

	public String LPOP(String key) {
		if(stockList.containsKey(key)){
			synchronized (stockList) {
				String tmp = stockList.get(key).removeFirst();
				return tmp;
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String RPOP(String key) {
		if(stockList.containsKey(key)){
			synchronized (stockList) {
				String tmp = stockList.get(key).removeLast();
				return tmp;
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String LLEN(String key) {
		if(stockList.containsKey(key)){			
			synchronized (stockList) {
				return String.valueOf(stockList.get(key).size());
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String SREM(String key, String value) {
		if(stockSet.containsKey(key)){
			synchronized (stockSet) {
				Set<String> tmp = stockSet.get(key);
				if(tmp.contains(value)){
					stockSet.get(key).remove(value);
					return "(Integer) 1";
				}else{
					return "(Integer) 0";				
				}
			}
		}else{
			return "the given key does not exists";
		}
	}

	public String SADD(String key, Set<String> value) {
		
		if(stockSet.containsKey(key)){	
			synchronized (stockSet) {
				stockSet.get(key).addAll(value);
				return "(Integer) " + stockSet.get(key).size();
			}
		}else{
			stockSet.put(key, value);
			return "(Integer) " + stockSet.get(key).size(); 
		}
		
	}

	public String SISMEMBER(String key, String value) {
				
		if(stockSet.containsKey(key)){
			synchronized (stockSet) {
				if(stockSet.get(key).contains(value)){
					return "(Integer) 1";
				}else{
					return "(Integer) 0";
				}
			}
		}else{
			return "the given key does not exists";
		}
		
	}

	public String SMEMBERS(String key) {
				
		if(stockSet.containsKey(key)){
			synchronized (stockSet) {
				return stockSet.get(key).toString();
			}
		}else{
			return "the given key does not exists";
		}
		
	}

	public String SUNION(String key1, String key2) {
				
		if(stockSet.containsKey(key2)){
			stockSet.get(key1).addAll(stockSet.get(key2));
			return stockSet.get(key1).toString();
		}else{
			return stockSet.get(key1).toString();			
		}
		
	}

	public String HSET(String key, String field, String value) {
		
		if(stockHash.containsKey(key)){
			synchronized (stockHash) {
				if(stockHash.get(key).containsKey(field)){	
					stockHash.get(key).put(field, value);
					return "(Integer) 0";
				}else{
					stockHash.get(key).put(field, value);
					return "(Integer) 1";
				}
			}
		}else{
			HashMap<String,String> tmp = new HashMap<String,String>();
			tmp.put(field, value);
			stockHash.put(key,tmp);
			return "(Integer) 0";
		}		
	}

	public String HGETALL(String key) {		
		
		if(stockHash.containsKey(key)){
			synchronized (stockHash) {
				return stockHash.get(key).toString();
			}
		}else{
			return "the given key does not exists";
		}
						
	}

	public String HGET(String key, String field) {
		
		if(stockHash.containsKey(key)){
			synchronized (stockHash) {
				if(stockHash.get(key).containsKey(field)){
					return field + " " + stockHash.get(key).get(field);
				}else{
					return "the given field does not exist";
				}
			}
		}else{
			return "the given key does not exists"; 
		}
		
	}

	public String HINCRBY(String key, String field, String value) {
		
		if(stockHash.containsKey(key)){
			synchronized (stockHash) {
				if(stockHash.get(key).containsKey(field)){
					if(isInteger(stockHash.get(key).get(field))){
						
						int tmp = Integer.parseInt(stockHash.get(key).get(field));
						tmp += Integer.parseInt(value);
						stockHash.get(key).put(field, String.valueOf(tmp));
						return field + " (Integer) " + tmp;
						
					}else{
						return "the given field is not an integer";
					}
				}else{
					return "the given field does not exist";
				}
			}
		}else{
			return "the given key does not exists"; 
		}
			
		
	}
	public String HDECRBY(String key,String field,  String value) {
	
		if(stockHash.containsKey(key)){
			synchronized (stockHash) {
				if(stockHash.get(key).containsKey(field)){
					if(isInteger(stockHash.get(key).get(field))){
						
						int tmp = Integer.parseInt(stockHash.get(key).get(field));
						tmp -= Integer.parseInt(value);
						stockHash.get(key).put(field, String.valueOf(tmp));
						return field + " (Integer) " + tmp;
						
					}else{
						return "the given field is not an integer";
					}
				}else{
					return "the given field does not exist";
				}
			}
		}else{
			return "the given key does not exists"; 
		}
			
	}

	public String HDEL(String key, String field) {
		
		if(stockHash.containsKey(key)){
			synchronized (stockHash) {
				if(stockHash.get(key).containsKey(field)){
					if(isInteger(stockHash.get(key).get(field))){
						
						stockHash.get(key).put(field, "0");
						return field + " (Integer) 0";
						
					}else{
						return "the given field is not an integer";
					}
				}else{
					return "the given field does not exist";
				}
			}
		}else{
			return "the given key does not exists"; 
		}			
		
	}

	private boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    
	    return true;
	}
	

}
